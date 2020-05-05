package com.example.baselib.thread

import java.util.concurrent.Callable

class MyThread : Thread() {

    override fun run() {
        println("create by $name")
    }

}

class MyCallback(private val id: Int) : Callable<String> {

    override fun call(): String {
        Thread.sleep(3000)
        return "Callable: $id"
    }
}

class MyRunnable : Runnable {
    override fun run() {
        println("create by MyRunnable: $id")
        count++
    }

    companion object {
        var count = 0
        val id = count
    }
}

class YieldCase : Thread() {

    override fun run() {
        for (i in 0 until 10) {
            println("create by $name and count = $i")
            yield()
        }
        println("$name: 执行完毕")
    }

}

class InterruptCase : Thread() {

    override fun run() {
        for (i in 0 until 10) {
            println("create by $name and count = $i")
            if (i == 5) {
                interrupt()                     //1.中断失效

                println("执行中断：$isInterrupted")
                //throw InterruptedException()  //2.中断有效
                //return                        //3.中断有效
            }
        }
        println("$name: 执行完毕， 执行中断：$isInterrupted")
    }
}


class PriorityCase : Thread() {

    override fun run() {
        for (i in 0 until 10) {
            println("create by $name and count = $i")
            sleep(1000)
        }
        println("$name: 执行完毕!")
    }
}

class DaemonRunner : Runnable {
    override fun run() {
        try {
            Thread.sleep(500)
            println("执行完毕!")
        } catch (e: InterruptedException) {
            e.printStackTrace()
        } finally {
            println("这里的代码在java虚拟机退出时并不一定会执行哦！")
        }
    }
}

