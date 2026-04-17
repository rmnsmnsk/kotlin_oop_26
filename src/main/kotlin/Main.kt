package org.example

import org.example.list.CustomArrayList
import org.example.list.SingleLinkedList
import org.example.stack.ArrayListStack
import org.example.stack.SingleLinkedStack

fun main() {
    val customList = CustomArrayList()
    val arrayStack = ArrayListStack()
    val linkedList = SingleLinkedList()
    val linkedStack = SingleLinkedStack()

    customList.add(1)
    customList.add(2)
    customList.add(3)

    arrayStack.push(2)
    arrayStack.push(4)
    arrayStack.push(10)

    linkedList.add(-2)
    linkedList.add(-3)
    linkedList.add(-10)

    linkedStack.push(321)
    linkedStack.push(0)
    linkedStack.push(12)

    println("CustomArrayList:")
    ListPrinter.printList(customList)

    println("ArrayListStack:")
    ListPrinter.printList(arrayStack)

    println("SingleLinkedList:")
    ListPrinter.printList(linkedList)

    println("SingleLinkedStack:")
    ListPrinter.printList(linkedStack)
}