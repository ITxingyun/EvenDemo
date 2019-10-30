package com.xingyun.evendemo.retrofit

import com.xingyun.evendemo.mvvm.FriendWebsite
import com.xingyun.evendemo.mvvm.UserProfile
import io.reactivex.Observable
import retrofit2.http.*

class WanAndroidServiceRetrofit: AbstractServiceRetrofit() {
    private val wanAndroidService: WanAndroidService by lazy { createService(WanAndroidService::class.java) }

    override fun getBaseUrl(): String = "https://www.wanandroid.com/"

    fun login(userProfile: UserProfile): Observable<String> = wanAndroidService.login(userProfile)

    fun loadFriendWebsite(): Observable<FriendWebsite> = wanAndroidService.loadFriendWebsite()

    interface WanAndroidService {

        @POST("user/login")
        fun login(@Body userProfile: UserProfile): Observable<String>

        @GET("article/list/{page}/json")
        fun loadArtile(@Path("page") page: Int, @Query("cid") cid: Int)

        @GET("friend/json")
        fun loadFriendWebsite(): Observable<FriendWebsite>
    }
}