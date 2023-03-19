package com.kotlin.dojo.courses.kotlinFundamentals

import com.kotlin.dojo.ext.printSubtitle

class KFKotlinCollectionsClasses {
  init {
    "Kotlin Collection Classes".printSubtitle()
  }

  companion object {
    fun demoKotlinCollectionsClasses() {

      //essentially all kotlin collections are just java collections internally

      val demo = KFKotlinCollectionsClasses()
//      val people: List<Person?>? = null
//      val people: List<Person?> = listOf(Person(32), null)
//      val people = listOf(Person(32), Person(23), null) //immutable list so cannot add
      val people = mutableListOf(Person(32), Person(23), null) //immutable list so cannot add
      people.add(null)

      for (person: Person? in people) {
        println(person?.age)
      }

      for (person: Person in people.filterNotNull()) {
        println(person.age)
      }

      val args = arrayOf("Hello", "world")
      args.forEachIndexed { index, s ->
        println(index)
      }


    }
  }

  internal class Person(val age: Int) {

  }
}