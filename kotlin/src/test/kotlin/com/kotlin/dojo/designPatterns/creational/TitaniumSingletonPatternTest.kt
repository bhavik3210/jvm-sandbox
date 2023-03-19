package com.kotlin.dojo.designPatterns.creational

import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class TitaniumSingletonPatternTest {

  @Test
  fun `test instance is the same when called twice`() {
    val titaniumSingletonPatternA = TitaniumSingletonPattern.getInstance()
    val titaniumSingletonPatternB = TitaniumSingletonPattern.getInstance()
    assertEquals(titaniumSingletonPatternA.hashCode(), titaniumSingletonPatternB.hashCode())
  }
}
