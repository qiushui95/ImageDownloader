package me.yangcx.downloader.image.repository

import me.yangcx.downloader.image.base.BaseRepository
import me.yangcx.downloader.image.database.dao.ImageInfoDao

class ImageRepository(private val imageInfoDao: ImageInfoDao) : BaseRepository() {

    fun loadFromRoom(search: String) = imageInfoDao.loadBySearch(search)
}