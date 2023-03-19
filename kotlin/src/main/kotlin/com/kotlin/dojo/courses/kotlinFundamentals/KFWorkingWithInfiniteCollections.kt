package com.kotlin.dojo.courses.kotlinFundamentals

import com.kotlin.dojo.ext.printSubtitle

fun iter(seq: Sequence<String>) {
  for (t in seq) println(t)
}

/**
 * filter and map creates another set of list (so good for small to medium size lists)
 * However, for large infinite lists you need something else, which is sequence
 * Sequence are lazy evaluated, and no extra memory is used
 * - Similar to lists
 * - lazily evaluated
 * - prefer to lists
 * - like java 8 streams
 * for iterating over large lists
 * - Terminal operations
 * - Non Terminal operations
 * Sequences are lazily evaluated
 *  - Evaluation doesn't start until it is using terminal operation (evaluation starts when using terminal operation)
 */
class KFWorkingWIthInfiniteCollections {

  init {
    "Working with Infinite Collections".printSubtitle()
  }

  companion object {
    fun workingWithInfiniteCollections() {
//      val workingWithInfiniteCollections = KFWorkingWithInfiniteCollections()

      val meetings = listOf<Meeting>(
        Meeting("Board Meeting"), Meeting("Water Cooler Meeting"), Meeting("Committee Meeting")
      )

      val titles = meetings
        .asSequence()
        .filter { println("filter($it)"); it.title.endsWith("g") }
        .map { println("map($it)"); it.title }

//      iter(titles) //seq only evaluated when iter() is used which makes it lazily evaluated
    }
  }
}