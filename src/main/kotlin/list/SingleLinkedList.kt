package org.example.list

class SingleLinkedList : CustomList {
    private var head: Node? = null
    private var currentSize: Int = 0

    override val size: Int
        get() = currentSize

    private class Node(var data: Int) {
        var next: Node? = null
    }

    override fun add(element: Int) {
        val newNode = Node(element)
        if (head == null) {
            head = newNode
        } else {
            var current = head
            while (current?.next != null) {
                current = current.next
            }
            current?.next = newNode
        }
        currentSize++
    }

    override fun addFirst(element: Int) {
        val newNode = Node(element)
        newNode.next = head
        head = newNode
        currentSize++
    }

    override fun get(index: Int): Int {
        if (index < 0 || index >= currentSize) {
            throw IndexOutOfBoundsException("Index: $index, Size: $currentSize")
        }
        var current = head
        for (i in 0 until index) {
            current = current?.next
        }
        return current?.data ?: throw IndexOutOfBoundsException()
    }

    override fun set(index: Int, value: Int) {
        if (index < 0 || index >= currentSize) {
            throw IndexOutOfBoundsException("Index: $index, Size: $currentSize")
        }
        var current = head
        for (i in 0 until index) {
            current = current?.next
        }
        if (current != null) {
            current.data = value
        } else {
            throw IndexOutOfBoundsException()
        }
    }

    override fun remove(element: Int): Boolean {
        if (head == null) return false

        if (head?.data == element) {
            head = head?.next
            currentSize--
            return true
        }

        var current = head
        while (current?.next != null) {
            if (current.next?.data == element) {
                current.next = current.next?.next
                currentSize--
                return true
            }
            current = current.next
        }
        return false
    }

    override fun indexOf(element: Int): Int {
        var current = head
        var index = 0
        while (current != null) {
            if (current.data == element) {
                return index
            }
            current = current.next
            index++
        }
        return -1
    }

    override fun iterator(): Iterator<Int> {
        return object : Iterator<Int> {
            private var current = head

            override fun hasNext(): Boolean = current != null

            override fun next(): Int {
                val currentValue = current
                if (currentValue == null) throw NoSuchElementException()
                val data = currentValue.data
                current = currentValue.next
                return data
            }
        }
    }

    companion object {
        fun singleLinkedListOf(vararg items: Int): SingleLinkedList {
            val list = SingleLinkedList()
            items.forEach { list.add(it) }
            return list
        }
    }
}