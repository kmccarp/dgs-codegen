package com.netflix.graphql.dgs.codegen.cases.dataclasswithnonnullableproperties.expected

import com.netflix.graphql.dgs.codegen.GraphQLProjection
import com.netflix.graphql.dgs.codegen.cases.dataclasswithnonnullableproperties.expected.client.QueryProjection
import graphql.language.OperationDefinition
import kotlin.String

public object DgsClient {
  public fun buildQuery(projection: QueryProjection.() -> QueryProjection): String =
      GraphQLProjection.asQuery(OperationDefinition.Operation.QUERY, QueryProjection(), projection)
}
