package com.xingyun.evendemo.opensoruce.http.okhttp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.xingyun.evendemo.common.BaseFragment
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
            val request = Request.Builder().get().url("http://www.baidu.com").build()
            val call: Call = httpClient.newCall(request)
            val response = call.execute()
            println(response.body().toString())
        }

        binding.tvEnqueue.setOnClickListener {
            val request = Request.Builder().get().url("http://www.baidu.com").build()
            val call: Call = httpClient.newCall(request)
            call.enqueue(object : Callback {
                override fun onResponse(call: Call, response: Response) {
                    println(response.body().toString())
                }

                override fun onFailure(call: Call, e: IOException) {
                    e.printStackTrace()
                }

            })
        }
    }


}