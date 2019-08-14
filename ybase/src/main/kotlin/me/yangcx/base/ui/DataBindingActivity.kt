package me.yangcx.base.ui

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class DataBindingActivity<B : ViewDataBinding> : FoundationActivity() {
    protected lateinit var binder: B

    protected open fun initBinder(binder: B) {

    }

    override fun setContentView() {
        binder = DataBindingUtil.setContentView<B>(this, getLayoutId()).apply {
            lifecycleOwner = this@DataBindingActivity
            initBinder(this)
        }
    }
}