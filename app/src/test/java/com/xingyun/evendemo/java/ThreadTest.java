package com.xingyun.evendemo.java;

import org.junit.Test;

/***
 * 多线程demo
 */
public class ThreadTest {

    class MyThread extends Thread {
        private int count = 0;
        private String name;

        MyThread() {
        }

        MyThread(String name) {
            super(name);
            this.name = name;
        }

        @Override
        public void run() {
           synchronized (this) {
               System.out.println("create by " + name + " and count = " + count);
               count++;
           }
        }
    }

    class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("create by MyRunnable");
        }
    }

    /**
     * 创建线程的两种方法
     */
    @Test
    public void useThread() {
        //第一种
        MyThread thread1 = new MyThread();
        thread1.start();

        //第二种
        Thread thread2 = new Thread(new MyRunnable());
        thread2.start();
    }

    /**
     *
     */
    @Test
    public void shareDataInMultiThread() {
        MyThread thread = new MyThread("A");
        Thread thread1 = new Thread(thread);
        Thread thread2 = new Thread(thread);
        Thread thread3 = new Thread(thread);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
