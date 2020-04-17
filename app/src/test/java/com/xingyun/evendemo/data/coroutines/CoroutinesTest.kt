package com.xingyun.evendemo.data.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.junit.Test

class CoroutinesTest {

    @Test
    fun test() {
        GlobalScope.launch {
            delay(100)
            println("World!")
        }
        println("Hello")
        Thread.sleep(2000L)
    }


}