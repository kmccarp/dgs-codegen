package com.netflix.graphql.dgs.codegen.cases.dataClassWithDeclaredScalars.expected.client

import com.netflix.graphql.dgs.codegen.GraphQLProjection

public class EntityConnectionProjection : GraphQLProjection() {
  public fun pageInfo(projection: PageInfoProjection.() -> PageInfoProjection):
      EntityConnectionProjection {
    field("pageInfo", PageInfoProjection(), projection)
    return this
  }

  public fun edges(_projection: EntityEdgeProjection.() -> EntityEdgeProjection):
      EntityConnectionProjection {
    field("edges", EntityEdgeProjection(), _projection)
    return this
  }
}
