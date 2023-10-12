package com.netflix.graphql.dgs.codegen.cases.constantsWithExtendedTypes.expected.client

import com.netflix.graphql.dgs.codegen.GraphQLProjection

public class QueryProjection : GraphQLProjection() {
  public fun people(projection: PersonProjection.() -> PersonProjection): QueryProjection {
    field("people", PersonProjection(), projection)
    return this
  }
}
