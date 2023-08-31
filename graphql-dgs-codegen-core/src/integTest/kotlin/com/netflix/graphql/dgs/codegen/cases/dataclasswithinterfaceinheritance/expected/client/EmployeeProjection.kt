package com.netflix.graphql.dgs.codegen.cases.dataclasswithinterfaceinheritance.expected.client

import com.netflix.graphql.dgs.codegen.GraphQLProjection

public class EmployeeProjection : GraphQLProjection() {
  public val firstname: EmployeeProjection
    get() {
      field("firstname")
      return this
    }

  public val lastname: EmployeeProjection
    get() {
      field("lastname")
      return this
    }

  public val company: EmployeeProjection
    get() {
      field("company")
      return this
    }

  public fun onTalent(projection: TalentProjection.() -> TalentProjection): EmployeeProjection {
    fragment("Talent", TalentProjection(), projection)
    return this
  }
}
