package com.xingyun.kotlinlib.gson

import com.google.gson.Gson

//fun main() {
//    val json = "{\"age\":\"12\"}"
//    val user = Gson().fromJson(json, User::class.java)
//    println(user)
//    println(user.name)
//
//
//}

fun add(a: Int, b: Int): Int {
    return a + b
}

//fun addPlus(add : (Int , Int) -> Int) : Int{
//    return add(1, 2) + 1
//}
//
//fun main() {
//    val result = addPlus(::add)
//    println(result)
//}

//fun main() {
//    print("1")
//    print("1", "2")
//    print("1", "2", "3")
//    print("1", "2", "3", "4")
//    print("1", "2", "3", "4", "5")
//}
//
//fun print(
//    one: String,
//    two: String = "two",
//    three: String = "three",
//    four: String = "four",
//    five: String = "five"
//) {
//    println("$one, $two, $three, $four, $five")
//}

infix fun Int.addX(x: Int): Int { return this + x}

fun main() {
    println(1 addX 2)
    println(1 shl 2)
}