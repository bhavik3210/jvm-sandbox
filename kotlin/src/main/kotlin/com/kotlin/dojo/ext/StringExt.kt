package com.kotlin.dojo.ext

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

fun String.printTitle() {
  println(getTitleFormat())
}

fun String.printSubtitle() {
  println()
  println(getSubTitleFormat())
}

fun String.getTitleFormat(): String {
  return "${50.separator()}\n $this \n${50.separator()}"
}

fun String.getSubTitleFormat(): String {
  return "${5.separator("-")} $this ${5.separator("-")}"
}

fun String.toLocalDateTime(): LocalDateTime? = try {
  DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse(this, OffsetDateTime::from).toLocalDateTime()
} catch (_: Exception) {
  try {
    DateTimeFormatter.ISO_LOCAL_DATE_TIME.parse(this, LocalDateTime::from)
  } catch (_: Exception) {
    try {
      DateTimeFormatter.ISO_LOCAL_DATE.parse(this, LocalDate::from).atStartOfDay()
    } catch (_: Exception) {
      null
    }
  }
}
