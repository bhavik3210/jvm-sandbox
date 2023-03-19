package com.kotlin.dojo.dataStructures

class TitaniumLinkedList<T> {
  private var head: Node<T>? = null

  fun addFirst(item: T) {
    val newNodeItem = Node(item, null)
    newNodeItem.next = head
    head = newNodeItem
  }

  fun removeFirst() {
    val newHead = head?.next
    this.head = newHead
  }

  fun removeAfter(item: T) {
    var current = head

    while (current?.data != item) {
      current = current?.next
    }

    val itemToRemove = current?.next
    val itemAfterToRemove = itemToRemove?.next

    current?.next = itemAfterToRemove
  }

  fun removeLast() {
    var current = head
    var beforeCurrent = current

    while (current?.next != null) {
      beforeCurrent = current
      current = current.next
    }

    beforeCurrent?.next = null
  }

  fun remove(item: T) {
    var current = head
    var beforeCurrent = current

    while (current?.data != item) {
      beforeCurrent = current
      current = current?.next
    }

    beforeCurrent?.next = current?.next
  }

  fun addLast(item: T) {
    val newNodeItem = Node(item, null)

    var current = head
    while (current?.next != null) {
      current = current.next
    }

    if (current == null) head = newNodeItem
    else current.next = newNodeItem
  }

  fun getAllValuesFromHeadToTail(): String {
    var result = ""
    var current = head
    while (current != null) {
      result += current.printData()
      current = current.next
    }
    return result
  }
}

data class Node<T>(val data: T, var next: Node<T>? = null) {
  fun printData() = "[$data]"
}
