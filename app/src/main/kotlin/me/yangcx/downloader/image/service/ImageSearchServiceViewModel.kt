package me.yangcx.downloader.image.service

import androidx.lifecycle.viewModelScope
import com.jeremyliao.liveeventbus.LiveEventBus
import kotlinx.coroutines.*
import me.yangcx.downloader.image.base.BaseViewModel
import me.yangcx.downloader.image.repository.SearchRepository

class ImageSearchServiceViewModel(private val searchRepository: SearchRepository) : BaseViewModel() {
    companion object {
        const val TAG_FETCHING_PAGE = "FetchPage"
    }

    private var page = 0

    fun startSearch(search: String) {
        stopSearch()
        page = 0
        var totalPage = 1
        viewModelScope.launch(Dispatchers.Default) {
            val bus = LiveEventBus.get()
            while (isActive && page < totalPage) {
                try {
                    bus.with(TAG_FETCHING_PAGE)
                            .broadcast(page + 1)
                    val searchResult = searchRepository.searchImage(search, page)
                    totalPage = searchResult.totalPages
                    searchRepository.insertSearchResult(search, ++page, searchResult.results.map {
                        it.copy(search = search)
                    })
                } catch (ex: Exception) {
                    continue
                }
            }
        }
    }

    fun stopSearch() {
        viewModelScope.coroutineContext.cancelChildren()
    }
}