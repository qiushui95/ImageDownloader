package me.yangcx.downloader.image.repository

import me.yangcx.downloader.image.base.BaseRepository
import me.yangcx.downloader.image.database.dao.SearchRecordDao

class RecordRepository(private val recordDao: SearchRecordDao) : BaseRepository() {
    fun loadBySearchAfterTime(search: String, time: Long) = recordDao.loadBySearchAfterTime(search, time)
}