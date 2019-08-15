package me.yangcx.downloader.image.di

import androidx.room.Room
import me.yangcx.downloader.image.database.ImageDatabase
import org.koin.dsl.module

object DatabaseModule {
    val instance by lazy {
        module {
            single {
                Room.databaseBuilder(get(), ImageDatabase::class.java, "ImageInfo.db").build()
            }
            single {
                get<ImageDatabase>().getSearchDao()
            }
            single {
                get<ImageDatabase>().getSearchRecordDao()
            }
            single {
                get<ImageDatabase>().getImageInfoDao()
            }
            single {
                get<ImageDatabase>().getDownloadInfoDao()
            }
        }
    }
}