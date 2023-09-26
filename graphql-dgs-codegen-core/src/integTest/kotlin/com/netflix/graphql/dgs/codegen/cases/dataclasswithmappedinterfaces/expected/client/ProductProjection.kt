package com.netflix.graphql.dgs.codegen.cases.dataclasswithmappedinterfaces.expected.client

import com.netflix.graphql.dgs.codegen.GraphQLProjection

public class ProductProjection : GraphQLProjection() {
  public val id: ProductProjection
    get() {
      field("id")
      return this
    }
}
