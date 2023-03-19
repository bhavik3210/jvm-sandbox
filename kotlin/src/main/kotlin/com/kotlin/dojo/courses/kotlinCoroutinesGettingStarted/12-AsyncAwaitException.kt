package com.kotlin.dojo.courses.kotlinCoroutinesGettingStarted

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
  demoExceptionWithAsyncAwait()
}

/**
 * Exception with async/await
 *
 * It will be propagated upwards
 */
fun demoExceptionWithAsyncAwait() = runBlocking {
  val scope = CoroutineScope(Job())

  val job = scope.launch {
    val deferred = async {
      delay(1000)
      throw Exception()
    }

    try {
      deferred.await()
    } catch (t: Throwable) {
      println("Caught: $t")
    }
  }

  job.join()
}
