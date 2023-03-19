package com.kotlin.dojo.designPatterns.creational

class TitaniumBuilderPattern constructor(builder: Builder) {
  private var bread: String? = null
  private var condiments: String? = null
  private var dressing: String? = null
  private var meat: String? = null

  init {
    bread = builder.bread
    condiments = builder.condiments
    dressing = builder.dressing
    meat = builder.meat
  }

  companion object {
    class Builder {
      internal var bread: String? = null
      internal var condiments: String? = null
      internal var dressing: String? = null
      internal var meat: String? = null

      fun bread(bread: String): Builder {
        this.bread = bread
        return this
      }

      fun condiments(condiments: String): Builder {
        this.condiments = condiments
        return this
      }

      fun dressing(dressing: String): Builder {
        this.dressing = dressing
        return this
      }

      fun meat(meat: String): Builder {
        this.meat = meat
        return this
      }

      fun build(): TitaniumBuilderPattern {
        return TitaniumBuilderPattern(this)
      }
    }
  }

  override fun toString(): String {
    val stringBuilder = StringBuilder()

    bread?.let {
      stringBuilder.append(it)
      stringBuilder.append(" ")
    }

    condiments?.let {
      stringBuilder.append(it)
      stringBuilder.append(" ")
    }

    dressing?.let {
      stringBuilder.append(it)
      stringBuilder.append(" ")
    }

    meat?.let {
      stringBuilder.append(it)
    }

    return stringBuilder.toString()
  }
}

fun main() {
  val hello = TitaniumBuilderPattern.Companion.Builder()
    .bread("BREAD")
    .meat("MEAT")

  val helloB = hello
    .condiments("CONDIMENTS")
    .dressing("DRESSING")

  println(hello.hashCode())
  println(helloB.hashCode())
}
