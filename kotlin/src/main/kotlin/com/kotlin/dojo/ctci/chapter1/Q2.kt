package com.kotlin.dojo.ctci.chapter1

import java.util.Arrays

fun Pair<String, String>.isPermutation(): Boolean {
  if (first.length != second.length) {
    return false
  }
  val firstSortedString: CharArray = first.toCharArray()
  Arrays.sort(firstSortedString)
  val secondSortedString: CharArray = second.toCharArray()
  Arrays.sort(secondSortedString)
  for (i in firstSortedString.indices) {
    if (firstSortedString[i] != secondSortedString[i]) {
      return false
    }
  }
  return true
}
