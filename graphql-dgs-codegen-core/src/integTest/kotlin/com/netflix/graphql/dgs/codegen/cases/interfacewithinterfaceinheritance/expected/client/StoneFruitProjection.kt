package com.netflix.graphql.dgs.codegen.cases.interfacewithinterfaceinheritance.expected.client

import com.netflix.graphql.dgs.codegen.GraphQLProjection

public class StoneFruitProjection : GraphQLProjection() {
  public val fuzzy: StoneFruitProjection
    get() {
      field("fuzzy")
      return this
    }

  public fun seeds(projection: SeedProjection.() -> SeedProjection): StoneFruitProjection {
    field("seeds", SeedProjection(), projection)
    return this
  }
}
