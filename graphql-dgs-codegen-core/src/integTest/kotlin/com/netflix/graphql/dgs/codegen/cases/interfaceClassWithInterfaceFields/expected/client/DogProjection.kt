package com.netflix.graphql.dgs.codegen.cases.interfaceClassWithInterfaceFields.expected.client

import com.netflix.graphql.dgs.codegen.GraphQLProjection

public class DogProjection : GraphQLProjection() {
  public val id: DogProjection
    get() {
      field("id")
      return this
    }

  public val name: DogProjection
    get() {
      field("name")
      return this
    }

  public val address: DogProjection
    get() {
      field("address")
      return this
    }

  public fun mother(projection: DogProjection.() -> DogProjection): DogProjection {
    field("mother", DogProjection(), projection)
    return this
  }

  public fun father(projection: DogProjection.() -> DogProjection): DogProjection {
    field("father", DogProjection(), projection)
    return this
  }

  public fun parents(projection: DogProjection.() -> DogProjection): DogProjection {
    field("parents", DogProjection(), projection)
    return this
  }
}
