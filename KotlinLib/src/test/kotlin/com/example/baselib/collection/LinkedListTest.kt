package com.example.baselib.collection

import org.junit.Test
import java.util.*

class LinkedListTest {


    @Test
    fun test() {
        val linkedList1 = LinkedList<String>()
        linkedList1.add("a")
        linkedList1.add("b")
        linkedList1.add("c")
        linkedList1.add("d")

        val linkedList2 = LinkedList<String>()
        linkedList2.add("e")
        linkedList2.add("f")
        linkedList2.add("g")
        linkedList2.add("h")
        linkedList2.add("i")

        val it1 = linkedList1.listIterator()
        var it2 = linkedList2.listIterator()

        while (it2.hasNext()) {
            if (it1.hasNext()) it1.next()
            it1.add(it2.next())
        }
        println(linkedList1)

        //remove
        it2 = linkedList2.listIterator()
        while (it2.hasNext()) {
            it2.remove()
//            it2.next()
//            if (it2.hasNext()) {
//                it2.next()
//                it2.remove()
//            }
        }
        println(linkedList2)

        linkedList1.removeAll(linkedList2)
        println(linkedList1)
    }
}