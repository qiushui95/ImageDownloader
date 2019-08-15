package me.yangcx.downloader.image.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = [ForeignKey(entity = ImageInfo::class, parentColumns = ["id"], childColumns = ["id"], onDelete = ForeignKey.NO_ACTION, onUpdate = ForeignKey.CASCADE)])
data class DownloadInfo(
        @ColumnInfo(name = "id")
        @PrimaryKey val id: String,
        @ColumnInfo(name = "progress")
        val progress: Float,
        @ColumnInfo(name = "path")
        val path: String
)