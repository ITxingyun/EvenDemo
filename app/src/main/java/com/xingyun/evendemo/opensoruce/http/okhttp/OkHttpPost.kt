//package com.xingyun.evendemo.opensoruce.http.okhttp
//
//import android.util.Log
//import okhttp3.*
//import okhttp3.MediaType.Companion.toMediaTypeOrNull
//import okhttp3.RequestBody.Companion.asRequestBody
//import okhttp3.RequestBody.Companion.toRequestBody
//import java.io.File
//import java.io.IOException
//
//class OkHttpPost {
//    private val httpClient = OkHttpClient()
//
//    //使用FormBody做参数
//    private fun postFormToServer() {
//        val formBody = FormBody.Builder()
//            .add("username", "xingyun")
//            .add("password", "123589aa")
//            .build()
//        val request = Request.Builder()
//            .post(formBody)
//            .url("https://www.wanandroid.com/user/login")
//            .build()
//        val call: Call = httpClient.newCall(request)
//        call.enqueue(object : Callback {
//            override fun onResponse(call: Call, response: Response) {
//                Log.e("com.xingyun.evendemo", response.body!!.string())
//            }
//
//            override fun onFailure(call: Call, e: IOException) {
//                e.printStackTrace()
//            }
//
//        })
//    }
//
//    //使用Json做参数
//    private fun postJsonToServer() {
//        val json = "{\"username\" : \"xingyun\", \"password\" : \"123589aa\"}"
//        val postBody = json.toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())
//        val request = Request.Builder()
//            .post(postBody)
//            .url("https://www.wanandroid.com/user/login")
//            .build()
//        val call: Call = httpClient.newCall(request)
//        call.enqueue(object : Callback {
//            override fun onResponse(call: Call, response: Response) {
//                Log.e("com.xingyun.evendemo", response.body!!.string())
//            }
//
//            override fun onFailure(call: Call, e: IOException) {
//                e.printStackTrace()
//            }
//
//        })
//    }
//
//    fun postFile() {
//        val file = File("README.md")
//        val mediaType = "text/x-markdown; charset=utf-8".toMediaTypeOrNull()
//        val request = Request.Builder()
//            .url("https://api.github.com/markdown/raw")
//            .post(file.asRequestBody(mediaType))
//            .build()
//
//        httpClient.newCall(request).execute().use { response ->
//            if (!response.isSuccessful) throw IOException("Unexpected code $response")
//            println(response.body!!.string())
//        }
//    }
//
//
//}