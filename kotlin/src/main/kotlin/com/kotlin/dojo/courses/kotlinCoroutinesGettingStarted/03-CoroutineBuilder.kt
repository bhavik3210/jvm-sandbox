package com.kotlin.dojo.courses.kotlinCoroutinesGettingStarted

import com.kotlin.dojo.ext.separator
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.withTimeoutOrNull
import kotlinx.coroutines.yield

fun main() {
  demoTimeOut()
}

/**
 * Timeout of Coroutine
 * using timeout Coroutine builder
 */
fun demoTimeOut() = runBlocking {

  // Timeout without exception handling
  val job = withTimeoutOrNull(500) {
    repeat(1_000) {
      yield()

      print(".")
      Thread.sleep(1)
    }
  }

  if (job == null) {
    println("Coroutine Builder Timed-out")
  }

  println(100.separator())

  // Timeout with exception handling
  // TimeoutCancellationException is thrown if coroutine is running longer period than timeout allowance from withTimeout
  try {
    val job = withTimeout(300) {
      repeat(1_000) {
        yield()

        print(".")
        Thread.sleep(1)
      }
    }
  } catch (ex: TimeoutCancellationException) {
    println()
    println("Handled exception: $ex")
  }
}
