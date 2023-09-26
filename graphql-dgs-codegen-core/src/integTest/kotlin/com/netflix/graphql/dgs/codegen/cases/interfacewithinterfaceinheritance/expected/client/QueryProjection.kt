package com.netflix.graphql.dgs.codegen.cases.interfacewithinterfaceinheritance.expected.client

import com.netflix.graphql.dgs.codegen.GraphQLProjection

public class QueryProjection : GraphQLProjection() {
  public fun fruits(projection: FruitProjection.() -> FruitProjection): QueryProjection {
    field("fruits", FruitProjection(), projection)
    return this
  }
}
