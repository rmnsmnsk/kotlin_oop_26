package org.example.list

open class SingleLinkedList : CustomList {

    private var head: Node? = null
    private var size_: Int = 0

    private class  Node(data: Int){
        var data: Int = data
        var next: Node? = null
    }

    override val size: Int
        get() = size_

    override fun add(element: Int) {
        val new: Node = Node(element)
        if (head == null){
            head = new
            size_ ++
            return
        }
        var current: Node? = head
        while (current?.next != null){
            current = current.next
        }
        current?.next = new
        size_++
    }

    override operator fun set(index: Int, value: Int) {
        var current: Node? = head
        var count: Int = 0
        while (current != null){
            if (count == index){
                current.data = value
                return
            }
            current = current.next
            count++
        }
        throw IndexOutOfBoundsException()
    }

    override fun addFirst(element: Int) {
        val new: Node = Node(element)
        var temp: Node? = head
        head = new
        new.next = temp
        size_++
    }

    override operator fun get(index: Int): Int {
        var current: Node? = head
        var count: Int = 0
        while (current != null){
            if (count == index){
                return current.data
            }
            current = current.next
            count++
        }
        throw IndexOutOfBoundsException()
    }


    override fun indexOf(element: Int): Int {
        var current: Node? = head
        var index: Int = 0
        while (current != null){
            if (current.data == element){
                return index
            }
            current = current.next
            index++
        }
        return -1
    }

    override fun remove(element: Int): Boolean {
        if (head == null){
            return false
        }
        if (head?.data == element){
            head = head?.next
            size_ --
            return true
        }
        var current: Node? = head
        while (current?.next != null){
            if (current.next?.data == element){
                current.next = current.next?.next
                size_ --
                return true
            }
            current = current.next
        }
        return false
    }

    override fun iterator(): Iterator<Int> {
        return object : Iterator<Int> {
            private var current: Node? = head
            override fun hasNext(): Boolean {
                return current != null
            }

            override fun next(): Int {
                if (!hasNext()) throw NoSuchElementException()
                val data = current!!.data
                current = current?.next
                return data
            }
        }
    }

    companion object {
        fun singleLinkedListOf(vararg items: Int) =
            items.fold(SingleLinkedList()) { list, item ->
                list.also{ it.add(item) }
            }
    }
}
