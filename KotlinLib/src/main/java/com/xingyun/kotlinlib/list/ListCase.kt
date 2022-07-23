package com.xingyun.kotlinlib.list

import com.xingyun.kotlinlib.gson.User

//fun main() {
//    val list = listOf("1", "2")
//    list.plus("")
//    val mutableList = mutableListOf("1", "2")
//
//    val set = setOf("key", "value")
//    set.plus("")
//    val mutableSet = mutableSetOf("key", "value")
//    mutableList.add("")
//
//    val map = mapOf("key1" to 1, "key2" to 2)
//    map.plus("key1" to 1)
//    val mutableMap = mutableMapOf("key1" to 1, "key2" to 2)
//    mutableMap.plus("key1" to 1)
//}

//fun print(
//    one: String,
//    two: String = "two",
//    three: String = "three",
//    four: String = "four",
//    five: String = "five"
//) {
//    println("$one, $two, $three, $four, $five")
//}

fun main() {
//    print("1")                          // 1, two, three, four, five
//    print("1", "2")                     // 1, 2, three, four, five
//    print("1", "2", "3")                // 1, 2, 3, four, five
//    print("1", "2", "3", "4")           // 1, 2, 3, 4, five
//    print("1", "2", "3", five = "5", four = "4")      // 1, 2, 3, 4, 5

    val user = User("xiaomin", 25)
    val (name, age) = user
    println("name = $name, age = $age")     //  name = xiaomin, age = 25
}