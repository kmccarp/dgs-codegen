package com.netflix.graphql.dgs.codegen.cases.constantswithextendedinputtypes.expected.client

import com.netflix.graphql.dgs.codegen.GraphQLProjection
import com.netflix.graphql.dgs.codegen.cases.constantsWithExtendedInputTypes.expected.types.PersonFilter

public class QueryProjection : GraphQLProjection() {
  public fun people(filter: PersonFilter? = default<QueryProjection, PersonFilter?>("filter"),
      projection: PersonProjection.() -> PersonProjection): QueryProjection {
    field("people", PersonProjection(), projection, "filter" to filter)
    return this
  }
}
