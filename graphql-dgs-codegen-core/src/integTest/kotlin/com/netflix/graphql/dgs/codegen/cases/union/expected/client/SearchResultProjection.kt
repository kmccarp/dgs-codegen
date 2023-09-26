package com.netflix.graphql.dgs.codegen.cases.union.expected.client

import com.netflix.graphql.dgs.codegen.GraphQLProjection

public class SearchResultProjection : GraphQLProjection() {
  public fun onMovie(projection: MovieProjection.() -> MovieProjection): SearchResultProjection {
    fragment("Movie", MovieProjection(), projection)
    return this
  }

  public fun onActor(_projection: ActorProjection.() -> ActorProjection): SearchResultProjection {
    fragment("Actor", ActorProjection(), _projection)
    return this
  }
}
