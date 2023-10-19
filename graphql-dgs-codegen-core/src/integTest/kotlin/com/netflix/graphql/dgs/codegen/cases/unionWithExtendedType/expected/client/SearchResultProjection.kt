package com.netflix.graphql.dgs.codegen.cases.unionWithExtendedType.expected.client

import com.netflix.graphql.dgs.codegen.GraphQLProjection

public class SearchResultProjection : GraphQLProjection() {
  public fun onMovie(projection: MovieProjection.() -> MovieProjection): SearchResultProjection {
    fragment("Movie", MovieProjection(), projection)
    return this
  }

  public fun onActor(projection: ActorProjection.() -> ActorProjection): SearchResultProjection {
    fragment("Actor", ActorProjection(), projection)
    return this
  }

  public fun onRating(projection: RatingProjection.() -> RatingProjection):
      SearchResultProjection {
    fragment("Rating", RatingProjection(), projection)
    return this
  }
}
