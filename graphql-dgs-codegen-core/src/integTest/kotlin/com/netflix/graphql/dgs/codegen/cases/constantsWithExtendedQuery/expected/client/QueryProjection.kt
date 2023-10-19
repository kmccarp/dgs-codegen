package com.netflix.graphql.dgs.codegen.cases.constantsWithExtendedQuery.expected.client

import com.netflix.graphql.dgs.codegen.GraphQLProjection

public class QueryProjection : GraphQLProjection() {
  public fun people(projection: PersonProjection.() -> PersonProjection): QueryProjection {
    field("people", PersonProjection(), projection)
    return this
  }

  public fun friends(projection: PersonProjection.() -> PersonProjection): QueryProjection {
    field("friends", PersonProjection(), projection)
    return this
  }
}
