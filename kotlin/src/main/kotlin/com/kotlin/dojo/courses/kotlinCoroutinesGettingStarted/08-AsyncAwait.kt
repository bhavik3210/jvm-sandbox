package com.kotlin.dojo.courses.kotlinCoroutinesGettingStarted

import java.util.Random
import kotlin.system.measureTimeMillis
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
  demoAsyncAwait()
}

fun demoAsyncAwait() = runBlocking {
  val time = measureTimeMillis {
    val res1 = async { doWorkOne() }
    val res2 = async { doWorkTwo() }

    println("The Result is ${res1.await()} + ${res2.await()}")
  }

  println("this took $time to run")
}

suspend fun doWorkOne(): Int {
  delay(100)
  println("Working 1")
  return Random(System.currentTimeMillis()).nextInt(42)
}

suspend fun doWorkTwo(): Int {
  delay(200)
  println("Working 2")
  return Random(System.currentTimeMillis()).nextInt(42)
}
