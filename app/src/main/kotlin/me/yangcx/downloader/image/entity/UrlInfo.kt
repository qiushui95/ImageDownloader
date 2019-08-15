package me.yangcx.downloader.image.entity

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

data class UrlInfo(
    @SerializedName("raw")
    @ColumnInfo(name = "raw")
    val raw: String,
    @SerializedName("small")
    @ColumnInfo(name = "small")
    val small: String
)