package com.xingyun.kotlinlib.gson

class User(
    val name: String,
    var age: Int
): Person() {


    operator fun component1(): String = name

    operator fun component2(): Int = age
}
