package com.netflix.graphql.dgs.codegen.cases.projectionwithprimitives.expected.client

import com.netflix.graphql.dgs.codegen.GraphQLProjection

public class QueryProjection : GraphQLProjection() {
  public val string: QueryProjection
    get() {
      field("string")
      return this
    }

  public val strings: QueryProjection
    get() {
      field("strings")
      return this
    }
}
