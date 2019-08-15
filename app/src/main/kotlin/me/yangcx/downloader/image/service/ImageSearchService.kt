package me.yangcx.downloader.image.service

import android.app.Notification
import android.app.PendingIntent
import android.content.Intent
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.lifecycle.LifecycleService
import androidx.lifecycle.Observer
import com.jeremyliao.liveeventbus.LiveEventBus
import me.yangcx.downloader.image.R
import me.yangcx.downloader.image.notification.NotificationManager
import org.koin.android.ext.android.inject

class ImageSearchService : LifecycleService() {
    companion object {
        private const val NOTIFICATION_ID = 19160
        const val ACTION_CANCEL_FETCH = "cancelFetch"
    }

    private val viewModel by inject<ImageSearchServiceViewModel>()

    private val notification by lazy {
        NotificationCompat.Builder(this, NotificationManager.CHANNEL_SIMPLE)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setAutoCancel(false)
                .setOngoing(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
    }

    private fun createNotification(search: String): Notification {
        val intent = Intent(this, NotificationService::class.java)
        intent.action = ACTION_CANCEL_FETCH
        val pendingIntent = PendingIntent.getService(this, NOTIFICATION_ID, intent, 0)
        val action = NotificationCompat.Action.Builder(R.drawable.ic_cancel, "取消", pendingIntent).build()
        return notification.setContentTitle("正在爬取关键字:$search")
                .addAction(action)
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        LiveEventBus.get()
                .with(ACTION_CANCEL_FETCH, Boolean::class.java)
                .observe(this, Observer {
                    viewModel.stopSearch()
                    stopSelf()
                })
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)
        intent?.getStringExtra(ACTION_CANCEL_FETCH)?.apply {
            viewModel.startSearch(this)
            startForeground(NOTIFICATION_ID, createNotification(this))
        }
        return START_NOT_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        stopForeground(true)
    }
}