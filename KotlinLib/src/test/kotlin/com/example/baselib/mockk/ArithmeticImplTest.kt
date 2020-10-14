package com.example.baselib.mockk

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ArithmeticImplTest {

    @Before
    fun setUp() {
    }

    @Test
    fun magnify() {
    }

    @Test
    fun add() {
        val arithmeticImpl = ArithmeticImpl()
        assertEquals(4, arithmeticImpl.add(1, 2))
    }

    @Test
    fun divide() {

    }
}