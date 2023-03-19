package com.kotlin.dojo.courses.kotlinFundamentals

import com.kotlin.dojo.ext.printSubtitle

class KFNullability {

  init {
    "Using Kotlin's Nullability Constraints to Improve Code".printSubtitle()
  }

  companion object {
    fun demoNullability() {
      val demo = KFNullability()

      val m: Meeting? = null

      var newMeeting: Meeting = m ?: Meeting()
    }
  }

  fun closeMeeting(m: Meeting?): Boolean? {
    return if (m?.canClose == true) m.close()
    else false
  }

  class Meeting {
    var canClose = false
    lateinit var address: Address // have to make sure you initialize this (try to avoid this as much as possible)

    fun close(): Boolean {
      return false
    }
  }

  class Address {

  }

}