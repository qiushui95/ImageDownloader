package me.yangcx.downloader.image.di

import me.yangcx.downloader.image.repository.AreaRepository
import org.koin.dsl.module
import org.koin.experimental.builder.single

object RepositoryModule {
    val instance = module {
        single<AreaRepository>()
    }
}