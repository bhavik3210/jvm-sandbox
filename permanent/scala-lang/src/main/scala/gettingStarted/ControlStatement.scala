package dojo.lang.scala
package gettingStarted

object ControlStatement {
  def demo(): Unit = {
    val number = 10

    // Statement
    if (number > 10) {
      println("> 10")
    } else {
      println("< 10")
    }

    // Expression
    val result = if (number > 10) {
      "> 10"
    } else if (number == 10) {
      "== 10"
    } else {
      "< 10"
    }
    println(result)
  }
}
