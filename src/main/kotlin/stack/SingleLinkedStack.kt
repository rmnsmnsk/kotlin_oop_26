package org.example.stack

import org.example.list.SingleLinkedList
import java.util.NoSuchElementException

class SingleLinkedStack : Stack {
    private val list = SingleLinkedList()

    override val isEmpty: Boolean
        get() = list.size == 0

    override val size: Int
        get() = list.size

    override fun push(value: Int) {
        list.addFirst(value)
    }

    override fun pop(): Int {
        if (isEmpty) {
            throw NoSuchElementException("Stack is empty")
        }
        val element = list[0]
        list.remove(element)
        return element
    }

    override fun peek(): Int {
        if (isEmpty) {
            throw NoSuchElementException("Stack is empty")
        }
        return list[0]
    }

    override fun add(element: Int) = list.add(element)
    override fun addFirst(element: Int) = list.addFirst(element)
    override fun remove(element: Int): Boolean = list.remove(element)
    override fun indexOf(element: Int): Int = list.indexOf(element)
    override fun get(index: Int): Int = list[index]
    override fun set(index: Int, value: Int) = list.set(index, value)
    override fun iterator(): Iterator<Int> = list.iterator()
}