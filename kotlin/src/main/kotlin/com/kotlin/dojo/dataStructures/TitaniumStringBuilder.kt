package com.kotlin.dojo.dataStructures

class TitaniumStringBuilder {
  private val arrayList = TitaniumArrayList<String>()

  fun append(word: String) {
    arrayList.addItem(word)
  }

  override fun toString(): String {
    return arrayList.getAllDataWithSpace().trim()
  }
}
