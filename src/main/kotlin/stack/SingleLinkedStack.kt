package org.example.stack

import org.example.list.SingleLinkedList

class SingleLinkedStack : SingleLinkedList(), Stack {

    override val isEmpty: Boolean
        get(){
            return size == 0
        }

    override fun push(value: Int){
        addFirst(value)

    }

    override fun pop(): Int{
        if (isEmpty){
            throw NoSuchElementException()
        }
        val el = get(0)
        remove(el)
        return el
    }

    override fun peek(): Int {
        if (isEmpty) {
            throw NoSuchElementException()
        }
        return get(0)
    }
}