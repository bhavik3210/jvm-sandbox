package com.kotlin.dojo.ctci.chapter1

import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Q2Test {

  @Test
  fun `test if first string is a permutation of second string or vice versa`() {
    assertEquals(true, Pair("abc", "bca").isPermutation())
    assertEquals(false, Pair("orange", "roanje").isPermutation())
    assertEquals(true, Pair("orange", "roange").isPermutation())
  }
}
