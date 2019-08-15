package me.yangcx.downloader.image.di

import me.yangcx.downloader.image.init.OkHttpClientConfig
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

object HttpModule {
    val instance by lazy {
        module {
            single {
                OkHttpClient.Builder()
                    .retryOnConnectionFailure(true)
                    .connectTimeout(5 * 1000, TimeUnit.MILLISECONDS)
                    .readTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                    .writeTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                    .apply {
                        OkHttpClientConfig.configMore(this)
                    }
                    .build()
            }
            single {
                Retrofit.Builder()
                    .baseUrl("https://unsplash.com/napi/")
                    .addConverterFactory(GsonConverterFactory.create(get()))
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .client(get())
                    .build()
            }
        }
    }
}