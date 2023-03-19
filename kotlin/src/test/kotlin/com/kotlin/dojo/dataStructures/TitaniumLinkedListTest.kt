package com.kotlin.dojo.dataStructures

import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class TitaniumLinkedListTest {

  @Test
  fun `test addLast`() {
    val myList = TitaniumLinkedList<Int>()
    myList.addLast(1)
    myList.addLast(2)
    myList.addLast(3)
    myList.addLast(4)
    myList.addLast(5)

    val actualResult = myList.getAllValuesFromHeadToTail()
    val expectedResult = "[1][2][3][4][5]"

    assertEquals(expectedResult, actualResult)
  }

  @Test
  fun `test addFirst`() {
    val myList = TitaniumLinkedList<Int>()
    myList.addLast(1)
    myList.addLast(2)
    myList.addLast(3)
    myList.addLast(4)
    myList.addLast(5)
    myList.addFirst(0)

    val actualResult = myList.getAllValuesFromHeadToTail()
    val expectedResult = "[0][1][2][3][4][5]"

    assertEquals(expectedResult, actualResult)
  }

  @Test
  fun `test removeFirst`() {
    val myList = TitaniumLinkedList<Int>()
    myList.addLast(1)
    myList.addLast(2)
    myList.addLast(3)
    myList.addLast(4)
    myList.addLast(5)
    myList.removeFirst()

    val actualResult = myList.getAllValuesFromHeadToTail()
    val expectedResult = "[2][3][4][5]"

    assertEquals(expectedResult, actualResult)
  }

  @Test
  fun `test removeLast`() {
    val myList = TitaniumLinkedList<Int>()
    myList.addLast(1)
    myList.addLast(2)
    myList.addLast(3)
    myList.addLast(4)
    myList.addLast(5)
    myList.removeLast()

    val actualResult = myList.getAllValuesFromHeadToTail()
    val expectedResult = "[1][2][3][4]"

    assertEquals(expectedResult, actualResult)
  }

  @Test
  fun `test remove specific item in list`() {
    val myList = TitaniumLinkedList<Int>()
    myList.addLast(1)
    myList.addLast(2)
    myList.addLast(3)
    myList.addLast(4)
    myList.addLast(5)
    myList.remove(3)

    val actualResult = myList.getAllValuesFromHeadToTail()
    val expectedResult = "[1][2][4][5]"

    assertEquals(expectedResult, actualResult)
  }

  @Test
  fun `test remove item after of the given item in list`() {
    val myList = TitaniumLinkedList<Int>()
    myList.addLast(1)
    myList.addLast(2)
    myList.addLast(3)
    myList.addLast(4)
    myList.addLast(5)
    myList.removeAfter(3)

    val actualResult = myList.getAllValuesFromHeadToTail()
    val expectedResult = "[1][2][3][5]"

    assertEquals(expectedResult, actualResult)
  }

  @Test
  fun `test all functions together list`() {
    val myList = TitaniumLinkedList<Int>()
    myList.addLast(1)
    myList.addLast(2)
    myList.addLast(3)
    myList.addLast(4)
    myList.addLast(5)

    myList.addFirst(0)

    myList.removeFirst()
    myList.removeLast()

    myList.remove(3)

    myList.removeAfter(1)

    val actualResult = myList.getAllValuesFromHeadToTail()
    val expectedResult = "[1][4]"

    assertEquals(expectedResult, actualResult)
  }
}
