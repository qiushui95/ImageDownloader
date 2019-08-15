package me.yangcx.downloader.image.init

import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient

object OkHttpClientConfig {
    fun configMore(builder: OkHttpClient.Builder) {
        builder.addNetworkInterceptor(StethoInterceptor())
    }
}