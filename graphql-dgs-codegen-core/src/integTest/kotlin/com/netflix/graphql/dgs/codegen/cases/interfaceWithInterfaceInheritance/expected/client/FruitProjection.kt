package com.netflix.graphql.dgs.codegen.cases.interfaceWithInterfaceInheritance.expected.client

import com.netflix.graphql.dgs.codegen.GraphQLProjection

public class FruitProjection : GraphQLProjection() {
  public fun seeds(projection: SeedProjection.() -> SeedProjection): FruitProjection {
    field("seeds", SeedProjection(), projection)
    return this
  }

  public fun onStoneFruit(_projection: StoneFruitProjection.() -> StoneFruitProjection):
      FruitProjection {
    fragment("StoneFruit", StoneFruitProjection(), _projection)
    return this
  }
}
