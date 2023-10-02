package com.netflix.graphql.dgs.codegen.cases.interfaceClassWithInterfaceFieldsOfDifferentType.expected.client

import com.netflix.graphql.dgs.codegen.GraphQLProjection

public class DietProjection : GraphQLProjection() {
  public val calories: DietProjection
    get() {
      field("calories")
      return this
    }

  public fun onVegetarian(projection: VegetarianProjection.() -> VegetarianProjection):
      DietProjection {
    fragment("Vegetarian", VegetarianProjection(), projection)
    return this
  }
}
