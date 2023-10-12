package com.netflix.graphql.dgs.codegen.cases.unionTypesWithoutInterfaceCanDeserialize.expected.client

import com.netflix.graphql.dgs.codegen.GraphQLProjection

public class SearchResultPageProjection : GraphQLProjection() {
  public fun items(projection: SearchResultProjection.() -> SearchResultProjection):
      SearchResultPageProjection {
    field("items", SearchResultProjection(), projection)
    return this
  }
}
