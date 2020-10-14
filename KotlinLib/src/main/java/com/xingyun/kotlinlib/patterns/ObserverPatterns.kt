package com.xingyun.kotlinlib.patterns

/**
 * 观察者模式定义了一系列对象之间的一对多关系。当一个对象改变状态，
 * 其他依赖者都会收到通知
 */
class ObserverPatterns {

    fun main(string: String) {
        val subject = RealSubject()
        subject.registryObserver(CatObserver())
        subject.registryObserver(DogObserver())
        subject.notifyObserver("主人不要你了")
    }


    interface Observer {
        fun update(msg: String)
    }

    interface Subject {
        fun registryObserver(observer: Observer)

        fun removeObserver(observer: Observer)

        fun notifyObserver(msg: String)
    }

    class RealSubject: Subject {
        private val observers = mutableListOf<Observer>()

        override fun registryObserver(observer: Observer) {
            observers.add(observer)
        }

        override fun removeObserver(observer: Observer) {
            observers.remove(observer)
        }

        override fun notifyObserver(msg: String) {
            observers.forEach { it.update(msg) }
        }
    }

    class CatObserver: Observer {
        override fun update(msg: String) {
            println("小猫收到信息：$msg")
        }
    }

    class DogObserver: Observer {
        override fun update(msg: String) {
            println("小狗收到信息：$msg")
        }
    }

}