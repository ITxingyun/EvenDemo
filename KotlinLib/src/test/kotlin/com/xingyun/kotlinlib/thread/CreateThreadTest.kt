package com.xingyun.kotlinlib.thread

import org.junit.Test
import java.util.concurrent.FutureTask

/***
 * 多线程demo
 */
class CreateThreadTest {

    /**
     * 创建线程的两种方法
     */
    @Test
    fun useThread() { //第一种
        val thread1 = MyThread()
        thread1.start()
        //第二种
        val thread2 = Thread(MyRunnable())
        thread2.start()

        //第三种
        val callable = MyCallback(110)
        val futureTask = FutureTask<String>(callable)
        Thread(futureTask).start()
        try {
            println(futureTask.get())
        } catch (e: InterruptedException) {
            e.printStackTrace()
            return
        }
    }

}