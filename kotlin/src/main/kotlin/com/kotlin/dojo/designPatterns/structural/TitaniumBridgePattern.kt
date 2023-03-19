package com.kotlin.dojo.designPatterns.structural

import com.kotlin.dojo.ext.getTitleFormat

fun main() {
  //region demo WITHOUT Bridge pattern using just inheritance
  val circleA: TitaniumBridgePatternA.Circle = TitaniumBridgePatternA.BlueCircle()
  val squareA: TitaniumBridgePatternA.Square = TitaniumBridgePatternA.RedSquare()
  val greenSquareA: TitaniumBridgePatternA.Square = TitaniumBridgePatternA.GreenSquare()
  println(circleA.applyColor())
  println(squareA.applyColor())
  println(greenSquareA.applyColor())
  //endregion

  println(" ".getTitleFormat())
  //region demo with bridge patter
  val blueColorB = TitaniumBridgePatternB.BlueColor()
  val redColorB = TitaniumBridgePatternB.RedColor()
  val greenColorB = TitaniumBridgePatternB.GreenColor()

  val squareB = TitaniumBridgePatternB.Square(blueColorB)

  val circleB = TitaniumBridgePatternB.Circle(redColorB)

  val greenCircleB = TitaniumBridgePatternB.Circle(greenColorB)
  val greenSquareB = TitaniumBridgePatternB.Square(greenColorB)

  println(squareB.applyColor())
  println(circleB.applyColor())
  println(greenCircleB.applyColor())
  println(greenSquareB.applyColor())
  //endregion

  println(" ".getTitleFormat())

  val movie = TitaniumBridgePattern.Movie(
    classification = "Classification",
    runtime = "Runtime",
    title = "Title",
    year = "Year"
  )

  // here moviePrinter is the bridge between movie and HTMLFormatter or PrintFormatter
  val moviePrinter = TitaniumBridgePattern.MoviePrinter(movie)
  val htmlFormatter = TitaniumBridgePattern.HtmlFormatter()
  val printFormatter = TitaniumBridgePattern.PrintFormatter()

  println(moviePrinter.print(htmlFormatter))
  println()
  println(moviePrinter.print(printFormatter))

  println("Reusing Formatters with Book Printer".getTitleFormat())

  val book = TitaniumBridgePattern.Book(
    "BOOK_ISBN",
    "Book Title",
    "Author Name"
  )

  val bookPrinter = TitaniumBridgePattern.BookPrinter(book)

  println(bookPrinter.print(htmlFormatter))
  println()
  println(bookPrinter.print(printFormatter))
}

class TitaniumBridgePattern {
  data class Movie(
    internal val classification: String,
    internal val runtime: String,
    internal val title: String,
    internal val year: String
  )

  data class Book(
    internal val isbn: String,
    internal val title: String,
    internal val author: String
  )

  data class Detail(
    internal val label: String,
    internal val value: String
  )

  interface Formatter {
    fun format(header: String, details: List<Detail>): String
  }

  class PrintFormatter : Formatter {
    override fun format(header: String, details: List<Detail>): String {
      val builder = StringBuilder()
      builder.append(header)
      builder.append("\n")

      details.forEach {
        builder.append(it.label)
        builder.append(":")
        builder.append(it.value)
        builder.append("\n")
      }

      return builder.toString()
    }
  }

  class HtmlFormatter : Formatter {
    override fun format(header: String, details: List<Detail>): String {
      val builder = StringBuilder()
      builder.append("<table>")
      builder.append("<th>")
      builder.append("Classification")
      builder.append("</th>")
      builder.append("<th>")
      builder.append(header)
      builder.append("</th>")

      details.forEach {
        builder.append("<tr><td>")
        builder.append(it.label)
        builder.append("</td><td>")
        builder.append(it.value)
        builder.append("</td></tr>")
      }
      builder.append("</table>")

      return builder.toString()
    }
  }

  /*
      This allows us to have variations of formatter and Printer(for book, movie, etc)
   */
  abstract class Printer {
    // Heart of the Bridge Pattern
    // Bridges between Movie and Formatter to format movie's details
    fun print(formatter: Formatter): String {
      return formatter.format(getHeader(), getDetails())
    }

    abstract fun getHeader(): String
    abstract fun getDetails(): List<Detail>
  }

  class BookPrinter(private val book: Book) : Printer() {
    override fun getHeader(): String {
      return book.title
    }

    override fun getDetails(): List<Detail> {
      val details = mutableListOf<Detail>()
      details.add(Detail("ISBN", book.isbn))
      details.add(Detail("Author", book.author))
      return details
    }
  }

  class MoviePrinter(private val movie: Movie) : Printer() {
    override fun getHeader(): String {
      return movie.classification
    }

    override fun getDetails(): List<Detail> {
      val details = mutableListOf<Detail>()

      details.add(Detail("Title", movie.title))
      details.add(Detail("Year", movie.year))
      details.add(Detail("Runtime", movie.runtime))

      return details
    }
  }
}

//region demo WITH Bridge pattern using composition
class TitaniumBridgePatternB {
  abstract class Shape(protected val color: Color) {
    abstract fun applyColor(): String
  }

  class Circle(color: Color) : Shape(color = color) {
    override fun applyColor(): String {
      return color.applyColor()
    }
  }

  class Square(color: Color) : Shape(color = color) {
    override fun applyColor(): String {
      return color.applyColor()
    }
  }

  interface Color {
    fun applyColor(): String
  }

  class GreenColor : Color {
    override fun applyColor(): String {
      return "Applying Green Color to a ${this.javaClass.kotlin.simpleName}"
    }
  }

  class BlueColor : Color {
    override fun applyColor(): String {
      return "Applying Blue Color to a ${this.javaClass.kotlin.simpleName}"
    }
  }

  class RedColor : Color {
    override fun applyColor(): String {
      return "Applying Red Color to a ${this.javaClass.kotlin.simpleName}"
    }
  }
}

//region demo WITHOUT Bridge pattern using just inheritance
class TitaniumBridgePatternA {

  abstract class Shape {
    abstract fun applyColor(): String
  }

  abstract class Circle : Shape()
  abstract class Square : Shape()

  class BlueCircle : Circle() {
    override fun applyColor(): String {
      return "Applying Blue Color to a ${this.javaClass.kotlin.simpleName}"
    }
  }

  class RedCircle : Circle() {
    override fun applyColor(): String {
      return "Applying Red Color to a ${this.javaClass.kotlin.simpleName}"
    }
  }

  class BlueSquare : Square() {
    override fun applyColor(): String {
      return "Applying Blue Color to a ${this.javaClass.kotlin.simpleName}"
    }
  }

  class GreenSquare : Square() {
    override fun applyColor(): String {
      return "Applying Green Color to a ${this.javaClass.kotlin.simpleName}"
    }
  }

  class RedSquare : Square() {
    override fun applyColor(): String {
      return "Applying Red Color to a ${this.javaClass.kotlin.simpleName}"
    }
  }
}
