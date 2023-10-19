package com.netflix.graphql.dgs.codegen.cases.dataClassWithMappedTypes.expected.client

import com.netflix.graphql.dgs.codegen.GraphQLProjection

public class EntityEdgeProjection : GraphQLProjection() {
  public val cursor: EntityEdgeProjection
    get() {
      field("cursor")
      return this
    }

  public fun node(projection: EntityProjection.() -> EntityProjection): EntityEdgeProjection {
    field("node", EntityProjection(), projection)
    return this
  }
}
