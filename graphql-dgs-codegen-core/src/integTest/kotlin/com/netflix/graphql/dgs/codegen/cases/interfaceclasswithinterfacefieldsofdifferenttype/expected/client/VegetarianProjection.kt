package com.netflix.graphql.dgs.codegen.cases.interfaceclasswithinterfacefieldsofdifferenttype.expected.client

import com.netflix.graphql.dgs.codegen.GraphQLProjection

public class VegetarianProjection : GraphQLProjection() {
  public val calories: VegetarianProjection
    get() {
      field("calories")
      return this
    }

  public val vegetables: VegetarianProjection
    get() {
      field("vegetables")
      return this
    }
}
