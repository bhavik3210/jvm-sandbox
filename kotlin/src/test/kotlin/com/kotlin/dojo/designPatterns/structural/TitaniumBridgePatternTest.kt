package com.kotlin.dojo.designPatterns.structural

import kotlin.test.assertEquals
import org.amshove.kluent.shouldBeInstanceOf
import org.junit.jupiter.api.Test

class TitaniumBridgePatternTest {

  @Test
  fun `test the real bridge pattern example using composition`() {
    val movie = TitaniumBridgePattern.Movie(
      classification = "Classification",
      runtime = "Runtime",
      title = "Title",
      year = "Year"
    )

    val book = TitaniumBridgePattern.Book(
      "BOOK_ISBN",
      "Book Title",
      "Author Name"
    )

    val moviePrinter = TitaniumBridgePattern.MoviePrinter(movie)
    val bookPrinter = TitaniumBridgePattern.BookPrinter(book)
    val htmlFormatter = TitaniumBridgePattern.HtmlFormatter()
    val printFormatter = TitaniumBridgePattern.PrintFormatter()

    val expectedMovieHTMLPrint =
      "<table><th>Classification</th><th>Classification</th><tr><td>Title</td><td>Title</td></tr><tr><td>Year</td><td>Year</td></tr><tr><td>Runtime</td><td>Runtime</td></tr></table>"
    val expectedMoviePrint = "Classification\nTitle:Title\nYear:Year\nRuntime:Runtime\n"
    assertEquals(expectedMovieHTMLPrint, moviePrinter.print(htmlFormatter))
    assertEquals(expectedMoviePrint, moviePrinter.print(printFormatter))

    val expectedBookHTMLPrint =
      "<table><th>Classification</th><th>Book Title</th><tr><td>ISBN</td><td>BOOK_ISBN</td></tr><tr><td>Author</td><td>Author Name</td></tr></table>"
    val expectedBookPrint = "Book Title\nISBN:BOOK_ISBN\nAuthor:Author Name\n"
    assertEquals(expectedBookHTMLPrint, bookPrinter.print(htmlFormatter))
    assertEquals(expectedBookPrint, bookPrinter.print(printFormatter))
  }

  @Test
  fun `test of bridge pattern using composition`() {
    val blueColorB = TitaniumBridgePatternB.BlueColor()
    val redColorB = TitaniumBridgePatternB.RedColor()
    val greenColorB = TitaniumBridgePatternB.GreenColor()

    blueColorB.shouldBeInstanceOf(TitaniumBridgePatternB.BlueColor::class.java)
    redColorB.shouldBeInstanceOf(TitaniumBridgePatternB.RedColor::class.java)
    greenColorB.shouldBeInstanceOf(TitaniumBridgePatternB.GreenColor::class.java)

    val squareB = TitaniumBridgePatternB.Square(blueColorB)
    val circleB = TitaniumBridgePatternB.Circle(redColorB)

    squareB.shouldBeInstanceOf(TitaniumBridgePatternB.Square::class.java)
    circleB.shouldBeInstanceOf(TitaniumBridgePatternB.Circle::class.java)

    val greenCircleB = TitaniumBridgePatternB.Circle(greenColorB)
    val greenSquareB = TitaniumBridgePatternB.Square(greenColorB)

    greenCircleB.shouldBeInstanceOf(TitaniumBridgePatternB.Circle::class.java)
    greenSquareB.shouldBeInstanceOf(TitaniumBridgePatternB.Square::class.java)

    assertEquals("Applying Blue Color to a BlueColor", squareB.applyColor())
    assertEquals("Applying Red Color to a RedColor", circleB.applyColor())
    assertEquals("Applying Green Color to a GreenColor", greenCircleB.applyColor())
    assertEquals("Applying Green Color to a GreenColor", greenSquareB.applyColor())
  }

  @Test
  fun `test of non bridge pattern using inheritance only`() {
    val circleA = TitaniumBridgePatternA.BlueCircle()
    val squareA = TitaniumBridgePatternA.RedSquare()
    val greenSquareA = TitaniumBridgePatternA.GreenSquare()

    circleA.shouldBeInstanceOf(TitaniumBridgePatternA.BlueCircle::class.java)
    squareA.shouldBeInstanceOf(TitaniumBridgePatternA.RedSquare::class.java)
    greenSquareA.shouldBeInstanceOf(TitaniumBridgePatternA.GreenSquare::class.java)

    assertEquals("Applying Blue Color to a BlueCircle", circleA.applyColor())
    assertEquals("Applying Red Color to a RedSquare", squareA.applyColor())
    assertEquals("Applying Green Color to a GreenSquare", greenSquareA.applyColor())
  }
}
