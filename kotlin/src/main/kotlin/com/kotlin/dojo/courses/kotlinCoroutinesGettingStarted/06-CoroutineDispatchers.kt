package com.kotlin.dojo.courses.kotlinCoroutinesGettingStarted

import java.util.concurrent.Executors
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

fun main() {
  demoDispatchers()
}

/**
 * Coroutine Context
 * - set of properties attached to the coroutine (defined by the user)
 * - May include following (immutable)
 *  - threading policy (dispatcher)
 *  - name
 *  - other data
 *  - think of it like thread-local storage
 *  - can think of the context as an indexed set of elements
 *
 *  Context can be combined
 *
 */

/**
 * Coroutine dispatchers
 * - Default: the fork/join pool, assumes that coroutine will be CPU bound (will exaust cpu)
 * - Main: runs on the main thread of the process
 * - IO: Uses and expandable pool of threads, assumes that coroutine will be IO bound
 * - Other: provided by a library i.e. Dispatchers.JavaFx, we can also create our own dispatchers
 */
fun demoDispatchers() = runBlocking {
  val jobs = mutableListOf<Job>()

  jobs += launch {
    // the "default" context (this dispatcher may differ based on where you launch from)
    println(" 'default': In Thread ${Thread.currentThread().name}")
  }

  jobs += launch(Dispatchers.Default) {
    // the "default" context
    println(" 'defaultDispatcher': In Thread ${Thread.currentThread().name}")
  }

  jobs += launch(Dispatchers.IO) {
    // the "IO" context
    println(" 'IO Dispatcher': In Thread ${Thread.currentThread().name}")
  }

  jobs += launch(Dispatchers.Unconfined) {
    // the "Not Confined" context -- will work with main thread
    println(" 'Unconfined': In Thread ${Thread.currentThread().name}")
  }

  jobs += launch(newSingleThreadContext("OwnThread")) {
    // will get its own new thread
    println(" 'newSingleThreadContext': In Thread ${Thread.currentThread().name}")
  }

  //region your own dispatcher with cached thread pool and fixed num of threads thread pool
  val cachedThreadPoolDispatcher = Executors.newCachedThreadPool().asCoroutineDispatcher()
  val fixedThreadPoolDispatcher = Executors.newFixedThreadPool(10)
    .asCoroutineDispatcher() // this dispatcher only has 10 worker threads to run all coroutines on

  jobs += launch(cachedThreadPoolDispatcher) {
    println(" 'cachedThreadPoolDispatcher': In Thread ${Thread.currentThread().name}")
  }

  jobs += launch(fixedThreadPoolDispatcher) {
    println(" 'fixedThreadPoolDispatcher': In Thread ${Thread.currentThread().name}")
  }

  // make sure to shutdown the pools otherwise program will keep running because pools are still running and waiting for jobs
  cachedThreadPoolDispatcher.close()
  fixedThreadPoolDispatcher.close() // or you can shutdown executor by .shutdownNow() on executor itself

  //endregion
  jobs.forEach { it.join() }

  println()
}
