package com.kotlin.dojo.util

import com.google.gson.Gson
import java.io.File
import java.io.InputStreamReader

class JsonAssetReader {
  val gson by lazy { Gson() }
  inline fun <reified T> read(fileName: String): T {
    return gson.fromJson(
      InputStreamReader(File(fileName).inputStream()),
      object : com.google.gson.reflect.TypeToken<T>() {}.type
    )
  }
}
