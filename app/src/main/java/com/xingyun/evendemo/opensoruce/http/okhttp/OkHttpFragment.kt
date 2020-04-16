package com.xingyun.evendemo.opensoruce.http.okhttp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.xingyun.evendemo.common.ui.BaseFragment
import com.xingyun.evendemo.databinding.FragmentOkhttpBinding
import okhttp3.*
import java.io.IOException

class OkHttpFragment : BaseFragment() {
    private lateinit var binding: FragmentOkhttpBinding
    private val httpClient: OkHttpClient = OkHttpClient.Builder().build()

    override val toolbarTitle: String = "OkHttp"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            DataBindingUtil.inflate<FragmentOkhttpBinding>(inflater, com.xingyun.evendemo.R.layout.fragment_okhttp, container, false)
                    .also { binding = it }
                    .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvExecute.setOnClickListener {
            Thread {
                val request = Request.Builder().get().url("https://www.wanandroid.com/project/list/1/json?cid=294").build()
                val call: Call = httpClient.newCall(request)
                val response = call.execute()
                Log.e("com.xingyun.evendemo", response.body()!!.string())
            }.start()
        }

        binding.tvEnqueue.setOnClickListener {
            postFormToServer()
//            postJsonToServer()
        }
    }

    private fun postFormToServer() {
        val formBody = FormBody.Builder()
            .add("username", "xingyun")
            .add("password", "123589aa")
            .build()
        val request = Request.Builder()
            .post(formBody)
            .url("https://www.wanandroid.com/user/login")
            .build()
        val call: Call = httpClient.newCall(request)
        call.enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                Log.e("com.xingyun.evendemo", response.body()!!.string())
            }

            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

        })
    }

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

}