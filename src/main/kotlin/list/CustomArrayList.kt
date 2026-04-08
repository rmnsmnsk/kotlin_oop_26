package org.example.list

open class CustomArrayList(size: Int = 10): CustomList {

    var inner = IntArray(size)
    var current_size: Int = 0
    override var size: Int = size

    override operator fun get(index: Int): Int{
        return inner[index]
    }
    override operator fun set(index: Int, value: Int){
        inner[index] = value
    }

    override fun add(value: Int) {
        if (current_size >= size) {
            resize(current_size * 2)
        }
        inner[current_size] = value
        current_size++
    }

    fun resize(newSize: Int) {
        val newlist = IntArray(newSize)
        for (i in 0 until current_size){
            newlist[i] = this.inner[i]
        }
        inner = newlist
        size = newSize
    }

    override fun addFirst(element: Int){
        if (current_size >= size){
            resize (current_size * 2)
        }
        var newlist = IntArray(size)
        for (i in 0 until current_size){
            newlist[i + 1] = inner[i]
        }
        newlist[0] = element
        inner = newlist
        current_size++
    }

    override fun remove(element: Int): Boolean {
        var found = false
        var newIndex = 0
        val newlist = IntArray(size)
        for (i in 0 until current_size) {
            if (inner[i] != element) {
                newlist[newIndex] = inner[i]
                newIndex++
            } else {
                found = true
            }
        }
        if (found) {
            inner = newlist
            current_size = newIndex
            return true
        }
        return false
    }
    override fun indexOf(element: Int): Int{
        var index = 0
        for (i in 0 until current_size){
            if (inner[i] == element){
                return index
            }
            index++
        }
        return -1
    }

    override fun iterator(): Iterator<Int> {
        return object : Iterator<Int> {
            var index = 0

            override fun hasNext(): Boolean {
                return index < current_size
            }
            override fun next(): Int {
                return inner[index++]
            }
        }
    }

    companion object {
        fun customArrayListOf(vararg items: Int) =
            items.fold(CustomArrayList(items.size)) { list, item ->
                list.also { it.add(item) }
            }
    }
}