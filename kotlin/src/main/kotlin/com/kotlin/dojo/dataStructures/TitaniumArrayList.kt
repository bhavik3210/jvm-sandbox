package com.kotlin.dojo.dataStructures

/**
 * Basic implementation of ArrayList
 */
class TitaniumArrayList<T> {

  private var data = arrayOfNulls<Any?>(1) as Array<T?>
  var size = 0

  fun addItem(item: T) {
    if (size < data.size) {
      data[size] = item
      size++
    } else {
      doubleTheSize()
      data[size] = item
      size++
    }
  }

  fun removeItem(item: T) {
    shiftElementsToLeft(data.indexOf(item))
  }

  fun addItemAt(item: T, index: Int) {
    if (index < data.size) {
      shiftElementsToRight(index)
      data[index] = item
    } else {
      addItem(item)
    }
  }

  fun removeItemAt(index: Int) = shiftElementsToLeft(index)

  fun shiftElementsToLeft(index: Int) {
    if (index < size) {
      var indexOfItemToRemove = index
      while (indexOfItemToRemove < size) {
        data[indexOfItemToRemove] = data[indexOfItemToRemove + 1]
        indexOfItemToRemove++
      }
      data[size - 1] = null
      size--
    } else {
      throw IndexOutOfBoundsException("Index is higher than size of the list.")
    }
  }

  fun shiftElementsToRight(index: Int) {
    if (index < size) {
      data[size - 1]?.let {
        addItem(it)
      }

      var indexOfLastItem = size - 1
      while (index < indexOfLastItem) {
        data[indexOfLastItem] = data[indexOfLastItem - 1]
        indexOfLastItem--
      }
    } else {
      throw IndexOutOfBoundsException("Index is higher than size of the list.")
    }
  }

  private fun doubleTheSize() {
    val newData = arrayOfNulls<Any?>(data.size * 2) as Array<T?>
    data.forEachIndexed { index, value ->
      value?.let {
        newData[index] = value
      }
    }
    data = newData
  }

  fun getAllData(): String {
    var result = ""
    data.forEach {
      it?.let {
        result += "$it"
      }
    }
    return result
  }

  fun getAllDataWithSpace(): String {
    var result = ""
    data.forEach {
      it?.let {
        result += "$it "
      }
    }
    return result
  }
}
