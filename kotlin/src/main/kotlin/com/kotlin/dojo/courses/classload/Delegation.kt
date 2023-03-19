package com.kotlin.dojo.courses.classload

import com.kotlin.dojo.ext.separator
import java.net.URLClassLoader

object Delegation {

  fun printJava8DelegationForClassLoading() {
    var classLoader: URLClassLoader? = ClassLoader.getSystemClassLoader() as URLClassLoader
    do {
      println(classLoader)
      classLoader?.urLs?.forEach {
        print("\t ${it.path} \n")
      }
    } while ((classLoader?.parent as URLClassLoader?).also { classLoader = it } != null)
    println("Bootstrap Classloader Delegation Reached")
    println(50.separator())
  }

//  fun printJava11DelegationForClassLoading() {
//    var classLoader = ClassLoader.getSystemClassLoader()
//    do {
//      println(classLoader?.name)
//    } while ((classLoader?.parent).also { classLoader = it } != null)
//    println("Bootstrap Classloader Delegation Reached")
//    println(50.separator()
//  }
}
