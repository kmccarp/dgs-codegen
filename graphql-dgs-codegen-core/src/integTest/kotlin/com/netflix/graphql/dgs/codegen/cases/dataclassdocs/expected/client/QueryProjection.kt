package com.netflix.graphql.dgs.codegen.cases.dataclassdocs.expected.client

import com.netflix.graphql.dgs.codegen.GraphQLProjection
import com.netflix.graphql.dgs.codegen.cases.dataClassDocs.expected.types.MovieFilter

public class QueryProjection : GraphQLProjection() {
  public fun search(movieFilter: MovieFilter, projection: MovieProjection.() -> MovieProjection):
      QueryProjection {
    field("search", MovieProjection(), projection, "movieFilter" to movieFilter)
    return this
  }
}
