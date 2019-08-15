package me.yangcx.downloader.image.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import me.yangcx.downloader.image.ui.index.IndexFragment
import me.yangcx.downloader.image.ui.record.RecordFragment
import me.yangcx.downloader.image.ui.search.SearchFragment

class MainPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fm, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            1 -> SearchFragment()
            2 -> RecordFragment()
            else -> IndexFragment()
        }
    }
}