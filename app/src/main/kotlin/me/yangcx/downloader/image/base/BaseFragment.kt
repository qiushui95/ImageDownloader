package me.yangcx.downloader.image.base

import androidx.databinding.ViewDataBinding
import me.yangcx.base.ui.DataBindingFragment

abstract class BaseFragment<B : ViewDataBinding> : DataBindingFragment<B>()