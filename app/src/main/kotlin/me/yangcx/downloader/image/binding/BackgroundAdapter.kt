package me.yangcx.downloader.image.binding

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.databinding.BindingConversion

@Suppress("unused")
object BackgroundAdapter {
    @JvmStatic
    @BindingConversion
    fun colorStringToDrawable(color: String) = ColorDrawable(Color.parseColor(color))
}