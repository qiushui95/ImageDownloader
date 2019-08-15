package me.yangcx.downloader.image.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import org.joda.time.DateTime

@Entity(tableName = "SearchRecord", primaryKeys = ["search", "page", "time"])
data class SearchRecord(
        @ColumnInfo(name = "search")
        val search: String,
        @ColumnInfo(name = "page")
        val page: Int,
        @ColumnInfo(name = "fetchCount")
        val fetchCount: Int,
        @ColumnInfo(name = "saveCount")
        val saveCount: Int,
        @ColumnInfo(name = "time")
        val time: Long
) {
    val timeText: String
        get() = DateTime(time).toString("yyyy-MM-dd HH:mm:ss")

}