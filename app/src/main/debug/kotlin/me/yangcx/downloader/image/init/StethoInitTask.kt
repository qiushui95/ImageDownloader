package me.yangcx.downloader.image.init

import android.app.Application
import com.facebook.stetho.Stetho

class StethoInitTask(private val application: Application) {
    fun run() {
        Stetho.initializeWithDefaults(application)
    }
}