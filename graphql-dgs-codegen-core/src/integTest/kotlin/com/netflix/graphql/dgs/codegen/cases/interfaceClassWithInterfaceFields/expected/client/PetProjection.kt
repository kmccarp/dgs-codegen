package com.netflix.graphql.dgs.codegen.cases.interfaceClassWithInterfaceFields.expected.client

import com.netflix.graphql.dgs.codegen.GraphQLProjection

public class PetProjection : GraphQLProjection() {
  public val id: PetProjection
    get() {
      field("id")
      return this
    }

  public val name: PetProjection
    get() {
      field("name")
      return this
    }

  public val address: PetProjection
    get() {
      field("address")
      return this
    }

  public fun mother(projection: PetProjection.() -> PetProjection): PetProjection {
    field("mother", PetProjection(), projection)
    return this
  }

  public fun father(projection: PetProjection.() -> PetProjection): PetProjection {
    field("father", PetProjection(), projection)
    return this
  }

  public fun parents(projection: PetProjection.() -> PetProjection): PetProjection {
    field("parents", PetProjection(), projection)
    return this
  }

  public fun onDog(projection: DogProjection.() -> DogProjection): PetProjection {
    fragment("Dog", DogProjection(), projection)
    return this
  }

  public fun onBird(projection: BirdProjection.() -> BirdProjection): PetProjection {
    fragment("Bird", BirdProjection(), projection)
    return this
  }
}
