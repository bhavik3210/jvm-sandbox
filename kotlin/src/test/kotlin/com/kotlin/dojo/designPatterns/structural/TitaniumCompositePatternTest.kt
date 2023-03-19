package com.kotlin.dojo.designPatterns.structural

class TitaniumCompositePatternTest {

  abstract class MenuComponent {
    val name: String? = null
    val url: String? = null
    val menuComponents: List<MenuComponent>? = null

    fun add(menuComponent: MenuComponent) {
      throw UnsupportedOperationException("Not Implemented")
    }

    fun remove(menuComponent: MenuComponent) {
      throw UnsupportedOperationException("Not Implemented")
    }

    abstract override fun toString(): String

    fun print(menuComponent: MenuComponent): String {
      val builder = StringBuilder(name)
      builder.append(": ")
      builder.append(url)
      builder.append(": ")
      return builder.toString()
    }
  }
}
