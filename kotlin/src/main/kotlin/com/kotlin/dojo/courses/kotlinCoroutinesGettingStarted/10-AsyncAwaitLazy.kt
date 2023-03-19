package com.kotlin.dojo.courses.kotlinCoroutinesGettingStarted

import kotlin.system.measureTimeMillis
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
  demoLazyCoroutine()
}

fun demoLazyCoroutine() = runBlocking {
  println("Creating Person")

  val kevin = Person()
  kevin.children.start() // this will get the work started before await is even called.

  Thread.sleep(2000)

  val time = measureTimeMillis {
    kevin.children.await().forEach { println(it) }
  }

  println("Person created in $time ms")
}

/**
 * Lazy Coroutine
 */
class Person {
  // we can't do by Lazy on coroutine so you have use below method
  val children = GlobalScope.async(start = CoroutineStart.LAZY) { loadChildren() }

  companion object {
    suspend fun loadChildren(): List<String> {
      println("Loading Children")
      delay(4000)
      return listOf("Harry", "Sam", "Alex")
    }
  }
}
