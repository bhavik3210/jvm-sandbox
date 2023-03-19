package com.kotlin.dojo.courses.kotlinCoroutinesGettingStarted

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
  demoCreateCoroutineScope()
}

/**
 * Creating your own coroutine scope
 * onCreate and onDestroy are android fragment representation
 * to showcase lifecycle of coroutinescope can be built based
 * on android fragment/view lifecycle
 */
fun demoCreateCoroutineScope() {
  val myCoroutineScope: CoroutineScope = MainScope() // factory coroutine method

  fun onCreate() {
    myCoroutineScope.launch {
      while (true) {
        delay(1000)
        /* do what you need to do */
      }
    }
  }

  fun onDestroy() {
    myCoroutineScope.cancel()
  }
}
