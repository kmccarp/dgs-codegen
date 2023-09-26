package com.netflix.graphql.dgs.codegen.cases.dataclasswithmappedinterfaces.expected.client

import com.netflix.graphql.dgs.codegen.GraphQLProjection

public class EntityProjection : GraphQLProjection() {
  public val id: EntityProjection
    get() {
      field("id")
      return this
    }

  public fun onProduct(projection: ProductProjection.() -> ProductProjection): EntityProjection {
    fragment("Product", ProductProjection(), projection)
    return this
  }
}
