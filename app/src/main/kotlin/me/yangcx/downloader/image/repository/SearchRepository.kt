package me.yangcx.downloader.image.repository

import me.yangcx.downloader.image.api.SearchApi
import me.yangcx.downloader.image.base.BaseRepository
import me.yangcx.downloader.image.database.dao.SearchDao
import me.yangcx.downloader.image.entity.ImageInfo

class SearchRepository(private val searchApi: SearchApi, private val searchDao: SearchDao) : BaseRepository() {
    suspend fun searchImage(search: String, page: Int) = searchApi.searchImage(search, page)

    suspend fun insertSearchResult(search: String, page: Int, list: List<ImageInfo>) = searchDao.insertSearchResult(search, page, list)
}