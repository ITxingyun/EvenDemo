package com.xingyun.storage.data.entity

data class Rank(
        val userId: Int,
        val username: String,
        val rank: String,
        val level: Int,
        val coinCount: Int
)