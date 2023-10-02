package com.netflix.graphql.dgs.codegen.cases.dataClassWithBooleanField.expected.client

import com.netflix.graphql.dgs.codegen.GraphQLProjection

public class QueryProjection : GraphQLProjection() {
  public fun test(projection: RequiredTestTypeProjection.() -> RequiredTestTypeProjection):
      QueryProjection {
    field("test", RequiredTestTypeProjection(), projection)
    return this
  }
}
