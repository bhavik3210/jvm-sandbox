package com.kotlin.dojo.courses.kotlinFundamentals

import com.kotlin.dojo.JavaCreated
import com.kotlin.dojo.JavaUser
import com.kotlin.dojo.ext.printSubtitle

/**
 * SAM: Single Abstract Method (interfaces with single method)
 *Events are methods that accepts interface
 * - Many java method expect a functional interface
 * - prior to java 8 passed an anonymous object
 * - since java 8 can pass lambdas
 * - Kotlin lambdas are interoperable
 *
 *SAM Constructor
 * - What happens when compiler cannot Explicitly convert lambda to functional interface?
 * - Sam constructor is a compiler generated function
 * - useful to returning lambda from method call
 * - Very easy to pass lambdas to Java methods
 * - Use SAM constructors when the type is ambiguous
 */
class KFFunctionalInterface {
  init {
    "Working with java Functional Interfaces from kotlin".printSubtitle()
  }

  companion object {
    fun workingWithFunctionalInterface() {
      val demo = KFFunctionalInterface()

      val javaUser = JavaUser("Java User")
      var count = 0

      // syntax 1
      javaUser.create(object : JavaCreated {
        override fun onCreate(user: JavaUser?) {
          println("Syntax ${++count}: User ${user.toString()} has been created")
        }
      })

      // syntax 2, more concise syntax, same as above
      javaUser.create {
        println("Syntax ${++count}: User $it has been created")
      }

      // syntax 3, more concise syntax, same as above
      val eventListenerThird = { u: JavaUser ->
        println(println("Syntax ${++count}: User $u has been created"))
      }
      javaUser.create(eventListenerThird)

      // syntax 4, more concise syntax, same as above
      // can use 'it' here
//      val eventListenerFourth = JavaCreated({ println("Syntax 3: User $it has been created  ${++count} ") })
      val eventListenerFourth = JavaCreated { println("Syntax ${++count}: User $it has been created") }
      javaUser.create(eventListenerFourth)


    }
  }
}