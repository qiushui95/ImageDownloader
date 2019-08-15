package me.yangcx.downloader.image.di

import me.yangcx.downloader.image.repository.ImageRepository
import me.yangcx.downloader.image.repository.RecordRepository
import me.yangcx.downloader.image.repository.SearchRepository
import org.koin.dsl.module
import org.koin.experimental.builder.single

object RepositoryModule {
    val instance by lazy {
        module {
            single<ImageRepository>()
            single<RecordRepository>()
            single<SearchRepository>()
        }
    }
}