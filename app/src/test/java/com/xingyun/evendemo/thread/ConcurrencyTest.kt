package com.xingyun.evendemo.thread

import org.junit.Test
import java.util.concurrent.locks.ReentrantLock

class ConcurrencyTest {

    @Test
    fun test_ReentrantLock() {
        val reentrantLockBand = ReentrantLockBand()
        Thread(Runnable {
            reentrantLockBand.out("子线程")
        }).start()
        reentrantLockBand.out("主线程")
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