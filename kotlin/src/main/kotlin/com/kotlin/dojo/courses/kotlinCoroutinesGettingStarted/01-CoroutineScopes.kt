package com.kotlin.dojo.courses.kotlinCoroutinesGettingStarted

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
  demoBlocking()
  withCoroutinesRunBlocking()
}

/**
 * Demo runBlocking mechanism
 *
 * runBlocking and launch are both coroutine scopes
 *
 * runBlocking lets you enter the coroutine world from a non coroutine world
 */
fun demoBlocking() = runBlocking {
  launch {
    delay(1000)
    print("World")
  }

  print("Hello, ")
  delay(2000)
  println("!!! -> Using Coroutines in Coroutine Scopes ")
}

fun withCoroutinesRunBlocking() {
  // with coroutines
  runBlocking {
    delay(1000)
    print("World")
  }


  print("Hello, ")
  Thread.sleep(1500)
  println("!!! -> Using Coroutines ")
}