package com.kotlin.dojo.courses.kotlinFundamentals

class Faq(val correctAnswer: String) {
  var answer: String? = null
  val question: String = "What is a prime number?"

  fun display() {
    println("You said ${answer.orEmpty()}")
  }

  fun printResult() {
    print("Using When Statement: ")
    when (answer) {
      correctAnswer -> println("You were Correct")
      else -> println("Try again?")
    }
  }
}