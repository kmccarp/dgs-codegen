package com.netflix.graphql.dgs.codegen.cases.dataclasswithmappedinterfaces.expected.client

import com.netflix.graphql.dgs.codegen.GraphQLProjection

public class QueryProjection : GraphQLProjection() {
  public fun products(projection: ProductProjection.() -> ProductProjection): QueryProjection {
    field("products", ProductProjection(), projection)
    return this
  }
}
