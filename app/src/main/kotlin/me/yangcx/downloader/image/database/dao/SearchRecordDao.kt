package me.yangcx.downloader.image.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import me.yangcx.downloader.image.entity.SearchRecord

@Dao
interface SearchRecordDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg record: SearchRecord)

    @Query("select * from SearchRecord where search=:search and time >=:time order by time desc;")
    fun loadBySearchAfterTime(search: String, time: Long): LiveData<List<SearchRecord>>
}