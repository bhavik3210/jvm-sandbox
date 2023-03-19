package com.kotlin.dojo.courses.kotlinCoroutinesGettingStarted

import com.kotlin.dojo.ext.separator
import kotlin.concurrent.thread
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Basic Coroutines vs Multi-Threading
 * Difference between the two
 * coroutines are not multiple threads
 * multiple coroutines may run on same single thread
 */
fun main() {
  withCoroutines()
  println(50.separator())
  withoutCoroutinesAndMultipleThreads()
}

/**
 * This did not create two thread (main and another)
 * delay call suspend the coroutine so another can be executed and
 * take up the resources it needs for that second one
 */
@OptIn(DelicateCoroutinesApi::class)
fun withCoroutines() {
  // with coroutines
  GlobalScope.launch {
    delay(1000)
    print("World")
  }

  print("Hello, ")
  Thread.sleep(1500)
  println("!!! -> Using Coroutines ")
}

/**
 * here main thread will print "Hello, " and sleep for 1.5 second and
 * create another thread which will sleep for one second and print "world"
 */
fun withoutCoroutinesAndMultipleThreads() {
  // this will run in Main thread

  thread { // this block will run in another thread
    Thread.sleep(1000)
    print("World")
  }

  print("Hello, ")

  Thread.sleep(1500)

  println("!!! -> Using Multi-Threading ")
}
