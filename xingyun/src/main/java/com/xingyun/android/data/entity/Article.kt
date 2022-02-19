package com.xingyun.android.data.entity

import androidx.room.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Entity(tableName = "article")
data class Article constructor(
    @PrimaryKey val id: Int,
    val title: String,
    val link: String,
    val apkLink: String,
    val audit: Int,
    val author: String,
    val canEdit: Boolean,
    val chapterId: Int,
    val chapterName: String,
    val collect: Boolean,
    val courseId: Int,
    val desc: String,
    val descMd: String,
    val envelopePic: String,
    val fresh: Boolean,
    val niceDate: String,
    val niceShareDate: String,
    val origin: String,
    val prefix: String,
    val projectLink: String,
    val publishTime: Long,
    val selfVisible: Int,
    val shareDate: Long?,
    val shareUser: String,
    val realSuperChapterId: Int,
    val superChapterId: Int,
    val superChapterName: String,
    val tags: List<Tag>?,
    val type: Int,
    val userId: Int,
    val visible: Int,
    val zan: Int
)

data class Tag(val name: String, val url: String)

class TagsConverters {
    @TypeConverter
    fun tagsToString(tags: List<Tag>?): String? {
        return tags?.run {
            val type = object : TypeToken<List<Tag>>() {}.type
            Gson().toJson(tags, type)
        }
    }

    @TypeConverter
    fun stringToTags(value: String?): List<Tag>? {
        return value?.run {
            val type = object : TypeToken<List<Tag>>() {}.type
            Gson().fromJson(value, type)
        }
    }

}
