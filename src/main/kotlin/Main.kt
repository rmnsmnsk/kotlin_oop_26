package org.example

import org.example.list.SingleLinkedList
import org.example.list.CustomArrayList
import org.example.stack.ArrayListStack
import org.example.stack.SingleLinkedStack

fun main() {
    var a = CustomArrayList()
    var b = ArrayListStack()
    var c = SingleLinkedList()
    var d = SingleLinkedStack()

    a.add(1)
    a.add(2)
    a.add(3)

    b.push(2)
    b.push(4)
    b.push(10)

    c.add(-2)
    c.add(-3)
    c.add(-10)

    d.push(321)
    d.push(0)
    d.push(12)

    println("CustomArrayList:")
    ListPrinter.printList(a)

    println("ArrayListStack:")
    ListPrinter.printList(b)

    println("SingleLinkedList:")
    ListPrinter.printList(c)

    println("SingleLinkedStack:")
    ListPrinter.printList(d)

}