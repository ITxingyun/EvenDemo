package com.example.baselib.mockk

class Util {

    fun ok() {
        UtilJava.ok()
        UtilKotlin.ok()
    }


    fun manageList(list: List<Int>) : List<Int> {
        return list.filter { it > 3 }
    }
}