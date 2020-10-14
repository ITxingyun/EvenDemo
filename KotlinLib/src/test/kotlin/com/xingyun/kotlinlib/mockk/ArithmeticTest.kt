package com.xingyun.kotlinlib.mockk

import io.mockk.*
import io.mockk.impl.annotations.MockK
import org.junit.After
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class ArithmeticTest {
    @MockK
    lateinit var arithmeticImpl: ArithmeticImpl

    private val printer: Printer = mockk()

    private lateinit var arithmetic: Arithmetic

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        arithmetic = Arithmetic(arithmeticImpl, printer)
    }

    /**
     * demo for Capturing
     * CapturingSlot<T>
     */
    @Test
    fun test_divide_01() {
        val slot = slot<Int>()
        every { printer.printDivideMessage() } just Runs
        every { arithmeticImpl.divide(capture(slot), any()) } returns 22
        arithmetic.divide(2, 2)
        assertEquals(2, slot.captured)
        verify { arithmeticImpl.divide(2, 2) }
    }

    /**
     * demo for Capturing
     * MutableList<T>
     */
    @Test
    fun test_divide_02() {
        val list = mutableListOf<Int>()
        every { printer.printDivideMessage() } just Runs
        every { arithmeticImpl.divide(capture(list), any()) } returns 22
        arithmetic.divide(2, 2)
        arithmetic.divide(3, 3)
        assertEquals(2, list[0])
        verify { arithmeticImpl.divide(2, 2) }
    }


    @Test
    fun test_add_01() {
        val printer: Printer = mockk(relaxed = true)
        val arithmetic = Arithmetic(arithmeticImpl, printer)
        every { arithmeticImpl.add(any(), any()) } returns 10
        assertEquals(10, arithmetic.add(1, 2))
        verifySequence {
            printer.printAddMessage()
            arithmeticImpl.add(1, 2)
        }
    }

    @Test
    fun test_add_02() {
        val printer: Printer = mockk(relaxUnitFun = true)
        val spy = spyk(ArithmeticImpl(), recordPrivateCalls = true)
        val arithmetic = Arithmetic(spy, printer)

        every { spy["magnify"](1) } returns 10

        assertEquals(12, arithmetic.add(1, 2))
        verifySequence {
            printer.printAddMessage()
            spy.add(1, 2)
            spy["magnify"](1)
        }
    }

    @After
    fun afterTests() {
        confirmVerified()
        unmockkAll()
        // or unmockkObject(MockObj)
    }
}