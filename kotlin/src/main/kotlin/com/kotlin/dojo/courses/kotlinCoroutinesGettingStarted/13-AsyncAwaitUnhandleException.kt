package com.kotlin.dojo.courses.kotlinCoroutinesGettingStarted

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope

fun main() {
  demoUnhandledException()
}

/**
 * Unhandled Exception
 *
 * Exception are always propagated up
 * - There is a default 'CoroutineExceptionHandler` in the context
 * - on the JVM reports the exception
 * - in android it kills the process
 *
 * We can replace this
 */
fun demoUnhandledException() = runBlocking {

  val exceptionHandler = CoroutineExceptionHandler { context, exception ->
    println("Custom Exception handler: $exception")
  }

  val scope = CoroutineScope(Job() + exceptionHandler)

  val job = scope.launch {

    val j1 = coroutineContext[Job]

    supervisorScope {
      launch {
        doWork(1)
      }

      launch {
        doWork(2)
      }

      val j2 = launch {
        delay(2000)
        throw Exception()
      }
    }

    delay(5000)
  }

  job.join()
}

suspend fun doWork(i: Int) {
  while (true) {
    print(" $i | ")
    delay(300)
  }
}
