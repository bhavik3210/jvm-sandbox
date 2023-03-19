package com.kotlin.dojo.courses.kotlinCoroutinesGettingStarted

import com.kotlin.dojo.ext.separator
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
  demoJoining()
  println(50.separator())
  demoCancellation()
}

/**
 * Joining Coroutines
 */
fun demoJoining() = runBlocking {
  val job = launch {
    delay(3000)
    print("World")
  }
  print("Hello, ")
  // join is used to wait for completion of the launched coroutine and it does not propagate its exception
  job.join() // this will wait until "job" coroutine is finished it's work
  println("!!!!") // if you remove .join on the job, then it will print this `!!!!` before `World`
}

/**
 * Cancellation of Coroutines
 */
fun demoCancellation() = runBlocking {
  val job = launch {
    repeat(1_000) {
      delay(10)
      print(".")
    }
  }

  /**
   * https://stackoverflow.com/questions/61121051/coroutine-difference-between-join-and-cancelandjoin
   * https://proandroiddev.com/kotlin-coroutine-job-hierarchy-finish-cancel-and-fail-2d3d42a768a9
   *
   * When we call job.cancel() the cancellation procedure(transition from completing to cancelling)
   * starts for the job. But we still need to wait, as the job is truly cancelled only when it reaches
   * the cancelled state. Hence we write job.cancelAndJoin(), where cancel() starts the cancellation
   * procedure for job and join() makes sure to wait until the job() has reached the cancelled state.
   */
  delay(200)
//        job.cancel()
//        job.join()
  job.cancelAndJoin() // is used to wait for completion of the launched coroutine and it does not propagate its exception
  println("Done")
}
