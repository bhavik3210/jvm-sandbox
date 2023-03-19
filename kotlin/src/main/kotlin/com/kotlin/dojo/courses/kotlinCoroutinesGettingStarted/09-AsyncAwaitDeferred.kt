package com.kotlin.dojo.courses.kotlinCoroutinesGettingStarted

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
  demoDeferredTask()
}

/**
 * async coroutine builder
 * builder returns Defferred object.
 * Defferred is like Future in java and promise in javascript
 */
fun demoDeferredTask() = runBlocking {
  val result: Deferred<Int> = doWorkAsync("TaskA")
  val answer = result.await()
  println("The answer is $answer")
}

/*
    Without a suspend function
    But it is better to do as done in this demoAsyncAwait function because
    you can use the suspend function synchronously or asynchronously
    doWorkAsync is explicitly asynchronous and can't be use Synchronously
 */
fun doWorkAsync(message: String): Deferred<Int> = GlobalScope.async {
  log("$message - Working")
  delay(3000)
  log("$message - Work Done!")

  return@async 42
}

fun log(message: String) {
  println("$message in ${Thread.currentThread().name}")
}
