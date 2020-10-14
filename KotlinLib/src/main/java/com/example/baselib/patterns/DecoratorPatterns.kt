package com.example.baselib.patterns

/**
 * 装饰模式
 */
class DecoratorPatterns(private val component: Component): Component() {

    override fun operate() {
        component.operate()
    }
}

abstract class Component {
    abstract fun operate()
}

class ConcreteComponentA: Component() {

    override fun operate() {
        println("ConcreteComponentA")
    }
}

class ConcreteComponentB: Component() {

    override fun operate() {
        println("ConcreteComponentB")
    }
}


fun main() {
    val componentA = DecoratorPatterns(ConcreteComponentA())
    componentA.operate()

    val componentB = DecoratorPatterns(ConcreteComponentB())
    componentB.operate()
}