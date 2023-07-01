package dojo.lang.scala

object PatternMatching {
  def demo(): Unit = {
    var amount = 50

    amount match {
      case 10 => println("$10")
      case 30 => println("$30")
      case 50 => println("$50")
      case 70 => println("$70")
      case 100 => println("$100")
      case _ => println("didn't match anything")
    }

    // Variable Pattern Matching
    amount = 100
    amount match {
      case a if a == 50 => println("amount is $50")
      case a if a == 100 => println("amount is $100")
      case a => println(s"amount is ${a}")
    }

    // Pattern matching as an expression
    amount = 30
    val result = amount match {
      case a if a == 100 => "amount is $100"
      case a if a == 50 => "amount is $50"
      case a => s"amount is $a"
    }
    println(result)

    //Pattern matching with classes
    abstract class Currency

    case class USD() extends Currency

    case class CAD() extends Currency

    case class NZD() extends Currency

    val currency: Currency = NZD()

    amount = 100

    currency match {
      case u: USD => println(s"USD $amount")
      case c: CAD => println(s"CAD $amount")
      case n: NZD => println(s"NZD $amount")
    }

    val array = Array(100, 200, 300)

    array match {
      case Array(first, second, _) => println(s"second number is $second")
    }

    val tuple = ("NZD", 140)
    tuple match {
      case (currency, amount) if currency == "USD" => println(s"USD $amount")
      case (currency, amount) if currency == "NZD" => println(s"NZD $amount")
    }

  }


}
