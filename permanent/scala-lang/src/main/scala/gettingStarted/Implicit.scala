package dojo.lang.scala
package gettingStarted

import scala.language.implicitConversions
case class Currency(code: String, amount: Double, toUSD: Double)

object Implicit extends App {
  implicit def stringToCurrency(money: String): Currency = {
    val Array(code: String, value: String) = money.split("\\s")
    val amountAsDouble = value.toDouble
    code match {
      case "USD" => Currency("USD", amountAsDouble, amountAsDouble)
      case "NZD" => Currency("NZD", amountAsDouble, (amountAsDouble * (1 / 1.5)))
      case "CAD" => Currency("CAD", amountAsDouble, (amountAsDouble * (1 / 1.3)))
    }
  }

  println(stringToCurrency("USD 100")) // explicit conversion
  println(stringToCurrency("NZD 100")) // explicit conversion

  val cad: Currency = "CAD 100" //by adding the keyword implicit in above function, this type of implicit conversion is possible
  // All implicits are available via import.Implicit.stringToCurrency
}
