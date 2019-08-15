package me.yangcx.downloader.image.database.dao

import androidx.room.*
import me.yangcx.downloader.image.entity.DownloadInfo

@Dao
interface DownloadInfoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(list: List<DownloadInfo>)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun update(list: List<DownloadInfo>)

    @Delete
    suspend fun delete(list: List<DownloadInfo>)
}