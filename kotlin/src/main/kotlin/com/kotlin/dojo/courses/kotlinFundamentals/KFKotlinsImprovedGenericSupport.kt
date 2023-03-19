package com.kotlin.dojo.courses.kotlinFundamentals

import com.kotlin.dojo.ext.printSubtitle

class KFKotlinsImprovedGenericSupport {

  init {
    "Understand Kotlin's Improved Generic Support".printSubtitle()
  }

  companion object {
    fun improvedGenericSupport() {
      var names: List<String> = listOf("First", "Second")
      val name = names.itemAt(0)
      println(name)

      val n: Node<Int> = Node(2)
//      val n:Node<String> = Node(2) //will not work because generic type is constratined to Number type
      println(n.value())

      /*
        Reif: - Make into a thing, make real
        Generally types are erase, cannot check generic type at runtime

        Reifing Types
        - Generic functions have types erased however can mark type as reified
        - works only on inline functions
      */


      /*
      Generic Variance in kotlin
      out and in
       */
      val financeMeeting = mutableListOf<FinanceMeeting>()
      val meetings: AllMeetings<FinanceMeeting> = AllMeetings(financeMeeting)

      attendAllMeetings(meetings)
    }

    /*
        If you don't have reified here the compiler will complain with
        "Cannot check for instance of erased type: T" message because at runtime it won't know the type
        to persist this at runtime, use reified
     */
    inline fun <reified T> List<*>.typeOf(): List<T> {
      val returnList = mutableListOf<T>()

      for (item in this) {
        if (item is T) {
          returnList.add(item)
        }
      }

      return returnList
    }

    fun <T : Meeting> buildMeeting(meetingClass: Class<T>, action: (T) -> Unit): T {
      val meeting: T = meetingClass.getConstructor().newInstance()
      action(meeting)
      return meeting
    }

//    inline fun <reified T: Meeting> buildMeeting(action: (T) -> Unit) : T {
//      val meeting = T::class.java.getConstructor().newInstance()
//      action(meeting)
//      return meeting
//    }

    inline fun <reified T : Meeting> buildMeeting(noinline action: (T) -> Unit): T {
      /*
        passing action like this is throws this error
        Illegal usage of inline-parameter 'action' in 'public final inline fun <reified T : KFKotlinsImprovedGenericSupport.Companion.Meeting> buildMeeting(action: (T) -> Unit): T defined in com.kotlin.dojo.courses.kotlinFundamentals.KFKotlinsImprovedGenericSupport.Companion'. Add 'noinline' modifier to the parameter declaration
        because inline is declared the lambda action is inlined but that action is passed to non-inline function so that cannot be done.
        to overcome this issues you can mark action noinline
        action cannot be inline here because it is stored as a variable and not being used directly
       */
      return buildMeeting(T::class.java, action)
    }

    internal open class Meeting {

    }

    internal class BoardMeeting : Meeting() {

    }

    internal class FinanceMeeting : Meeting() {

    }

    internal class AllMeetings<out T : Meeting>(val meetings: List<Meeting>) {
      val count: Int get() = meetings.count()

      operator fun get(i: Int) = meetings[i]
    }

    private fun attendAllMeetings(meetings: AllMeetings<Meeting>) {
      for (i in 0 until meetings.count) {
        meetings[i].attend()
      }
    }

    private fun Meeting.attend() {

    }
  }


}

fun <T> List<T>.itemAt(ndx: Int): T {
  return this[ndx]
}

//class Node<T>(private val item: T) {
//  fun value(): T {
//    return item
//  }
//}
class Node<T : Number>(private val item: T) {
  fun value(): T {
    return item
  }
}

