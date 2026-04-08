package org.example.stack

import org.example.list.CustomArrayList
import java.util.NoSuchElementException

class ArrayListStack : Stack {
    private val list = CustomArrayList()

    override val isEmpty: Boolean
        get(){
            return list.size == 0
        }

    override fun push(value: Int) {
        list.add(value)
    }

    override fun pop(): Int {
        if (isEmpty) {
            throw NoSuchElementException()
        }
        val element = list[list.size - 1]
        list.remove(element)
        return element
    }

    override fun peek(): Int {
        if (isEmpty) {
            throw NoSuchElementException()
        }
        return list[list.size - 1]
    }

    override val size: Int
        get() = list.size

    override fun add(element: Int) {
        list.add(element)
    }

    override fun addFirst(element: Int) {
        list.addFirst(element)
    }

    override fun remove(element: Int): Boolean {
        return list.remove(element)
    }

    override fun indexOf(element: Int): Int {
        return list.indexOf(element)
    }

    override fun get(index: Int): Int {
        return list[index]
    }

    override fun set(index: Int, value: Int) {
        list[index] = value
    }

    override fun iterator(): Iterator<Int> {
        return list.iterator()
    }
}