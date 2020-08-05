package com.example.baselib.mockk

class Arithmetic(
    private val arithmeticImpl: ArithmeticImpl,
    private val printer: Printer
) {

    fun add(a: Int, b: Int): Int {
        printer.printAddMessage()
        return arithmeticImpl.add(a, b)
    }

    fun divide(a: Int, b: Int) : Int {
        printer.printDivideMessage()
        return arithmeticImpl.divide(a, b)
    }



}