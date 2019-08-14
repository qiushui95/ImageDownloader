package me.yangcx.downloader.image.di

import me.yangcx.downloader.image.ui.main.MainViewModel
import org.koin.androidx.experimental.dsl.viewModel
import org.koin.dsl.module

object ViewModelModule {
    val instance = module {
        viewModel<MainViewModel>()
    }
}