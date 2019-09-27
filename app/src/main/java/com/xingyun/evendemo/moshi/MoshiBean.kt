package com.xingyun.evendemo.moshi

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class MoshiBean {
    var id = "123"

    var name: String = "even"
}