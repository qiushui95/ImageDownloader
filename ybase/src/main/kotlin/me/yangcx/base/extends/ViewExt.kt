package me.yangcx.base.extends

import android.view.View
import me.yangcx.base.R

private val KEY_TAG_CLICK_TIME = R.id.idTagSingleClick
@Suppress("UNUSED_PARAMETER")
private var View.lastClickTime: Long
    set(value) = setTag(KEY_TAG_CLICK_TIME, System.currentTimeMillis())
    get() = getTag(KEY_TAG_CLICK_TIME)?.toString()?.toLongOrNull() ?: 0L

private fun View.canClick(duration: Int) = System.currentTimeMillis() - lastClickTime >= duration

fun View.singleClick(block: () -> Unit) {
    singleClick(1000, block)
}

fun View.singleClick(duration: Int, block: () -> Unit) {
    setOnClickListener {
        if (canClick(duration)) {
            block()
            lastClickTime = 0
        }
    }
}