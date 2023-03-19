package com.kotlin.dojo.designPatterns.creational

import kotlin.test.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class TitaniumBuilderPatternTest {

  @Test
  fun `test when builder is fully filled`() {
    val hello = TitaniumBuilderPattern.Companion.Builder()
      .bread("BREAD")
      .meat("MEAT")
      .condiments("CONDIMENTS")
      .dressing("DRESSING")
      .build()

    val expectedResult = "BREAD CONDIMENTS DRESSING MEAT"
    assertEquals(expected = expectedResult, actual = hello.toString())
  }

  @Test
  fun `test when builder is partially filled`() {
    val hello = TitaniumBuilderPattern.Companion.Builder()
      .bread("BREAD")
      .meat("MEAT")
//      .condiments("CONDIMENTS")
      .dressing("DRESSING")
      .build()

    val expectedResult = "BREAD DRESSING MEAT"
    assertEquals(expected = expectedResult, actual = hello.toString())
  }

  @Test
  fun `test verify different builder objects`() {
    val builderAHashCode = TitaniumBuilderPattern.Companion.Builder()
      .bread("BREAD")
      .meat("MEAT")
      .hashCode()

    val builderBHashCode = TitaniumBuilderPattern.Companion.Builder()
      .condiments("CONDIMENTS")
      .dressing("DRESSING")
      .hashCode()

    assertFalse(builderAHashCode == builderBHashCode)
  }

  @Test
  fun `test verify same builder object`() {
    val builderAHashCode = TitaniumBuilderPattern.Companion.Builder()
      .bread("BREAD")
      .meat("MEAT")

    val builderBHashCode = builderAHashCode
      .condiments("CONDIMENTS")
      .dressing("DRESSING")

    assertTrue(builderAHashCode.hashCode() == builderBHashCode.hashCode())
  }
}
