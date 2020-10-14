package com.xingyun.kotlinlib.mockk

class ArithmeticImpl {

    private fun magnify(a: Int) = a * 2

    fun add(a: Int, b: Int): Int {
        return magnify(a) + b
    }

    fun divide(a: Int, b: Int) = a / b

}