package com.netflix.graphql.dgs.codegen.cases.interfaceclasswithinterfacefieldsofdifferenttype.expected.client

import com.netflix.graphql.dgs.codegen.GraphQLProjection

public class PetProjection : GraphQLProjection() {
  public val name: PetProjection
    get() {
      field("name")
      return this
    }

  public fun diet(projection: DietProjection.() -> DietProjection): PetProjection {
    field("diet", DietProjection(), projection)
    return this
  }

  public fun onDog(_projection: DogProjection.() -> DogProjection): PetProjection {
    fragment("Dog", DogProjection(), _projection)
    return this
  }
}
