package me.yangcx.downloader.image.binding

import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.updateLayoutParams
import androidx.databinding.BindingAdapter

@Suppress("unused")
object ConstraintLayoutAdapter {
    @JvmStatic
    @BindingAdapter("app:layout_constraintDimensionRatio")
    fun setDimensionRatio(view: View, dimensionRatio: String) {
        view.updateLayoutParams<ConstraintLayout.LayoutParams> {
            this.dimensionRatio = dimensionRatio
        }
    }
}