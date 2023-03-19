package com.kotlin.dojo.courses.kotlinFundamentals

import com.kotlin.dojo.ext.printSubtitle
import java.lang.Exception

class KFHigherOrderFunctions {

  init {
    "Using Higher Order Functions in Kotlin".printSubtitle()
  }

  companion object {
    fun demoHigherOrderFunctions() {
      val demo = KFHigherOrderFunctions()
      val action = { println("Hello, World") }
      val calc = { x: Int, y: Int ->
        println(x * y)
      }
      demo.doSomething(action)
      demo.doSomething { action.invoke() }
      demo.doSomething { calc(3, 2) }

      /*
        Lambdas map to anonymous classes in kotlin byte code
        Extra class and method created each time
        This is expensive however if you want to avoid this use 'inline'
       */
      val ints = listOf(1, 2, 3, 4, 5)
      val i = demo.first(ints) { i ->
        i == 3
      }
    }
  }

  fun doSomething(func: () -> Unit) {
    func()
  }

  /*
    Usage of inline function which will not generate separate class and anonymous function here
    Can help performance but not all functions can be inlined
    inline function Lambda cannot be stored in a variable for later use
    Only if lambda is used directly then can be inline (as shown below)
    Kotlin collection operations are inlined (map, filter, etc) however same operations on sequence are not inlined
   */
  inline fun <T> first(items: List<T>, predicate: (T) -> Boolean): T {
    for (item in items) {
      if (predicate(item)) return item
    }
    throw Exception()
  }
}