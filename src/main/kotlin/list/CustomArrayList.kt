package org.example.list

class CustomArrayList(initialCapacity: Int = 10) : CustomList {
    private var capacity = initialCapacity
    private var inner = IntArray(capacity)
    private var currentSize = 0

    override val size: Int
        get() = currentSize

    override fun add(element: Int) {
        if (currentSize >= capacity) {
            capacity = capacity * 2
            inner = inner.copyOf(capacity)
        }
        inner[currentSize] = element
        currentSize++
    }

    override fun addFirst(element: Int) {
        if (currentSize >= capacity) {
            capacity = capacity * 2
            inner = inner.copyOf(capacity)
        }
        for (i in currentSize downTo 1) {
            inner[i] = inner[i - 1]
        }
        inner[0] = element
        currentSize++
    }

    override fun remove(element: Int): Boolean {
        val index = indexOf(element)
        if (index < 0) return false

        for (i in index until currentSize - 1) {
            inner[i] = inner[i + 1]
        }
        currentSize--
        return true
    }

    override fun indexOf(element: Int): Int {
        for (i in 0 until currentSize) {
            if (inner[i] == element) return i
        }
        return -1
    }

    override operator fun get(index: Int): Int {
        if (index < 0 || index >= currentSize) {
            throw IndexOutOfBoundsException("Index: $index, Size: $currentSize")
        }
        return inner[index]
    }

    override operator fun set(index: Int, value: Int) {
        if (index < 0 || index >= currentSize) {
            throw IndexOutOfBoundsException("Index: $index, Size: $currentSize")
        }
        inner[index] = value
    }

    override fun iterator(): Iterator<Int> {
        return object : Iterator<Int> {
            private var index = 0

            override fun hasNext(): Boolean = index < currentSize

            override fun next(): Int {
                if (!hasNext()) throw NoSuchElementException()
                return inner[index++]
            }
        }
    }

    companion object {
        fun customArrayListOf(vararg items: Int): CustomArrayList {
            val list = CustomArrayList(items.size)
            items.forEach { list.add(it) }
            return list
        }
    }
}