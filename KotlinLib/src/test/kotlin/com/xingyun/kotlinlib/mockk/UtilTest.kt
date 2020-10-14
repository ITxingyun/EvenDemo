package com.xingyun.kotlinlib.mockk

import io.mockk.every
import io.mockk.mockkStatic
import io.mockk.unmockkStatic
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Test

class UtilTest {

    @Test
    fun ok() {
        val util = Util()
        mockkStatic(UtilJava::class)
        mockkStatic(UtilKotlin::class)
        every { UtilJava.ok() } returns "Joe"
        every { UtilKotlin.ok() } returns "Tsai"

        // When
        util.ok()

        // Then
        verify { UtilJava.ok() }
//        verify { UtilKotlin.ok() }

        assertEquals("Joe", UtilJava.ok())
        assertEquals("Tsai", UtilKotlin.ok())

        unmockkStatic(UtilJava::class)
        unmockkStatic(UtilKotlin::class)
    }


    @Test
    fun test_manageList() {
        val util = Util()
        val list = listOf(1, 2, 5, 3, 11, 9)
        val results = util.manageList(list)
        assertEquals(3, results.size)
//        assertEquals(5, results.first())
//        assertEquals(11, results.last())
    }
}