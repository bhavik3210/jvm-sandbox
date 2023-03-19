package com.kotlin.dojo.courses.kotlinCoroutinesGettingStarted

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope

fun main() {
  demoSupervisorScope()
//    demoSupervisorJobThatDoesWork()
//    demoSupervisorJobThatDoesntWork
}

/**
 * SupervisorJob vs SupervisorScope
 * SupervisorJob has to be direct parent
 *
 * To use SupervisorScope instead for better way to doing this where
 * exception thrown by child won't cancel parent and its siblings
 *
 * General notes on SupervisorJob and SupervisorScope
 *
 * Exception thrown on child coroutine Behavior:
 * Job/coroutineScope
 * - Child is cancelled
 * - Parent is cancelled
 * - Siblings are cancelled
 *
 * SupervisorJob/supervisorScope
 * - Child is cancelled
 * - Parent is not cancelled
 * - siblings are not cancelled
 *
 * SupervisorJob to work it has to be direct parent of child throwing exception
 * You have to use SupervisorJob in conjunction with CoroutineScope
 * However, now individual child coroutines are not really siblings
 *
 */
fun demoSupervisorScope() = runBlocking {
  val launchParent = SupervisorJob()
//    val scope = CoroutineScope(SupervisorJob())
  val job = launch(launchParent) {

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

/**
 * SupervisorJob vs SupervisorScope
 * SupervisorJob has to be direct parent
 *
 * This works but not ideal because it will break the parent child hierarchy.
 * so not the best practice even though it works
 *
 *
 */
fun demoSupervisorJobThatDoesWork() = runBlocking {
  val launchParent = SupervisorJob()
  val scope = CoroutineScope(SupervisorJob())
  val job = launch(launchParent) {

    val j1 = coroutineContext[Job]

    scope.launch {
      doWork(1)
    }

    scope.launch {
      doWork(2)
    }

    val j2 = scope.launch {
      delay(2000)
      throw Exception()
    }

    delay(5000)
  }

  job.join()
}

/**
 * SupervisorJob vs SupervisorScope
 * SupervisorJob has to be direct parent
 *
 * SupervisorJob in code below will still throw exception and stop
 * other coroutines because it is a grandparent coroutine and not
 * parent routine.
 * j1 here is the parent and
 * launchParent is the parent
 * that's why same behavior
 */
fun demoSupervisorJobThatDoesntWork() = runBlocking {
  val launchParent = SupervisorJob()
  val scope = CoroutineScope(Job())
  val job = launch(launchParent) {

    val j1 = coroutineContext[Job]

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

  job.join()
}
