package com.netflix.graphql.dgs.codegen.cases.unionwithextendedtype.expected.client

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

  public fun onRating(_projection: RatingProjection.() -> RatingProjection):
      SearchResultProjection {
    fragment("Rating", RatingProjection(), _projection)
    return this
  }
}
