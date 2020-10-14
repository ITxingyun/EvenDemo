package com.xingyun.kotlinlib.mockk

class Util {

    fun ok() {
        UtilJava.ok()
        UtilKotlin.ok()
    }


    fun manageList(list: List<Int>) : List<Int> {
        return list.filter { it > 3 }
    }
}