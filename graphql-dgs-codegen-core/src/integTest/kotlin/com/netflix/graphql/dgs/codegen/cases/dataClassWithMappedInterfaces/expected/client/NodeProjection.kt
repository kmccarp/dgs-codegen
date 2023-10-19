package com.netflix.graphql.dgs.codegen.cases.dataClassWithMappedInterfaces.expected.client

import com.netflix.graphql.dgs.codegen.GraphQLProjection

public class NodeProjection : GraphQLProjection() {
  public val id: NodeProjection
    get() {
      field("id")
      return this
    }

  public fun onEntity(projection: EntityProjection.() -> EntityProjection): NodeProjection {
    fragment("Entity", EntityProjection(), projection)
    return this
  }

  public fun onProduct(projection: ProductProjection.() -> ProductProjection): NodeProjection {
    fragment("Product", ProductProjection(), projection)
    return this
  }
}
