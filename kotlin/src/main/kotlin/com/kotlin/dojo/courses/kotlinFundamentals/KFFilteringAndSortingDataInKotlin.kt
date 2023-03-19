package com.kotlin.dojo.courses.kotlinFundamentals

import com.kotlin.dojo.ext.printSubtitle

/**
 * filter and map creates another set of list (so good for small to medium size lists)
 */
class KFFilteringAndSortingDataInKotlin {

  init {
    "Filtering and Sorting Data in Kotlin".printSubtitle()
  }

  companion object {
    fun filteringAndSortingData() {
      val kfFilteringAndSortingDataInKotlin = KFFilteringAndSortingDataInKotlin()

      // filter and map on collections
      val ints = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
      println("ints: $ints")
      println()

      val smallerInts = ints.filter { it <= 5 }
      println("smallerInts: $smallerInts")

      val squaredInts = ints.map { it * it }
      println("squaredInts: $squaredInts")

      val smallSquaredInts = ints.filter { it <= 5 }
        .map { it * it }
      println("smallSquaredInts: $smallSquaredInts")


      //transforming type of data using map
      val meeting = listOf<Meeting>(
        Meeting("Meeting 1"), Meeting("Meeting 2"), Meeting("Meeting 3")
      )
      val titles: List<String> = meeting.map { it.title }
      println("Meeting Titles Transformed to String Collection: $titles")
      println()

      //Predicate: lambdas that return boolean (i.e. all, any, count, find)
      val greaterThanThree = { v: Int -> v > 3 } //declaring predicate as a variable for multiple reuse below

//      var largeInts = ints.all { it > 3 }
      var largeInts = ints.all(greaterThanThree) //use of predicate from a variable
      println("Are all ints in collection larger than 3 (using 'all' predicate): $largeInts")

//      largeInts = ints.any { it > 3 }
      largeInts = ints.any(greaterThanThree)
      println("Are any ints in collection larger than 3 (using 'any' predicate): $largeInts")

//      val count = ints.count { it > 3 }
      val count = ints.count(greaterThanThree)
      println("What is the size of the collection with ints larger than 3 (using 'count' predicate): $count")

      val found = ints.find(greaterThanThree) //would return null if not found
      println("First element found after 3 in collection: $found")


//      val people = meeting.map(Meeting::people)
//      val people = meeting.map { it -> it.people}
      val people: List<DataStudent> = meeting.flatMap { it.people }.distinct()
      println(people)
    }
  }

}