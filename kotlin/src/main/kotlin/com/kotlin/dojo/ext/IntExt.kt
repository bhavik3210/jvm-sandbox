package com.kotlin.dojo.ext

fun Int.separator(separator: String = "="): String {
  return separator.repeat(this)
}
