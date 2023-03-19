package com.kotlin.dojo.courses.kotlinCoroutinesGettingStarted

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
  demoStructuredConcurrency()
}

/**
 * Structured Concurrency
 * - cancel work when no longer needed
 * - keep track of work while it's running
 * - Signal errors on failure
 */
fun demoStructuredConcurrency() = runBlocking {
  fun runWithCustomLocalScope() = runBlocking {
    coroutineScope {
      launch {
        delay(1000)
        println("Launch 1")
      }
      launch {
        delay(500)
        println("Launch 2")
      }
    }
    println("runWithCustomLocalScope has finished")
  }

  launch {
    runWithCustomLocalScope()
    println("runWithCustomLocalScope has returned back")
  }
}
