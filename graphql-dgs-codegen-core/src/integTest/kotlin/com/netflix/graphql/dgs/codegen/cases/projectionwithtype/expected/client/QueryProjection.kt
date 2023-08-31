package com.netflix.graphql.dgs.codegen.cases.projectionwithtype.expected.client

import com.netflix.graphql.dgs.codegen.GraphQLProjection

public class QueryProjection : GraphQLProjection() {
  public fun person(projection: PersonProjection.() -> PersonProjection): QueryProjection {
    field("person", PersonProjection(), projection)
    return this
  }

  public fun people(_projection: PersonProjection.() -> PersonProjection): QueryProjection {
    field("people", PersonProjection(), _projection)
    return this
  }
}
