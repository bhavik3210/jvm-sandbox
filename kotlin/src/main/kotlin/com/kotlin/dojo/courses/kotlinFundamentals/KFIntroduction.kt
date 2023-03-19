package com.kotlin.dojo.courses.kotlinFundamentals

import com.kotlin.dojo.ext.printSubtitle

class KFIntroduction {

  init {
    "Introduction".printSubtitle()
  }

  /**
   * 02-Introduction
   */
  companion object {
    fun introduction() {
      val kfIntroduction = KFIntroduction()
      kfIntroduction.howToCreateAnObject()
      kfIntroduction.useOfLambdasInKotlin()
    }
  }

  /**
   * A Simple Class
   */
  internal class Person(var name: String) {
    fun display() {
      println("Display: $name")
    }

    fun displayNameWithLambda(func: (s: String) -> Unit) {
      func(name)
    }
  }


  /**
   * How to create an object off of class declaration
   */
  fun howToCreateAnObject() {
    val person = Person("John")
    println("Name is: ${person.name}")
    person.name = "BHAVIK"
    println("Name is: ${person.name}")
  }

  /**
   * How to use lambda in Kotlin
   */
  fun useOfLambdasInKotlin() {
    val person = Person("John")
    fun printName(name: String) = println("Executed using lambdas: $name")
    person.displayNameWithLambda {
      // "it" refers to the string passed in
      printName(it)
    }
    person.displayNameWithLambda(::printName) //short form of above
  }
}
