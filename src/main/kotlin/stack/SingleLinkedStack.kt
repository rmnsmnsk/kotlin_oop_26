package org.example.stack

import org.example.list.SingleLinkedList

class SingleLinkedStack : SingleLinkedList() {

    val isepmty: Boolean
        get(){
            return size == 0
        }

    fun push(value: Int){
        addFirst(value)

    }

    fun pop(): Int{
        if (isepmty){
            throw NoSuchElementException()
        }
        val el = get(0)
        remove(el)
        return el
    }

    fun peek(): Int{
        if (isepmty){
            throw NoSuchElementException()
        }
        return get(0)
    }
}