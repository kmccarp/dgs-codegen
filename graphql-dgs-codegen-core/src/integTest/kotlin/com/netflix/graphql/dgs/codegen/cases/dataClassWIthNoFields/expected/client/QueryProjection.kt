package com.netflix.graphql.dgs.codegen.cases.dataClassWIthNoFields.expected.client

import com.netflix.graphql.dgs.codegen.GraphQLProjection

public class QueryProjection : GraphQLProjection() {
  public fun me(projection: PersonProjection.() -> PersonProjection): QueryProjection {
    field("me", PersonProjection(), projection)
    return this
  }
}
