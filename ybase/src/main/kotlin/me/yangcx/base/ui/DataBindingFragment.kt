package me.yangcx.base.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import me.yangcx.annotation.BindLayoutRes
import me.yangcx.base.sundries.UnbindLayoutException

abstract class DataBindingFragment<B : ViewDataBinding> : FoundationFragment() {

    protected lateinit var binder: B

    protected open fun initBinder(binder: B) {

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return DataBindingUtil.inflate<B>(inflater, getLayoutResId(), container, false).apply {
            binder = this
            lifecycleOwner = viewLifecycleOwner
            initBinder(this)
        }.root
    }
}