package com.netflix.graphql.dgs.codegen.cases.projectionwithunion.expected.client

import com.netflix.graphql.dgs.codegen.GraphQLProjection

public class UProjection : GraphQLProjection() {
  public fun onEmployee(projection: EmployeeProjection.() -> EmployeeProjection): UProjection {
    fragment("Employee", EmployeeProjection(), projection)
    return this
  }
}
