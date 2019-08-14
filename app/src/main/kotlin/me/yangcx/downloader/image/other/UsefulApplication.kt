package me.yangcx.downloader.image.other

import android.app.Application
import me.yangcx.downloader.image.di.GsonModule
import me.yangcx.downloader.image.di.RepositoryModule
import me.yangcx.downloader.image.di.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

@Suppress("unused")
class UsefulApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initSdk()
    }

    private fun initSdk() {
        startKoin {
            androidContext(this@UsefulApplication)
            modules(
                listOf(
                    GsonModule.instance,
                    RepositoryModule.instance,
                    ViewModelModule.instance
                )
            )
        }
    }
}