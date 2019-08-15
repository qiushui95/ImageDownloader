package me.yangcx.downloader.image.entity

import com.google.gson.annotations.SerializedName


data class SearchResult(
        @SerializedName("total")
        val total: Int,
        @SerializedName("total_pages")
        val totalPages: Int,
        @SerializedName("results")
        val results: List<ImageInfo>
)