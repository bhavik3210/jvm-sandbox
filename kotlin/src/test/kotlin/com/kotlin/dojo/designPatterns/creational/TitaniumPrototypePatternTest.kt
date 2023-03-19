package com.kotlin.dojo.designPatterns.creational

import kotlin.test.assertNotEquals
import org.junit.jupiter.api.Test

class TitaniumPrototypePatternTest {

  @Test
  fun `test both instances are different when cloned from the same object in the registry`() {
    val registry = TitaniumPrototypePattern.Registry()
    val movie = registry.createItem("Movie") as TitaniumPrototypePattern.Movie
    movie.title = "Creational Patterns in Java"

    val anotherMovie = registry.createItem("Movie") as TitaniumPrototypePattern.Movie
    anotherMovie.title = "Gang of Four"

    assertNotEquals(movie.hashCode(), anotherMovie.hashCode())
  }
}
