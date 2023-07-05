package dojo.lang.scala
package ClassesAndObjects

import java.time.LocalDateTime
import java.util.UUID

class Account(id: UUID, name: String, dateOpened: LocalDateTime) {
  private val _id: UUID = id
  private val _name: String = name
  private val _dateOpened: LocalDateTime = dateOpened

  def this(name: String) = {
    this(UUID.randomUUID(), name, LocalDateTime.now())
  }
}

object AccountRunner extends App {
  private val johnDoeAccount: Account = new Account(UUID.randomUUID(), "John Doe", LocalDateTime.now())
  private val janeDoeAccount: Account = new Account(UUID.randomUUID(), "Jane Doe", LocalDateTime.now.plusHours(24))
  private val johnSmithAccount: Account = new Account("John Smith")

  println(johnDoeAccount._id, johnDoeAccount._name, johnDoeAccount._dateOpened)
  println(janeDoeAccount._id, janeDoeAccount._name, janeDoeAccount._dateOpened)
  println(johnSmithAccount._id, johnSmithAccount._name, johnSmithAccount._dateOpened)
}