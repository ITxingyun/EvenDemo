package com.xingyun.storage.http.api

data class ApiResponse<T>(val data: T, val errorCode: Int, val errorMsg: String)