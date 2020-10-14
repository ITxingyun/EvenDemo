package com.xingyun.kotlinlib.thread

import org.junit.Test
import java.util.concurrent.Executors
import java.util.concurrent.Future

class ExecutorTest {


    @Test
    fun test_newCachedThreadPool() {
        val exec = Executors.newCachedThreadPool()
        for (i in 0 until 5) {
            exec.execute(YieldCase())
        }
        exec.shutdown()
        println("shutdown!!!")
    }

    @Test
    fun test_newFixedThreadPool() {
        val exec = Executors.newFixedThreadPool(5)
        for (i in 0 until 5) {
            exec.execute(YieldCase())
        }
        exec.shutdown()
        println("shutdown!!!")
    }


    @Test
    fun test_callable() {
        val exec = Executors.newCachedThreadPool()
        val results = mutableListOf<Future<String>>()
        for (i in 0 until 10) {
            results.add(exec.submit(MyCallback(i)))
        }

        results.forEach {
            println(it.get())
        }
    }


}