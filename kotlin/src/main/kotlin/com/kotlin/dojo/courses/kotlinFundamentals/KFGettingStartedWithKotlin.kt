package com.kotlin.dojo.courses.kotlinFundamentals

import com.kotlin.dojo.ext.printSubtitle
import java.io.FileReader
import java.util.TreeMap


class KFGettingStartedWithKotlin {

  private val q: Faq? = Faq("3")

  init {
    "Getting Started with Kotlin".printSubtitle()
    q?.answer = "3"
  }

  /**
   * 03-Getting-Started with Kotlin
   */
  companion object {
    fun gettingStartedWithKotlin() {
      val kfGettingStartedWithKotlin = KFGettingStartedWithKotlin()
      kfGettingStartedWithKotlin.variableMutation()
      kfGettingStartedWithKotlin.stringInterpolation()
      kfGettingStartedWithKotlin.iFStatementAndNullability()
      kfGettingStartedWithKotlin.whenStatement()
      kfGettingStartedWithKotlin.tryCatchUse()
      kfGettingStartedWithKotlin.whileLoop()
      kfGettingStartedWithKotlin.doWhileLoop()
      kfGettingStartedWithKotlin.ranges()
      kfGettingStartedWithKotlin.forLoops()
    }
  }

  /**
   * By default, always use val instead of var,
   * only use var if it is required for you to reassign that variable
   */
  private fun variableMutation() {

    var mutableQ = Faq("3") // mutable
    mutableQ = Faq("3") // new object assigned

    val immutableQ = Faq("3")
//  immutableQ = Faq() not allowed because immuatable

    val q: Faq? = Faq("3")
    q?.answer = "3"
    q?.display()
  }

  private fun stringInterpolation() {
    val q: Faq? = Faq("3")
    q?.answer = "3"

    // String interpolation (templates)
    println("The answer to the question ${q?.question} is ${q?.answer}")
  }

  private fun iFStatementAndNullability() {
    val q: Faq? = Faq("3")
    q?.answer = "3"

    // if statement as an expression
    /*
      Note: == operator in kotlin is equivalent to .equals() in java
      so in kotlin you don't have to use .equals()

      ?. safe operator to unwrap potential null value safely
      if q is null in the case below it will fail the condition below
     */
    val message = if (q?.answer.orEmpty() == q?.correctAnswer) {
      "You were correct"
    } else {
      "Try again?"
    }
    println("Using if Statement: $message")
  }

  private fun whenStatement() {
    val q: Faq? = Faq("3")
    q?.answer = "3"

    // When Statement can be found in printResult()
    q?.printResult()
  }

  private fun tryCatchUse() {
    val s = "potato"
    q?.answer = s
    val number: Int? = try {
      Integer.parseInt(q?.answer)
    } catch (ex: Exception) {
      null
    }
    println("Try/catch as expression: $number")


    // try/catch/finally
    println()
    try {
      var reader = FileReader("filename")
      reader.read()
    } catch (e: java.lang.Exception) {
      println("Invalid File")
    } finally {
      println("I am executed always")
    }
  }

  private fun whileLoop() {
    // while loops - same as java
    var i = 0;
    while (i < 10) {
      println("i: $i")
      i++
    }
  }

  private fun doWhileLoop() {
    //do while loops - same as java
    println()
    var i = 0;
    i = 10
    do {
      println("i: $i")
      i++
    } while (i < 10)
    println()
  }

  private fun ranges() {
    //range (inclusive for loop)
    for (i in 1..5) {
      println(i)
    }
    println()

    //step (every 2nd item from 1 to 10)
    for (i in 1..10 step 2) {
      println(i)
    }
    println()

    //step (every 3rd item from 10 to 1)
    for (i in 10 downTo 1 step 3) {
      println(i)
    }
    println()

    // half close range (not inclusive) so it won't print 5
    for (i in 1 until 5) {
      println(i)
    }
    println()

    /**
    you can use range with anything that implements [Comparable] interface
    Exercise: create an example of this feature in kotlin
     */
    var range = 'a'..'z'
  }

  private fun forLoops() {
    val numbers = listOf(1, 2, 3, 4, 5)
    for (i in numbers) {
      println(i)
    }
    println()

    var ages = TreeMap<String, Int>()
    ages["Kevin"] = 12
    ages["John"] = 14
    ages["Alex"] = 16

    for ((name, age) in ages) {
      println("$name: $age")
    }
    println()

    for ((index, value) in numbers.withIndex()) {
      println("$value at $index")
    }
  }
}