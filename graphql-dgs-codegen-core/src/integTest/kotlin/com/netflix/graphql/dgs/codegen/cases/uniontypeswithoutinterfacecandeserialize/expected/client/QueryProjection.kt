package com.netflix.graphql.dgs.codegen.cases.uniontypeswithoutinterfacecandeserialize.expected.client

import com.netflix.graphql.dgs.codegen.GraphQLProjection
import kotlin.String

public class QueryProjection : GraphQLProjection() {
  public fun search(text: String,
      projection: SearchResultPageProjection.() -> SearchResultPageProjection): QueryProjection {
    field("search", SearchResultPageProjection(), projection, "text" to text)
    return this
  }
}
