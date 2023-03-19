package com.kotlin.dojo.courses.kotlinFundamentals

import com.kotlin.dojo.ext.printSubtitle
import java.util.Date

/**
 * - Functions as first class citizens
 * - can pass to and return from functions
 * - can store in collections
 */
class KFHighLevelFunctions {

  init {
    "Using High Level Functions to Simplify Your Code".printSubtitle()
  }

  companion object {
    fun highLevelFunctions() {
      val program = Program()
      /*
        Below is the use of a classic strategy pattern from GoF
        Below we are using anonymous object to implement Process interface
       */
//      program.fibonacci(8, object : Process{
//        override fun execute(value: Int) {
//          println(value)
//        }
//      })

//      program.fibonacci(5) { n -> println(n) }
//      program.fibonacci(5) { println(it) }
      program.fibonacci(5, ::println) //:: function reference

      //Kotlin lambdas can mutate values vs. Java cannot
      var total = 0
      program.fibonacci(8) {
        total += it // in Java you cannot mutate total but in kotlin that is allowed
        //note: there are ways around it in java but not elegant solution
      }
      println(total)

      //with actually uses lambdas
      val m = Meeting("Board Meeting", Date(2017, 1, 1))
      with(m) {
        println(m.title)
        println(m.When)
        println(m.people)
      }

      m.apply {
        title = "Not Board Meeting No More"
      }
      println(m)
    }
  }


  internal class Program {
    // 1, 1, 2, 3, 5, 8, 13

    fun fibonacci(limit: Int, action: Process) {
      var prev = 0
      var prevprev = 0
      var current = 1

      for (i in 1..limit) {
        action.execute(current)

        var temp = current
        prevprev = prev
        prev = temp
        current = prev + prevprev
      }
    }

    fun fibonacci(limit: Int, action: (Int) -> Unit) {
      var prev = 0
      var prevprev = 0
      var current = 1

      for (i in 1..limit) {
        action(current)

        var temp = current
        prevprev = prev
        prev = temp
        current = prev + prevprev
      }
    }
  }
}

interface Process {
  fun execute(value: Int)
}

data class Meeting(
  var title: String = "",
  val When: Date = Date(),
  val people: MutableList<DataStudent> = mutableListOf(
    DataStudent(1, "Student1"),
    DataStudent(2, "Student2"),
    DataStudent(3, "Student3"),
  )
)

