package com.kotlin.dojo.designPatterns.creational

class TitaniumSingletonPattern private constructor() {
  companion object {
    /*
      @Volatile: this will ensure the instance will remain singleton
      regardless of any changes that occur in JVM.
     */
    @Volatile
    private var instance: TitaniumSingletonPattern? = null

    init {
      /*
       To make sure no one uses reflection on this code.
       To prevent instantiation with use of reflection.
      */
      if (instance != null) {
        throw java.lang.RuntimeException("Use getInstance() method to create")
      }
    }

    fun getInstance(): TitaniumSingletonPattern {
      /*
        Synchronize check:
        - we can make entire function synchronize but that will take performance hit.
        because everytime we ask for instance it will synchronize class and slow it down.

        Instead: synchronize only the creation if the instance is null otherwise there
        is no need to synchronize. So it will only synchronize on creation of the singleton instance.
        After that it won't.
       */
      if (instance == null) {
        synchronized(TitaniumSingletonPattern::class.java) {
          if (instance == null) {
            instance = TitaniumSingletonPattern()
          }
        }
      }
      return instance!!
    }
  }
}

/*
fun main() {

  val singletonInstanceA = TitaniumSingleton.getInstance()
  println(singletonInstanceA)

  val singletonInstanceB = TitaniumSingleton.getInstance()
  println(singletonInstanceB)

  val runtimeASingleton = Runtime.getRuntime()
  val runtimeBSingleton = Runtime.getRuntime()

  if (runtimeASingleton == runtimeBSingleton) {
    println("Both instances of runtime are the same reference")
  }
}
*/
