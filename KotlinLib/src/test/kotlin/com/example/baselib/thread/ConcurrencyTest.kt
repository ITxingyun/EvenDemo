package com.example.baselib.thread

import org.junit.Test
import java.util.concurrent.locks.ReentrantLock
import java.util.concurrent.locks.ReentrantReadWriteLock

class ConcurrencyTest {

    @Test
    fun test_ReentrantLock() {
        val reentrantLockBand = ReentrantLockBand()
        Thread(Runnable {
            reentrantLockBand.out("子线程")
        }).start()
        reentrantLockBand.out("主线程")
    }

    @Test
    fun test_synchronized() {
        Thread(Runnable {
//            syn1()
        }).start()

        Thread(Runnable {
//            syn2()
        }).start()
    }

//    @Synchronized
//    fun syn1() {
//        println("进入syn1")
//        notify()
//        for (i in 0 until 5) {
//            println("count = $i")
//            if (i == 3) {
//                wait()
//            }
//        }
//        println("退出syn1")
//    }
//
//    @Synchronized
//    fun syn2() {
//        println("进入syn2")
//        notify()
//        for (i in 0 until 5) {
//            println("count = $i")
//            if (i == 3) {
//                wait()
//            }
//        }
//        println("退出syn2")
//    }

    @Test
    fun test_ReentrantReadWriteLock() {
        val reentrantReadWriteLock = ReentrantReadWriteLock()
        val readLock = reentrantReadWriteLock.readLock()
        val writeLock = reentrantReadWriteLock.writeLock()
    }

}




class ReentrantLockBand {
    private val reentrantLock = ReentrantLock()

    fun out(out: String) {
        reentrantLock.lock()
        try {
            for (i in 0 until 5) {
                println("$out ： count = $i")
            }
        } finally {
            reentrantLock.unlock()
        }
    }
}