package me.yangcx.downloader.image.di

import com.google.gson.Gson
import org.koin.dsl.module

object GsonModule {
    val instance = module {
        single {
            Gson()
        }
    }
}