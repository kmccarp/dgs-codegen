package com.netflix.graphql.dgs.codegen.cases.constantswithextendedquery.expected.client

import com.netflix.graphql.dgs.codegen.GraphQLProjection

public class QueryProjection : GraphQLProjection() {
  public fun people(projection: PersonProjection.() -> PersonProjection): QueryProjection {
    field("people", PersonProjection(), projection)
    return this
  }

  public fun friends(_projection: PersonProjection.() -> PersonProjection): QueryProjection {
    field("friends", PersonProjection(), _projection)
    return this
  }
}
