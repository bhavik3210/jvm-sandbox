package com.kotlin.dojo.designPatterns.creational

import com.kotlin.dojo.ext.getTitleFormat

class TitaniumPrototypePattern {

  class Registry {
    private val items = hashMapOf<String, Item>()

    init {
      loadItems()
    }

    fun createItem(type: String): Item? {
      var item: Item? = null

      try {
        item = (items[type]?.clone()) as Item
      } catch (e: CloneNotSupportedException) {
        e.printStackTrace()
      }

      return item
    }

    private fun loadItems() {
      val movie = Movie()
      movie.title = "Movie Title"
      movie.price = 24.99
      movie.runtime = "2 hours"
      items["Movie"] = movie

      val book = Book()
      book.numberOfPages = 2
      book.price = 19.99
      book.title = "Book Title"
      items["Book"] = book
    }
  }

  abstract class Item : Cloneable {
    var title: String? = null
    var price: Double? = null
    var url: String? = null

    public override fun clone(): Any {
      return super.clone()
    }
  }

  class Book : Item() {
    var numberOfPages: Int? = null
  }

  class Movie : Item() {
    var runtime: String? = null
  }
}

fun main() {
  val registry = TitaniumPrototypePattern.Registry()
  val movie = registry.createItem("Movie") as TitaniumPrototypePattern.Movie
  movie.title = "Creational Patterns in Java"

  println(movie)
  println(movie.runtime)
  println(movie.title)
  println(movie.url)

  println(" ".getTitleFormat())

  val anotherMovie = registry.createItem("Movie") as TitaniumPrototypePattern.Movie
  anotherMovie.title = "Gang of Four"

  println(anotherMovie)
  println(anotherMovie.runtime)
  println(anotherMovie.title)
  println(anotherMovie.url)
}
