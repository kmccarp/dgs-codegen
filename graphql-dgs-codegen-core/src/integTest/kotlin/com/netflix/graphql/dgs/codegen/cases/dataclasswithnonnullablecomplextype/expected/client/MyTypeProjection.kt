package com.netflix.graphql.dgs.codegen.cases.dataclasswithnonnullablecomplextype.expected.client

import com.netflix.graphql.dgs.codegen.GraphQLProjection

public class MyTypeProjection : GraphQLProjection() {
  public fun other(projection: OtherTypeProjection.() -> OtherTypeProjection): MyTypeProjection {
    field("other", OtherTypeProjection(), projection)
    return this
  }
}
