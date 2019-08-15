package me.yangcx.downloader.image.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.jeremyliao.liveeventbus.LiveEventBus

class NotificationService : Service() {
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        when (intent.action) {
            ImageSearchService.ACTION_CANCEL_FETCH -> {
                LiveEventBus.get()
                    .with(ImageSearchService.ACTION_CANCEL_FETCH,Boolean::class.java)
                    .broadcast(true,true)
            }
        }
        return START_STICKY
    }
}