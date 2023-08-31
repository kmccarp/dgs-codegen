package com.netflix.graphql.dgs.codegen.cases.projectionwithtype.expected.client

import com.netflix.graphql.dgs.codegen.GraphQLProjection

public class PersonProjection : GraphQLProjection() {
  public val firstname: PersonProjection
    get() {
      field("firstname")
      return this
    }

  public fun onEmployee(projection: EmployeeProjection.() -> EmployeeProjection):
      PersonProjection {
    fragment("Employee", EmployeeProjection(), projection)
    return this
  }
}
