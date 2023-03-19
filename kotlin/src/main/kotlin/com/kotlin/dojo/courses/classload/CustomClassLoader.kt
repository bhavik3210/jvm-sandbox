package com.kotlin.dojo.courses.classload

import java.net.URL
import java.net.URLClassLoader

object CustomClassLoader {
  fun printOutClassLoader() {
    val classLocation = "file:///home/bhavik/Workspace/titanium/lib/Quoter.jar"
    val packageToLoad = "com.mantiso.Quote"
    try {
      val urlClassLoader = URLClassLoader(arrayOf(URL(classLocation)))
      val clazz = urlClassLoader.loadClass(packageToLoad)
      val obj = clazz.newInstance()
      print(obj.toString())
    } catch (ex: Exception) {
      ex.printStackTrace()
    }
  }
}
