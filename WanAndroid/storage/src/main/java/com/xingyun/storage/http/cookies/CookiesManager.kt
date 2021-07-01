package com.xingyun.storage.http.cookies

import android.content.Context
import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl

class CookiesManager(context: Context) : CookieJar {
    private val persistentCookieStore = PersistentCookieStore(context)



    override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
        if (cookies.isNotEmpty()) {
            for (item in cookies) {
                persistentCookieStore.add(url, item)
            }
        }
    }

    override fun loadForRequest(url: HttpUrl): MutableList<Cookie> {
        return persistentCookieStore[url]
    }

    /**
     * 清除所有cookie
     */
    fun clearAllCookies() {
        persistentCookieStore.removeAll()
    }

    /**
     * 清除指定cookie
     *
     * @param url HttpUrl
     * @param cookie Cookie
     * @return if clear cookies
     */
    fun clearCookies(url: HttpUrl, cookie: Cookie): Boolean {
        return persistentCookieStore.remove(url, cookie)
    }

    /**
     * 获取cookies
     *
     * @return List<Cookie>
    </Cookie> */
    fun getCookies(): List<Cookie> {
        return persistentCookieStore.getCookies()
    }


}