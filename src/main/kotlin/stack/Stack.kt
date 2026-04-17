package org.example.stack

import org.example.list.CustomList

interface Stack : CustomList {
    fun push(value: Int)
    fun pop(): Int
    fun peek(): Int
    val isEmpty: Boolean
}