package com.kotlin.dojo.courses.kotlinCoroutinesGettingStarted

import java.util.concurrent.Executors
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main() {
  demoWithContext()
}

/**
 * withContext Demo
 * it won't care what the parent scope tell is it to launch because
 * suspend function will determine which dispatcher to with
 */
fun demoWithContext() = runBlocking {

  val jobs = mutableListOf<Job>()

  jobs += launch {
    // the "default" context (this dispatcher may differ based on where you launch from)
    doWorkWithSpecificContext(" 'default':")
  }

  jobs += launch(Dispatchers.Default) {
    // the "default" context
    doWorkWithSpecificContext(" 'defaultDispatcher':")
  }

  jobs += launch(Dispatchers.IO) {
    // the "IO" context
    doWorkWithSpecificContext(" 'IO Dispatcher':")
  }

  jobs += launch(Dispatchers.Unconfined) {
    // the "Not Confined" context -- will work with main thread
    doWorkWithSpecificContext(" 'Unconfined':")
  }

  jobs += launch(newSingleThreadContext("OwnThread")) {
    // will get its own new thread
    doWorkWithSpecificContext(" 'newSingleThreadContext':")
  }

  val cachedThreadPoolDispatcher = Executors.newCachedThreadPool().asCoroutineDispatcher()
  val fixedThreadPoolDispatcher = Executors.newFixedThreadPool(10)
    .asCoroutineDispatcher() // this dispatcher only has 10 worker threads to run all coroutines on

  jobs += launch(cachedThreadPoolDispatcher) {
    doWorkWithSpecificContext(" 'cachedThreadPoolDispatcher':")
  }
  jobs += launch(fixedThreadPoolDispatcher) {
    doWorkWithSpecificContext(" 'fixedThreadPoolDispatcher':")
  }
  cachedThreadPoolDispatcher.close()
  fixedThreadPoolDispatcher.close() // or you can shutdown executor by .shutdownNow() on executor itself

  jobs.forEach { it.join() }

  println()
}

private suspend fun doWorkWithSpecificContext(printOut: String) {
  /*
    withContext here will switch over to Dispatcher.IO pool to run coroutine
    within. Even though different dispatchers were attached from calling
    coroutine scopes
   */
  withContext(Dispatchers.IO) {
    println("$printOut : In Thread ${Thread.currentThread().name}")
  }
}
