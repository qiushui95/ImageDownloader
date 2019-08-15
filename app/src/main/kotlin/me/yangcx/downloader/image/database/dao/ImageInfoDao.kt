package me.yangcx.downloader.image.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import me.yangcx.downloader.image.entity.ImageInfo

@Dao
interface ImageInfoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(list: List<ImageInfo>): List<Long>

    @Delete
    suspend fun delete(list: List<ImageInfo>)

    @Query("select * from ImageInfo where search=:search;")
    fun loadBySearch(search: String): LiveData<List<ImageInfo>>
}