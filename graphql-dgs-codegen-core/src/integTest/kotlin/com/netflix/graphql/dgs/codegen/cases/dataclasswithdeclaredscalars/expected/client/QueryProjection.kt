package com.netflix.graphql.dgs.codegen.cases.dataclasswithdeclaredscalars.expected.client

import com.netflix.graphql.dgs.codegen.GraphQLProjection

public class QueryProjection : GraphQLProjection() {
  public fun entity(projection: EntityProjection.() -> EntityProjection): QueryProjection {
    field("entity", EntityProjection(), projection)
    return this
  }

  public
      fun entityConnection(_projection: EntityConnectionProjection.() -> EntityConnectionProjection):
      QueryProjection {
    field("entityConnection", EntityConnectionProjection(), _projection)
    return this
  }
}
