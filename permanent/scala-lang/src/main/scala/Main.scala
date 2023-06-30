package dojo.lang.scala

object Main {
  def main(args: Array[String]): Unit = {
    //    demoFunctions()
    demoForLoop()
  }

  def demoForLoop(): Unit = {
    // Generator Expression: Array(1, 2))
    // Generator: value <- Array(1, 2)
    val amounts = Array(10, 23, 98, 54, 34)
    for (value <- amounts) {
      println(value)
    }

    //Expression for for loop iteration
    val decimalAmount: Array[Double] = for (value <- amounts) yield {
      value.toDouble // You can transform a type
    }
    println()
    for (v <- decimalAmount) {
      println(v)
    }

    //Expression with for loop that you can use to transform with conditions
    val currencies = Array("USD", "MXN", "INR", "NZD", "USD")
    val amountWithCurrency: Array[String] = for {
      amount <- decimalAmount
      currency <- currencies
      if amount > 20 && (currency == "NZD" || currency == "USD") //without this condition it will return all permutations
    } yield currency + " " + amount
    println()

    // For each is a statement
    amountWithCurrency.foreach(value => print(value + " | "))


    // While loop
    println()
    var i = 1
    while (i <= 10) {
      println(i)
      i += 1
    }

    // do while loop
    println()
    var j = -10
    do {
      println(j)
      j -= 1
    } while (j > 0)
  }

  def demoFunctions(): Unit = {
    demoIfStatement()
  }

  def demoIfStatement(): Unit = {
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