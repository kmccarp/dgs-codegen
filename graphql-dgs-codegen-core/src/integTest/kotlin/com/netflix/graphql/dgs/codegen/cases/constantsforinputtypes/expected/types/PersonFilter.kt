package com.netflix.graphql.dgs.codegen.cases.constantsforinputtypes.expected.types

import com.netflix.graphql.dgs.codegen.GraphQLInput
import kotlin.Any
import kotlin.Pair
import kotlin.String
import kotlin.collections.List

public class PersonFilter(
  public val email: String? = default<PersonFilter, String?>("email"),
) : GraphQLInput() {
  public override fun fields(): List<Pair<String, Any?>> = listOf("email" to email)
}
