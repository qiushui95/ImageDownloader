package me.yangcx.downloader.image.ui.index

import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.updateLayoutParams
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_index_image.view.*
import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter
import me.tatarka.bindingcollectionadapter2.itemBindingOf
import me.yangcx.annotation.BindLayoutRes
import me.yangcx.downloader.image.BR
import me.yangcx.downloader.image.R
import me.yangcx.downloader.image.base.BaseFragment
import me.yangcx.downloader.image.databinding.FragmentIndexBinding
import me.yangcx.downloader.image.databinding.FragmentSearchBinding
import me.yangcx.downloader.image.entity.ImageInfo
import me.yangcx.downloader.image.entity.SearchRecord
import me.yangcx.downloader.image.ui.main.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

@BindLayoutRes(R.layout.fragment_index)
class IndexFragment : BaseFragment<FragmentIndexBinding>() {
    private val viewModel by sharedViewModel<MainViewModel>()

    private val itemBinding by lazy {
        itemBindingOf<ImageInfo>(BR.data, R.layout.item_index_image)
    }

    private val diffConfig by lazy {
        object : DiffUtil.ItemCallback<ImageInfo>() {
            override fun areItemsTheSame(oldItem: ImageInfo, newItem: ImageInfo): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ImageInfo, newItem: ImageInfo): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }

    private val adapter by lazy {
        object : BindingRecyclerViewAdapter<ImageInfo>() {
            override fun onBindBinding(binding: ViewDataBinding, variableId: Int, layoutRes: Int, position: Int, item: ImageInfo) {
                super.onBindBinding(binding, variableId, layoutRes, position, item)
                binding.root.apply {
                    Glide.with(this)
                            .load(item.urls.small)
                            .into(ivIndexImage)
                }
            }
        }
    }

    override fun initBinder(binder: FragmentIndexBinding) {
        binder.viewModel = viewModel
        binder.itemBinding = itemBinding
        binder.diffConfig = diffConfig
        binder.adapter = adapter
    }
}