package me.yangcx.downloader.image.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class ImageInfo(
        @PrimaryKey
        @SerializedName("id")
        @ColumnInfo(name = "id")
        val id: String,
        @SerializedName("width")
        @ColumnInfo(name = "width")
        val width: Int,
        @SerializedName("height")
        @ColumnInfo(name = "height")
        val height: Int,
        @SerializedName("color")
        @ColumnInfo(name = "color")
        val color: String,
        @ColumnInfo(name = "search")
        val search: String,
        @Embedded
        @SerializedName("urls")
        val urls: UrlInfo
)