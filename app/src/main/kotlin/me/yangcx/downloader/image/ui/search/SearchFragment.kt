package me.yangcx.downloader.image.ui.search

import android.content.Intent
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.AlignItems
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.jeremyliao.liveeventbus.LiveEventBus
import com.mancj.materialsearchbar.MaterialSearchBar
import kotlinx.android.synthetic.main.fragment_search.*
import me.tatarka.bindingcollectionadapter2.*
import me.yangcx.annotation.BindLayoutRes
import me.yangcx.base.extends.singleClick
import me.yangcx.downloader.image.BR
import me.yangcx.downloader.image.R
import me.yangcx.downloader.image.base.BaseFragment
import me.yangcx.downloader.image.databinding.FragmentSearchBinding
import me.yangcx.downloader.image.entity.SearchRecord
import me.yangcx.downloader.image.other.Logg
import me.yangcx.downloader.image.service.ImageSearchService
import me.yangcx.downloader.image.ui.main.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

@BindLayoutRes(R.layout.fragment_search)
class SearchFragment : BaseFragment<FragmentSearchBinding>(), MaterialSearchBar.OnSearchActionListener {

    private val viewModel by sharedViewModel<MainViewModel>()

    private val itemBinding by lazy {
        itemBindingOf<SearchRecord>(BR.data, R.layout.item_search_record)
    }

    private val diffConfig by lazy {
        object : DiffUtil.ItemCallback<SearchRecord>() {
            override fun areItemsTheSame(oldItem: SearchRecord, newItem: SearchRecord): Boolean {
                return oldItem.search == newItem.search && oldItem.page == newItem.page && oldItem.time == newItem.time
            }

            override fun areContentsTheSame(oldItem: SearchRecord, newItem: SearchRecord): Boolean {
                return oldItem.fetchCount == newItem.fetchCount && oldItem.saveCount == newItem.saveCount
            }
        }
    }

    private val viewHolderFactory by lazy {
        BindingRecyclerViewAdapter.ViewHolderFactory {
            RecordViewHolder(it.root)
        }
    }

    override fun initBinder(binder: FragmentSearchBinding) {
        binder.viewModel = viewModel
        binder.itemBinding = itemBinding
        binder.diffConfig = diffConfig
        binder.viewHolderFactory = viewHolderFactory
    }

    override fun onViewCreated(view: View) {
        msbSearch.setOnSearchActionListener(this)
        initRecycler()
        viewModel.searchInfo.observe(viewLifecycleOwner, Observer {
            if (msbSearch.text != it.search) {
                msbSearch.text = it.search
            }
        })
        btnCancel.singleClick {
            LiveEventBus.get()
                    .with(ImageSearchService.ACTION_CANCEL_FETCH, Boolean::class.java)
                    .broadcast(true, true)
        }
    }

    private fun initRecycler() {
        rvRecord.layoutManager = FlexboxLayoutManager(requireContext(), FlexDirection.ROW, FlexWrap.WRAP)
    }

    override fun onButtonClicked(buttonCode: Int) {

    }

    override fun onSearchStateChanged(enabled: Boolean) {

    }

    override fun onSearchConfirmed(text: CharSequence?) {
        hideSoftInput()
        msbSearch.disableSearch()
        text?.toString()
                ?.also { search ->
                    viewModel.startSearch(search)
                    Intent(requireContext(), ImageSearchService::class.java).apply {
                        putExtra(ImageSearchService.ACTION_CANCEL_FETCH, search)
                        requireContext().stopService(this)
                        requireContext().startService(this)
                    }
                }
    }
}