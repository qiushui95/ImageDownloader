package me.yangcx.downloader.image.binding

import android.view.View
import androidx.databinding.BindingAdapter
import java.util.*

@Suppress("unused")
object VisibleAdapter {
    @JvmStatic
    @BindingAdapter("android:visibility")
    fun setVisibilityWithBoolean(view: View, visibility: String) {
        when (visibility.toUpperCase(Locale.getDefault())) {
            "GONE" -> View.GONE
            "VISIBLE" -> View.VISIBLE
            else -> View.INVISIBLE
        }.takeIf {
            view.visibility != it
        }?.apply {
            view.visibility = this
        }
    }
}