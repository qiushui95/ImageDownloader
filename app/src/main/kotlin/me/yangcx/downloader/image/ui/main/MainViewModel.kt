package me.yangcx.downloader.image.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.Transformations
import com.jeremyliao.liveeventbus.LiveEventBus
import me.yangcx.downloader.image.base.BaseViewModel
import me.yangcx.downloader.image.entity.SearchInfo
import me.yangcx.downloader.image.other.Logg
import me.yangcx.downloader.image.repository.ImageRepository
import me.yangcx.downloader.image.repository.RecordRepository
import me.yangcx.downloader.image.repository.SearchRepository
import me.yangcx.downloader.image.service.ImageSearchService

class MainViewModel(private val imageRepository: ImageRepository, private val recordRepository: RecordRepository) : BaseViewModel() {

    private val stopObserver by lazy {
        Observer<Boolean> {
            _searchInfo.value?.apply {
                _searchInfo.value = copy(isSearch = false)
            }
        }
    }

    init {
        LiveEventBus.get().apply {
            with(ImageSearchService.ACTION_CANCEL_FETCH, Boolean::class.java)
                    .observeForever(stopObserver)
        }
    }

    private val _searchInfo by lazy {
        MutableLiveData<SearchInfo>()
    }

    val searchInfo: LiveData<SearchInfo>
        get() = _searchInfo

    val searchRecord by lazy {
        Transformations.switchMap(_searchInfo) {
            recordRepository.loadBySearchAfterTime(it.search, it.time)
        }
    }

    val searchPage by lazy {
        Transformations.map(searchRecord) { list ->
            (list.map {
                it.page
            }.max() ?: 0) + 1
        }
    }

    val fetchCount by lazy {
        Transformations.map(searchRecord) { list ->
            list.sumBy {
                it.fetchCount
            }
        }
    }

    val saveCount by lazy {
        Transformations.map(searchRecord) { list ->
            list.sumBy {
                it.saveCount
            }
        }
    }


    val imageList by lazy {
        Transformations.switchMap(_searchInfo) {
            imageRepository.loadFromRoom(it.search)
        }
    }


    fun startSearch(search: String) {
        _searchInfo.value = SearchInfo(true, search)
    }

    override fun onCleared() {
        LiveEventBus.get()
                .apply {
                    with(ImageSearchService.ACTION_CANCEL_FETCH, Boolean::class.java)
                            .removeObserver(stopObserver)
                }
    }
}