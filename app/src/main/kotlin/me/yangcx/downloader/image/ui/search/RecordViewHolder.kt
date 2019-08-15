package me.yangcx.downloader.image.ui.search

import android.view.View
import androidx.core.view.updateLayoutParams
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.FlexboxLayoutManager

class RecordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    init {
        itemView.updateLayoutParams<FlexboxLayoutManager.LayoutParams> {
            flexGrow = 1f
        }
    }
}