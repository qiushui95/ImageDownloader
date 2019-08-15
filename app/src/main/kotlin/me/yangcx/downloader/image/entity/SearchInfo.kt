package me.yangcx.downloader.image.entity

data class SearchInfo(val isSearch: Boolean, val search: String, val time: Long = System.currentTimeMillis())