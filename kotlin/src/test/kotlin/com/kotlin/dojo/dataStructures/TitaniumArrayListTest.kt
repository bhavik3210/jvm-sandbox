package com.kotlin.dojo.dataStructures

import kotlin.test.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class TitaniumArrayListTest {

  @Test
  fun `test addItem`() {
    val titaniumArrayList = TitaniumArrayList<Int>()
    titaniumArrayList.addItem(1)
    titaniumArrayList.addItem(2)
    titaniumArrayList.addItem(3)
    titaniumArrayList.addItem(4)
    titaniumArrayList.addItem(5)

    val actualResult = titaniumArrayList.getAllData()
    val expectedResult = "12345"
    assertEquals(expectedResult, actualResult)
    assertEquals(expectedResult.length, titaniumArrayList.size)
  }

  @Test
  fun `test remove item`() {
    val titaniumArrayList = TitaniumArrayList<Int>()
    titaniumArrayList.addItem(1)
    titaniumArrayList.addItem(2)
    titaniumArrayList.addItem(3)
    titaniumArrayList.addItem(4)
    titaniumArrayList.addItem(5)
    titaniumArrayList.removeItem(2)

    val actualResult = titaniumArrayList.getAllData()
    val expectedResult = "1345"
    assertEquals(expectedResult, actualResult)
    assertEquals(expectedResult.length, titaniumArrayList.size)
  }

  @Test
  fun `test shift elements to left of the removed indexed item`() {
    val titaniumArrayList = TitaniumArrayList<Int>()
    titaniumArrayList.addItem(1)
    titaniumArrayList.addItem(2)
    titaniumArrayList.addItem(3)
    titaniumArrayList.addItem(4)
    titaniumArrayList.addItem(5)

    titaniumArrayList.shiftElementsToLeft(2)
    val actualResult = titaniumArrayList.getAllData()
    val expectedResult = "1245"
    assertEquals(expectedResult, actualResult)
    assertEquals(expectedResult.length, titaniumArrayList.size)

    assertThrows<IndexOutOfBoundsException> { titaniumArrayList.shiftElementsToLeft(5) }
  }

  @Test
  fun `test add item at specific index`() {
    val titaniumArrayList = TitaniumArrayList<Int>()
    titaniumArrayList.addItem(1)
    titaniumArrayList.addItem(2)
    titaniumArrayList.addItem(3)
    titaniumArrayList.addItem(4)
    titaniumArrayList.addItem(5)

    titaniumArrayList.addItemAt(13, 2)

    val actualResult = titaniumArrayList.getAllData()
    val expectedResult = "1213345"

    assertEquals(expectedResult, actualResult)
    assertEquals(6, titaniumArrayList.size)

    assertThrows<IndexOutOfBoundsException> { titaniumArrayList.shiftElementsToRight(6) }
  }
}
