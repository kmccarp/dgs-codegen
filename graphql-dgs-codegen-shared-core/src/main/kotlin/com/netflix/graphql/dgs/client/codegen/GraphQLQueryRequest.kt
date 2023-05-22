/*
 * Copyright 2022 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netflix.graphql.dgs.client.codegen

import graphql.language.Argument
import graphql.language.AstPrinter
import graphql.language.Field
import graphql.language.OperationDefinition
import graphql.language.SelectionSet
import graphql.schema.Coercing

class GraphQLQueryRequest @JvmOverloads constructor(
    val query: GraphQLQuery,
    val projection: BaseProjectionNode?,
    val inputValueSerializer: InputValueSerializerInterface
) {

    private var selectionSet: SelectionSet? = null

    @JvmOverloads constructor(query: GraphQLQuery, selectionSet: SelectionSet, scalars: Map<Class<*>, Coercing<*, *>>? = null) : this(query = query, projection = null, inputValueSerializer = InputValueSerializer(scalars ?: emptyMap())) {
        this.selectionSet = selectionSet
    }

    val projectionSerializer = ProjectionSerializer(inputValueSerializer ?: InputValueSerializer(emptyMap()))

    fun serialize(): String {
        val operationDef = OperationDefinition.newOperationDefinition()

        query.name?.let { operationDef.name(it) }
        query.getOperationType()?.let { operationDef.operation(OperationDefinition.Operation.valueOf(it.uppercase())) }

        if (query.variableDefinitions.isNotEmpty()) {
            operationDef.variableDefinitions(query.variableDefinitions)
        }

        val selection = Field.newField(query.getOperationName())
        if (query.input.isNotEmpty()) {
            selection.arguments(
                query.input.map { (name, value) ->
                    Argument(name, inputValueSerializer.toValue(value))
                }
            )
        }

        if (projection != null) {
            val selectionSetFromProjection = if (projection is BaseSubProjectionNode<*, *> && projection.root() != null) {
                projectionSerializer.toSelectionSet(projection.root() as BaseProjectionNode)
            } else {
                projectionSerializer.toSelectionSet(projection)
            }
            if (selectionSetFromProjection.selections.isNotEmpty()) {
                selection.selectionSet(selectionSetFromProjection)
            }
        }

        if (selectionSet != null) {
            selection.selectionSet(selectionSet)
        }

        operationDef.selectionSet(SelectionSet.newSelectionSet().selection(selection.build()).build())

        return AstPrinter.printAst(operationDef.build())
    }
}
