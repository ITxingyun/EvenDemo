package com.xingyun.storage.http.api

import com.xingyun.storage.data.entity.*
import retrofit2.http.*
import kotlin.Result

interface WebService {

    @GET("/article/top/json")
    suspend fun getTopArticles(): Result<List<Article>>

    @GET("/article/list/{page}/json")
    suspend fun getRecommendArticles(@Path("page") page: Int): ResponseList<Article>

    @GET("/banner/json")
    suspend fun getBanner(): List<Banner>

    @GET("/tree/json")
    suspend fun getSystemCategory(): List<Category>

    @GET("/article/list/{page}/json")
    suspend fun getSystemTypeArticles(@Path("page") page: Int, @Query("cid") cid: Int): ResponseList<Article>

    @GET("/project/tree/json")
    suspend fun getProjectCategory(): List<Category>

    @GET("/wxarticle/chapters/json")
    suspend fun getBlogCategory(): List<Category>

    @GET("/wxarticle/list/{id}/{page}/json")
    suspend fun getBlogArticles(@Path("id") id: Int, @Path("page") page: Int): ResponseList<Article>

    @GET("/project/list/{page}/json")
    suspend fun getProjectList(@Path("page") page: Int, @Query("cid") cid: Int): ResponseList<Article>

    @GET("/article/listproject/{page}/json")
    suspend fun getLatestProject(@Path("page") page: Int): ResponseList<Article>

    @GET("/friend/json")
    suspend fun getWebsites(): List<Hot>

    @GET("/hotkey/json")
    suspend fun getHot(): List<Hot>

    @FormUrlEncoded
    @POST("/article/query/{page}/json")
    suspend fun searchArticles(@Path("page") page: Int, @Field("k") key: String): ResponseList<Article>

    @GET("/lg/collect/list/{page}/json")
    suspend fun getCollectArticles(@Path("page") page: Int): ResponseList<Article>

    @POST("/lg/collect/{id}/json")
    suspend fun collectArticle(@Path("id") id: Int): ResponseList<Article>

    @POST("/lg/uncollect_originId/{id}/json")
    suspend fun cancelCollectArticle(@Path("id") id: Int): ResponseList<Article>

    @GET("/user_article/list/{page}/json")
    suspend fun getSquareArticles(@Path("page") page: Int): ResponseList<Article>

    @FormUrlEncoded
    @POST("/lg/user_article/add/json")
    suspend fun shareArticle(@Field("title") title: String, @Field("link") url: String): String

    @GET("wenda/list/{page}/json")
    suspend fun getQuestions(@Path("page") page: Int): ResponseList<Article>

    @GET("coin/rank/{page}/json")
    suspend fun getRankList(@Path("page") page: Int): ResponseList<Rank>

    @FormUrlEncoded
    @POST("user/login")
    suspend fun login(@Field("username") userName: String, @Field("password") password: String): User

    @POST("user/register")
    suspend fun registry(
            @Field("username") userName: String,
            @Field("password") password: String,
            @Field("repassword") rePassword: String
    ): User

    suspend fun logout(): String

}