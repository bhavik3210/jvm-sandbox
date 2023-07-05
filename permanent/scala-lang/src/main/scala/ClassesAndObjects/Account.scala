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
  private val johnsAccount: Account = new Account(UUID.randomUUID(), "John Doe", LocalDateTime.now())
  private val janesAccount: Account = new Account(UUID.randomUUID(), "Jane Doe", LocalDateTime.now.plusHours(24))
  private val johnSmithAccount: Account = new Account("John Smith")

  println(johnsAccount._id, johnsAccount._name, johnsAccount._dateOpened)
  println(janesAccount._id, janesAccount._name, janesAccount._dateOpened)
  println(johnSmithAccount._id, johnSmithAccount._name, johnSmithAccount._dateOpened)
}