package com.kotlin.dojo.courses.kotlinCoroutinesGettingStarted

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
  demoUnderstandingCoroutineJobs()
}

/**
 * Creation of jobs by launching and
 * understanding their hierarchy in relation to parent jobs
 */
fun demoUnderstandingCoroutineJobs() = runBlocking {
  val launchParent = Job()
  println("launchParent: $launchParent")
  val scope = CoroutineScope(launchParent)

  // "parentJob" is the parent job (a.k.a. launchParent)
  val parentJob = scope.launch {
    /*
    "childJob1" is a children of "parentJob"

    ".launch" will create another job which can be accessed through coroutineContext[Job]
     and this new job is child
     */
    val childJob1 = coroutineContext[Job]

    val grandChildJob2 = launch {
      /*
        By running launch again with in childJob1, this will create another child job of that Child
        In the case below grandChild2Job is another child job of [childJob1]
       */
      val grandChild2Job = coroutineContext[Job]
      delay(500)
    }

    println("Job passed to the scope.launch as the new context: $launchParent")
    displayChildren(0, launchParent)
    println("Job returned from the scope.launch as the new job: $childJob1")
    childJob1?.let { displayChildren(0, it) }
    println("Job returned from child launch (j2): $grandChildJob2")
    displayChildren(0, grandChildJob2)

    grandChildJob2.join()
  }

  /*
   anytime you call a "launch" it will create a Job children of
   and return the children job upon completion
   */

  parentJob.join()
}

fun displayChildren(depth: Int = 0, job: Job) {
  job.children.forEach {
    for (i in 0..depth) {
      print("\t")
    }
    println("child: $it")
    displayChildren(depth + 1, it)
  }
}
