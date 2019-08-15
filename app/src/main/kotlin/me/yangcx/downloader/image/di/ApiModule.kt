package me.yangcx.downloader.image.di

import me.yangcx.downloader.image.api.SearchApi
import org.koin.dsl.module
import retrofit2.Retrofit

object ApiModule {
    val instance by lazy {
        module {
            single {
                get<Retrofit>().create(SearchApi::class.java)
            }
        }
    }
}