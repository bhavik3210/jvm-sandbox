package com.kotlin.dojo.courses.kotlinFundamentals

import com.google.gson.JsonElement
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import com.kotlin.dojo.courses.kotlinFundamentals.KFProgrammingWithTypes.Companion.programmingWithTypes
import com.kotlin.dojo.ext.printSubtitle
import java.io.File
import java.lang.reflect.Type

/**
 * Classes
 * - public by default
 * - final by default, if you want to make then open you have use syntax open before classes
 * - Interfaces [Time] [EndOfTheWorld]
 * - Interface Implementation [YetiTime]
 * - open classes [OpenPerson]
 * - abstract classes [AbstractPerson]
 * - sealed classes [PersonEvent]
 * - data classes [DataStudent]
 * - Modifiers (public by default)
 * - constructors
 * - Companion Objects
 *  - Kotlin does not have static members but you can use companion object [programmingWithTypes] which allows similar functionality
 *  - can be used as factory methods [createUnderGraduate] [createPostGraduate]
 */
class KFProgrammingWithTypes {

  /**
   * 05 - Programming with Types
   */
  companion object {

    fun programmingWithTypes() {
      "Programming with Types".printSubtitle()

      val student = DataStudent(12, "NAME")
      println(student)
      println("Student Hash Code: ${student.hashCode()}")

      val copyStudent = student.copy(id = 43, name = "COPIED Student NAME")
      println(copyStudent)
      println("Student Hash Code: ${copyStudent.hashCode()}")
    }

    fun companionObject() {
      "Companion Objects".printSubtitle()

      /**
       * - Kotlin does not have static methods
       * - However can have "singletons"
       * - Use 'object' keyword to create singleton
       * - Use 'companion object' to get "statics" or equivalent of java static (not truly static unless you use annotation @JvmStatic)
       * - Note: this is different when you declare functions without classes
       *          which are generated as static inside kotlin bytecode
       * - 'object' Keyword: creates a singleton, actually defines a class and creates an instance in one go
       *                     Can have properties, methods, initializers BUT CANNOT have constructors
       * - Kotlin does not have static members BUT you can use companion object [programmingWithTypes] which allows similar functionality
       * - can be used as factory methods [createUnderGraduate] [createPostGraduate]
       * - @JvmStatic annotation is used if you purely want to use static methods from Java world (JVM point of view)
       */
      Student.createUnderGraduate("John")
      Student.createPostGraduate("James")
    }
  }
}


/**
 * Kotlin Visibility Modifiers:
 * by default, classes are closed (i.e. final in java) so they cannot be extended without open
 * 'public': visible everywhere
 * 'private': visible inside the same class only
 * 'internal': visible inside the same module
 * 'protected': visible inside the same class and its subclasses
 *  https://www.geeksforgeeks.org/kotlin-visibility-modifiers/
 *
 */
interface Time {
  fun setTime(hours: Int, mins: Int = 0, secs: Int = 0)
  fun setTime(time: MyTime) =
    setTime(time.hours)//you can provide default implementation so it is not required to be override by implmenter
}

interface EndOfTheWorld {
  fun setTime(time: MyTime) {}
}

class MyTime {
  val hours: Int = 0
  var minutes: Int = 0
  var seconds: Int = 0
}

class YetiTime : Time, EndOfTheWorld {
  override fun setTime(hours: Int, mins: Int, secs: Int) {}

  override fun setTime(time: MyTime) {
    //you can do one or the other or BOTH
    super<Time>.setTime(time)
    super<EndOfTheWorld>.setTime(time)
  }

}

/**
 * have to make it so Student below can be derived from Person
 * by default it is final in Kotlin
 */
open class OpenPerson(val firstName: String, val lastName: String) {

  open fun getFullName() = "$firstName $lastName"
}

open class Student(firstName: String, lastName: String, _id: Int, var tutor: String = "") :
  OpenPerson(firstName, lastName) {
  val id: Int

  init {
    id = _id
  }

  fun enroll(courseName: String) {
    val course = Courses.allCourse.firstOrNull { it.title == courseName }
  }

  override fun getFullName(): String {
    return "Open Student's Name"
  }

  companion object : JsonSerializer<Student> {
    fun createUnderGraduate(name: String): Undergraduate {
      return Undergraduate(name)
    }

    fun createPostGraduate(name: String): Postgraduate {
      return Postgraduate(name)
    }

    /*
      To demo that you can use this companion object to serialize as well
     */
    override fun serialize(src: Student?, typeOfSrc: Type?, context: JsonSerializationContext?): JsonElement {
      TODO("Not yet implemented")
      //You can use incoming json and create Undergrad or postgrad instance above and add it to a collection
    }
  }
}

/**
 * Abstract Class
 */
abstract class AbstractPerson {
  var firstName = ""
  var lastName = ""

  open fun getName() = "$firstName $lastName"
  abstract fun getAddress(): String
}

class AbstractStudent : AbstractPerson() {
  override fun getName(): String {
    return "Abstract Student's Name"
  }

  override fun getAddress(): String {
    return "Abstract Student's Address"
  }
}

/**
 * Sealed Class
 * - Used to restrict class hierarchies
 * - "Enums on Steroids"
 */
sealed class PersonEvent {
  object Awake : PersonEvent() // you can use object because this "object" wouldn't have a state
  object Asleep : PersonEvent()
  class Eating(val food: String) : PersonEvent()
}

fun handlePersonEvent(event: PersonEvent) {
  when (event) {
    is PersonEvent.Asleep -> println("Awake")
    is PersonEvent.Awake -> println("Asleep")
    is PersonEvent.Eating -> println(event.food)
  }
}


/**
 * Data Class
 * - Provide a convenient way to override equals, hashCode, and toString
 * - Typically immutable classes
 * - Kotlin also generates 'copy' method, which is copy by value
 * - usually comparison is also done by value and not by reference
 * - can also be declared inside another class
 */
data class DataStudent(val id: Int, val name: String)


class Course(val id: Int, val title: String) {

}

/**
 * Object Class
 * Singletons can also be Anti patterns because of limited ability for testing
 */
object Courses {
  var allCourse = arrayListOf<Course>()

  fun initializer() { // not a constructor
    allCourse.add(Course(1, "Kotlin Fundaments"))
  }
}


object CaseInsensitiveComparator : Comparator<File> {
  // Can be used with inheritance
  // for example, if we want to extend file comparator
  override fun compare(o1: File?, o2: File?): Int {
    TODO("Not yet implemented")
  }
}

class Undergraduate(firstName: String) : Student(firstName, "", 1)
class Postgraduate(firstName: String) : Student(firstName, "", 1)