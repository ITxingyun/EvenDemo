package com.xingyun.evendemo.retrofit

import com.xingyun.evendemo.mvvm.UserProfile
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

class WanAndroidServiceRetrofit: AbstractServiceRetrofit() {
    private val wanAndroidService: WanAndroidService by lazy { createService(WanAndroidService::class.java) }

    override fun getBaseUrl(): String = "https://www.wanandroid.com/"

    fun login(userProfile: UserProfile): Observable<String> = wanAndroidService.login(userProfile)

    interface WanAndroidService {

        @POST("user/login")
        fun login(@Body userProfile: UserProfile): Observable<String>
    }
}