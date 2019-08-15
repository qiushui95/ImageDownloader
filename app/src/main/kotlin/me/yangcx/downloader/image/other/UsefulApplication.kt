package me.yangcx.downloader.image.other

import android.app.Application
import android.os.Build
import com.facebook.stetho.Stetho
import com.jeremyliao.liveeventbus.LiveEventBus
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.DiskLogAdapter
import com.orhanobut.logger.Logger
import com.tencent.mmkv.MMKV
import me.yangcx.downloader.image.BuildConfig
import me.yangcx.downloader.image.di.*
import me.yangcx.downloader.image.notification.NotificationManager
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

@Suppress("unused")
class UsefulApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin(this)
        initLogger()
        initMmkv(this)
        initStetho()
        initNotification()
        initBus()
    }

    private fun initKoin(application: Application) {
        startKoin {
            androidContext(application)
            printLogger(Level.ERROR)
            modules(
                listOf(
                    DatabaseModule.instance,
                    GsonModule.instance,
                    RepositoryModule.instance,
                    ViewModelModule.instance,
                    HttpModule.instance,
                    ApiModule.instance
                )
            )
        }
    }

    private fun initStetho() {
        Stetho.initializeWithDefaults(this)
    }

    private fun initLogger() {
        if (BuildConfig.DEBUG) {
            Logger.addLogAdapter(AndroidLogAdapter())
        } else {
            Logger.addLogAdapter(DiskLogAdapter())
        }
    }

    private fun initMmkv(application: Application) {
        MMKV.initialize(application)
    }

    private fun initNotification(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager.createNotificationChannels(this)
        }
    }

    private fun initBus(){
        LiveEventBus.get()
            .config()
            .supportBroadcast(this)
            .lifecycleObserverAlwaysActive(true)
            .autoClear(false)
    }
}