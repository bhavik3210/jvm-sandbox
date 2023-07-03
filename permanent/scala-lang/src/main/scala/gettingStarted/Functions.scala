package dojo.lang.scala
package gettingStarted

object Functions {
  def demo(): Unit = {
    val sqOf2 = square(2)
    println(sqOf2)


    val mulResult = multiply(10, 30)
    println(mulResult)


    println(multiply(1, 2, 3, 4, 5))

    sumOdd(10)

    greet("John", "Smith")
    greet("Smith", "John")
    greet(last = "Smith", first = "John")
    greetWithDefaultValues(first = "John")
    higherOrderFunctions()
  }

  def square(x: Int): Int = {
    x * x
  }

  def multiply(x: Int, y: Int) = x + y

  //overloaded function
  def multiply(nums: Int*): Int = {
    var product = 1
    for (num <- nums) product = product * num
    product
  }

  //local functions
  def sumOdd(n: Int) = {
    def getOdd(x: Int): Array[Int] = {
      var result = Array[Int]()
      var current = 1
      while (current <= x) {
        if (current % 2 == 1) result = result :+ current // :+ operator what does it do? https://stackoverflow.com/questions/7888944/what-do-all-of-scalas-symbolic-operators-mean
        current = current + 1
      }
      result
    }

    val odds = getOdd(n)
    println(odds.mkString(","))
    println(odds.sum)
  }

  // named argument
  def greet(first: String, last: String): Unit = {
    println(s"Hello! $first $last")
  }

  // default values
  def greetWithDefaultValues(first: String = "first", last: String = "last"): Unit = {
    println(s"Hello! $first $last")
  }

  def higherOrderFunctions(): Unit = {
    def square(n: Int) = n * n

    def cube(n: Int): Int = n * n * n

    def sum(a: Int, b: Int) = a + b

    def length(a: String) = a.length

    def transform(f: Int => Int, numbers: Int*) = {
      numbers.map(f)
    }

    transform(square, 1, 2, 3, 4).foreach(value => print(value + ","))
    println()

    // anonymous function
    transform((n: Int) => n * n, 1, 2, 3, 4).foreach(value => print(value + ","))
    //    transform(n => n * n, 1, 2, 3, 4).foreach(value => print(value + ","))
    println()
  }
}
