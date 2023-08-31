package com.netflix.graphql.dgs.codegen.cases.constantswithextendedinterface.expected

import com.netflix.graphql.dgs.codegen.GraphQLProjection
import com.netflix.graphql.dgs.codegen.cases.constantswithextendedinterface.expected.client.QueryProjection
import graphql.language.OperationDefinition
import kotlin.String

public object DgsClient {
  public fun buildQuery(projection: QueryProjection.() -> QueryProjection): String =
      GraphQLProjection.asQuery(OperationDefinition.Operation.QUERY, QueryProjection(), projection)
}
