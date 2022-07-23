package com.xingyun.kotlinlib.patterns

class User {
    val name: String = "name"
    var age: Int = 0

    private val sex: String = "man"

    private var from: String = "cn"


    fun getInt(int: Int) : String {
        return when(int) {
            1 -> "1"
            else -> "0"
        }
    }

}