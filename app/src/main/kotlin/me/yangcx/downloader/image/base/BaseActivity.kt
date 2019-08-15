package me.yangcx.downloader.image.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.noober.background.BackgroundLibrary
import me.yangcx.base.ui.DataBindingActivity

abstract class BaseActivity<B : ViewDataBinding> : DataBindingActivity<B>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BackgroundLibrary.inject2(this)
    }
}