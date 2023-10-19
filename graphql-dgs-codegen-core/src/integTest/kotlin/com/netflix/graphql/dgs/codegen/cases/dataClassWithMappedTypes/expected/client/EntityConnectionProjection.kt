package com.netflix.graphql.dgs.codegen.cases.dataClassWithMappedTypes.expected.client

import com.netflix.graphql.dgs.codegen.GraphQLProjection

public class EntityConnectionProjection : GraphQLProjection() {
  public fun pageInfo(projection: PageInfoProjection.() -> PageInfoProjection):
      EntityConnectionProjection {
    field("pageInfo", PageInfoProjection(), projection)
    return this
  }

  public fun edges(projection: EntityEdgeProjection.() -> EntityEdgeProjection):
      EntityConnectionProjection {
    field("edges", EntityEdgeProjection(), projection)
    return this
  }
}
