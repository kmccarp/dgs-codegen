package com.netflix.graphql.dgs.codegen.cases.dataclasswithdeeplynestedcomplexfield.expected.client

import com.netflix.graphql.dgs.codegen.GraphQLProjection

public class CarProjection : GraphQLProjection() {
  public val make: CarProjection
    get() {
      field("make")
      return this
    }

  public val model: CarProjection
    get() {
      field("model")
      return this
    }

  public fun engine(projection: EngineProjection.() -> EngineProjection): CarProjection {
    field("engine", EngineProjection(), projection)
    return this
  }
}
