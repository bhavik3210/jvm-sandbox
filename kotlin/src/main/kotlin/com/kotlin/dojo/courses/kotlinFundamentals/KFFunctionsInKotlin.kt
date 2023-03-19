package com.kotlin.dojo.courses.kotlinFundamentals

import com.kotlin.dojo.ext.printSubtitle
import java.math.BigInteger

class KFFunctionsInKotlin {

  init {
    "Functions in Kotlin".printSubtitle()
  }

  /**
   * 04-Functions in Kotlin
   */
  companion object {
    fun functionsInKotlin() {
      val kfFunctionsInKotlin = KFFunctionsInKotlin()
      kfFunctionsInKotlin.defaultParametersDemo()
      kfFunctionsInKotlin.jvmOverloadedFunctionForJavaInteroperability()
      kfFunctionsInKotlin.demoInfixFunction()
      kfFunctionsInKotlin.demoInfixFunctionWithOperatorOverloading()
      kfFunctionsInKotlin.demoTailRecursion()
    }
  }

  fun defaultParametersDemo() {
    //default parameters
    fun defaultParameter(leftValue: Int = 0, rightValue: Int) =
      leftValue + rightValue
    println(defaultParameter(rightValue = 2)) //rightValue is a named parameter
    println(defaultParameter(3, 2))
  }

  fun jvmOverloadedFunctionForJavaInteroperability() {
    //See log function below for @JvmOverloads
    println(log("Message "))
    println(log("Message ", 3))
  }

  /*
    // Below Code: From Kotlin Byte Code
    @JvmOverloads notation
    will create multiple variations of this log
    functions so in Java code it can be used with either
    one or both of the parameters.

    For Example, because of the notation
    it generated two functions in java

    @JvmOverloads
     public static final void log(@NotNull String message, int logLevel) {
        Intrinsics.checkNotNullParameter(message, "message");
        String var2 = message + logLevel;
        System.out.println(var2);
     }

     // $FF: synthetic method
     public static void log$default(String var0, int var1, int var2, Object var3) {
        if ((var2 & 2) != 0) {
           var1 = 1;
        }

        log(var0, var1);
     }

     @JvmOverloads
     public static final void log(@NotNull String message) {
        log$default(message, 0, 2, (Object)null);
     }
   */
  @JvmOverloads
  fun log(message: String, logLevel: Int = 1) {
    println(message + logLevel)
  }

  fun demoExtensionFunctions() {
    /**
    Extension Functions: look at getSubTitleFormat() function call above
    value of the receiver is "this" within the extension function
    "this" is the receiver of the value of the type that you are extending
    are used more often as Util and Helper functions
     */
    "This is a demonstration of a String Extension function 'demoStringExtensionFunction' ".demoStringExtensionFunction()
  }

  private fun String.demoStringExtensionFunction() {
    println(this)
  }

  private fun demoInfixFunction() {
    //infix function
    class Header(var name: String)

    val h1 = Header("H1")
    val h2 = Header("H2")
    infix fun Header.plus(other: Header): Header {
      return Header(this.name + other.name)
    }
//  val h3 = h1.plus(h2)
    val h3 = h1 plus h2 //this syntax is allowed because you declared infix in front of fun
    println(h3.name)
  }

  private fun demoInfixFunctionWithOperatorOverloading() {
    //infix function
    class Header(var name: String)

    val h1 = Header("H1")
    val h2 = Header("H2")
    infix operator fun Header.plus(other: Header): Header {
      return Header(this.name + other.name)
    }
//  val h3 = h1.plus(h2)
    val h3 = h1 plus h2 //this syntax is allowed because you declared infix in front of fun
    println(h3.name)

    //Operator Overloading: ONLY Predefined set of Operators can be overloaded which includes Unary and Binary
    //How to overload operator using infix like function for a syntax like h1 + h2 instead of h1 plus h2
    //Don't use this if you don't need this (or overuse it)
    //used for DSL
    val h4 = h1 + h2 //this syntax is allowed because we added operator
    println(h4.name)
  }

  private fun demoTailRecursion() {
    /*
    tialrec is used to avoid stackoverflow on large result on fib fun below
   */
    tailrec fun fib(n: Int, a: BigInteger, b: BigInteger): BigInteger {
      return if (n == 0) b else fib(n - 1, a + b, a)
    }
    println(
      fib(
        10,
        BigInteger("1"),
        BigInteger("0")
      )
    ) // this will throw stackoverflow. SO you need to use tailrec to solve this
  }
}