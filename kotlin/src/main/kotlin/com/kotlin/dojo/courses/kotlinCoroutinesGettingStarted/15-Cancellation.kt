package com.kotlin.dojo.courses.kotlinCoroutinesGettingStarted

import com.kotlin.dojo.ext.getTitleFormat
import com.kotlin.dojo.ext.separator
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.async
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.coroutines.yield

fun main() {
  println()
  println("demoCancellationWithDeferredJob".getTitleFormat())
  println()
  demoCancellationWithDeferredJob()

  println()
  println("demoCancellationExceptionDoSomethingWithIt".getTitleFormat())
  println()
  demoCancellationExceptionDoSomethingWithIt()

  println()
  println("demoCancellationWithCoOperation".getTitleFormat())
  println()
  demoCancellationWithCoOperation()
}

/**
 * Cancellation with deferred jobs
 */
fun demoCancellationWithDeferredJob() = runBlocking {
  val job = async {
    delay(100)
    42
  }

  job.cancelAndJoin()

  if (!job.isCancelled) job.await()
  else println("...Already Cancelled!")
}

/**
 * Cancellation Exception with NonCancellable handling
 */
fun demoCancellationExceptionDoSomethingWithIt() = runBlocking {
  val job = launch {
    try {
      repeat(1000) {
        delay(1)
        Thread.sleep(1)
      }
    } catch (ex: CancellationException) {
      println("Exception Occurred!!!".getTitleFormat())
      withContext(NonCancellable) {
        reportError()
      }
      // vs just calling reportError() without context
      // NonCancellable creates a coroutine that doesn't cancel but see doc for proper usage
      // without context you have no coroutine context left to call reportError() because it is a suspend function
    }
  }

  delay(1000)
  job.cancelAndJoin()
}

suspend fun reportError() {
  println("Reporting Error....")
  try {
    delay(10)
  } catch (t: Throwable) {
    println(t)
  }
  println("...Reported Error!")
}

/**
 * Cancellation of jobs
 * - Cancelling parent cancels children
 * - Cancelling child does NOT cancel parent or its siblings
 * - Cancellation is co-operative
 * - Cancellation throws a specific exception
 * - be careful with async/await
 * - To Co-operate use "isActive" also "ensureActive()" works
 *
 * https://stackoverflow.com/questions/61121051/coroutine-difference-between-join-and-cancelandjoin
 */
fun demoCancellationWithCoOperation() = runBlocking {
  var child1: Job? = null
  var child2: Job? = null
  var child3: Job? = null
  var child4: Job? = null
  var child5: Job? = null
  var child6: Job? = null

  coroutineScope {
    val parentJob = GlobalScope.launch {

      child1 = launch {
        repeat(1000) {
          Thread.sleep(1000)
          print(" C1 |")
          yield()
        }
      }

      child2 = launch {
        repeat(1000) {
          Thread.sleep(1000)
          if (!isActive) return@launch
          // if(!isActive) return@repeat //this will not end this coroutine
          print(" C2 |")
        }
      }

      child3 = launch {
        repeat(1000) {
          Thread.sleep(1000)
          if (!isActive) throw CancellationException()
          print(" C3 |")
        }
      }

      child4 = launch {
        repeat(1000) {
          Thread.sleep(1000)
          // preferred way to do it instead of checking and cancelling as done in child 3
          ensureActive() // does same as child3 "if(!isActive) throw CancellationException()"
          print(" C4 |")
        }
      }

      child5 = launch {
        try {
          repeat(1000) {
            Thread.sleep(1000)
            ensureActive()
            print(" C5 |")
          }
        } catch (ex: CancellationException) {
          println("Child 5 -> Job Cancelled: ${ex.message}")
        }
      }

      /*
          with this method of try block around the entire coroutine scope
          will result in exception to be swallowed and not be able to
          catch and handle that exception.

          In order to handle cancellation exception you need to try
          and catch within the coroutine scope as done with child5 example.
       */
      try {
        child6 = launch {

          repeat(1000) {
            Thread.sleep(1000)
            ensureActive()
            print(" C6 |")
          }
        }
      } catch (ex: CancellationException) {
        println("Child 6 -> Job Cancelled: ${ex.message}")
      }

      repeat(1000) {
        delay(1000)
        print(" Parent |")
      }
    }

    delay(4000)
    child6?.cancelAndJoin()

    println()
    println()
    println(80.separator())
    println("parentJob is Cancelled: ${parentJob.isCancelled}")
    println("parentJob is active: ${parentJob.isActive}")
    println(80.separator())

//        delay(10000)
//        parentJob.cancelAndJoin()

    parentJob.join()
  }

  println("coroutineScope Finished")
}
