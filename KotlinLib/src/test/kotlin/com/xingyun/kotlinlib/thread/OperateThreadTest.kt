package com.xingyun.kotlinlib.thread

import org.junit.Test
import java.lang.Thread.sleep

class OperateThreadTest {


    @Test
    fun test_sleep() {
        Thread(Runnable {
            for (i in 0 until 5) {
                println("count = $i")
                sleep(1000)
            }
        }).start()

        sleep(1000)
        println("主线程执行完！")
    }


    /**
     *让正在运行的线程回到就绪状态，并不会阻塞线程。
     * 要注意的是它只会让步给比它优先级高的或者和它优先级相同并处在就绪状态的线程。
     */
    @Test
    fun test_yield() {
        println("开始执行:")
        val case1 = YieldCase().apply {
            name = "线程1"
            priority = 10
        }
        val case2 = YieldCase().apply { name = "线程2" }
        val case3 = YieldCase().apply {
            name = "线程3"
            priority = 1
        }
        case1.start()
        case2.start()
        case3.start()
    }

    @Test
    fun test_priority() {
        println("开始执行:")
        val case1 = PriorityCase().apply {
            name = "线程1"
            priority = 10
        }
        val case2 = PriorityCase().apply { name = "线程2" }
        val case3 = PriorityCase().apply {
            name = "线程3"
            priority = 1
        }
        case1.start()
        case2.start()
        case3.start()
    }

    /**
     * 将调用该方法的对象所表示的线程标记一个停止标记，并不是真的停止该线程。
     * 只是把运行的机会先让给其他线程
     */
    @Test
    fun test_interrupt() {
        println("开始执行:")
        val case1 = InterruptCase().apply { name = "线程1" }
        case1.start()
    }


    /**
     * 这个方法需要两个线程，在一个线程A里，另一个线程B调用了join之后，
     * 线程A会陷入阻塞状态，直到线程B执行完之后，线程A才会恢复就绪状态继续执行。
     */
    @Test
    fun test_join() {
        println("开始执行:")
        for (i in 0 until 10) {
            val case1 = MyThread().apply { name = "线程$i" }
            case1.start()
            case1.join()
            println("case$i 开始运行")
        }
    }

    @Test
    fun test_daemonThread() {
        println("开始执行:")
        val case1 = Thread(DaemonRunner(),"线程1").apply { isDaemon = true }
        case1.start()
    }




}