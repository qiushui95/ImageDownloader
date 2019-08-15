package me.yangcx.downloader.image.api

import me.yangcx.downloader.image.entity.ImageInfo
import me.yangcx.downloader.image.entity.SearchResult
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface SearchApi {
    @Headers(
            "User-Agent:Mozilla/5.0 (Windows NT 10.0; WOW64; rv:60.0) Gecko/20100101 Firefox/60.0",
            "X-Requested-With:XMLHttpRequest",
            "Referer:https://unsplash.com/",
            "Host:unsplash.com",
            "Connection:keep-alive"
    )
    @GET("search/photos?per_page=10&xp=")
    suspend fun searchImage(@Query("query") search: String, @Query("page") page: Int): SearchResult
}