package com.netflix.graphql.dgs.codegen.cases.dataClassWithDeeplyNestedComplexField.expected.client

import com.netflix.graphql.dgs.codegen.GraphQLProjection

public class QueryProjection : GraphQLProjection() {
  public fun cars(projection: CarProjection.() -> CarProjection): QueryProjection {
    field("cars", CarProjection(), projection)
    return this
  }
}
