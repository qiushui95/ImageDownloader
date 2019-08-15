package me.yangcx.downloader.image.database.dao

import androidx.room.Dao
import androidx.room.Transaction
import me.yangcx.downloader.image.entity.ImageInfo
import me.yangcx.downloader.image.entity.SearchRecord

@Dao
interface SearchDao : ImageInfoDao, SearchRecordDao {
    @Transaction
    suspend fun insertSearchResult(search: String, page: Int, list: List<ImageInfo>) {
        val saveCount = insert(list).count {
            it >= 0
        }
        insert(SearchRecord(search, page, list.size, saveCount, System.currentTimeMillis()))
    }
}