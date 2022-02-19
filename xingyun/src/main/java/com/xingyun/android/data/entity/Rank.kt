package com.xingyun.android.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "rank")
data class Rank(
    @PrimaryKey val userId: Int,
    val username: String,
    val rank: String,
    val level: Int,
    val coinCount: Int
)