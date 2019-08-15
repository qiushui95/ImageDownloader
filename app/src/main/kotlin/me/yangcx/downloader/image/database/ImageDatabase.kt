package me.yangcx.downloader.image.database

import androidx.room.Database
import androidx.room.RoomDatabase
import me.yangcx.downloader.image.database.dao.DownloadInfoDao
import me.yangcx.downloader.image.database.dao.ImageInfoDao
import me.yangcx.downloader.image.database.dao.SearchDao
import me.yangcx.downloader.image.database.dao.SearchRecordDao
import me.yangcx.downloader.image.entity.DownloadInfo
import me.yangcx.downloader.image.entity.ImageInfo
import me.yangcx.downloader.image.entity.SearchRecord

@Database(entities = [ImageInfo::class, DownloadInfo::class, SearchRecord::class], version = 1)
abstract class ImageDatabase : RoomDatabase() {
    abstract fun getImageInfoDao(): ImageInfoDao
    abstract fun getSearchRecordDao(): SearchRecordDao
    abstract fun getSearchDao(): SearchDao
    abstract fun getDownloadInfoDao(): DownloadInfoDao
}