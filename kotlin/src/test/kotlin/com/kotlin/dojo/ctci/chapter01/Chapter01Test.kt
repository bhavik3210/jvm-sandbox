package com.kotlin.dojo.ctci.chapter01

import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Chapter01Test {

  private val testStrings = arrayOf(
    "apple",
    "orange",
    "The quick brown fox jumps over the lazy dog",
    "abcdefghi",
    "abc def ghi"
  )

  @Test
  fun `test and compare unique characters result from both solutions`() {
    testStrings.forEach {
      assertEquals(it.hasUniqueCharacters(), it.hasUniqueChars())
    }
  }
}
