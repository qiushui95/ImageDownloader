package me.yangcx.base.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import me.yangcx.annotation.BindLayoutRes
import me.yangcx.base.sundries.UnbindLayoutException
import me.yokeyword.fragmentation.SupportFragment

/**
 * 基础Fragment
 * create by 97457
 * create at 2018/11/04 0004
 */
abstract class FoundationFragment : SupportFragment() {

    /**
     * 获取布局id
     * create by 97457
     * create at 2018/12/13
     */
    protected open fun getLayoutResId(): Int {
        val annotation = javaClass.getAnnotation(BindLayoutRes::class.java)
        if (annotation != null && annotation.layoutRes > 0) {
            return annotation.layoutRes
        } else {
            throw UnbindLayoutException()
        }
    }

    /**
     * 获取View
     */
    protected open fun createContentView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        try {
            return inflater.inflate(getLayoutResId(), container, false)
        } catch (ex: Exception) {
            throw ex
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =createContentView(inflater, container, savedInstanceState)


    /**
     * 重设输入法模式
     */
    protected fun resetInputMode(mode: Int) = requireActivity().window.setSoftInputMode(mode)

}