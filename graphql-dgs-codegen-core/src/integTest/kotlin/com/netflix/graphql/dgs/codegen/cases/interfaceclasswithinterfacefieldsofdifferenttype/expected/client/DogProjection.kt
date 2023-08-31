package com.netflix.graphql.dgs.codegen.cases.interfaceclasswithinterfacefieldsofdifferenttype.expected.client

import com.netflix.graphql.dgs.codegen.GraphQLProjection

public class DogProjection : GraphQLProjection() {
  public val name: DogProjection
    get() {
      field("name")
      return this
    }

  public fun diet(projection: VegetarianProjection.() -> VegetarianProjection): DogProjection {
    field("diet", VegetarianProjection(), projection)
    return this
  }
}
