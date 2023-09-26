package com.netflix.graphql.dgs.codegen.cases.projectionwithtypeandargs.expected.types

import com.netflix.graphql.dgs.codegen.GraphQLInput
import kotlin.Any
import kotlin.Pair
import kotlin.String
import kotlin.collections.List

public class I(
  public val arg: String? = default<I, String?>("arg"),
) : GraphQLInput() {
  public override fun fields(): List<Pair<String, Any?>> = listOf("arg" to arg)
}
