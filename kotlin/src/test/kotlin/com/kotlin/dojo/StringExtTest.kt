package com.kotlin.dojo

import com.kotlin.dojo.ext.toLocalDateTime
import org.amshove.kluent.shouldBeNull
import org.amshove.kluent.shouldNotBeNull
import org.junit.jupiter.api.Test

class StringExtTest {

  val dates = listOf(
    "2021-12-31T00:00:00-06:00",
    "2017-02-17",
    "2017-02-17T00:00:00"
  )

  @Test
  fun `should be able to parse string to local date time`() {
    val validFormatA = "2021-12-31T00:00:00-06:00"
    val validFormatB = "2017-02-17"
    val validFormatC = "2017-02-17T00:00:00"
    val invalidFormatD = "02-17"

    validFormatA.toLocalDateTime().shouldNotBeNull()
    validFormatB.toLocalDateTime().shouldNotBeNull()
    validFormatC.toLocalDateTime().shouldNotBeNull()
    invalidFormatD.toLocalDateTime().shouldBeNull()
  }
}
