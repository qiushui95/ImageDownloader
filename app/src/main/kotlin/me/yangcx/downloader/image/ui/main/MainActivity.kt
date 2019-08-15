package me.yangcx.downloader.image.ui.main

import androidx.viewpager2.widget.ViewPager2
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import kotlinx.android.synthetic.main.activity_main.*
import me.yangcx.annotation.BindLayoutRes
import me.yangcx.downloader.image.R
import me.yangcx.downloader.image.base.BaseActivity
import me.yangcx.downloader.image.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

@BindLayoutRes(R.layout.activity_main)
class MainActivity : BaseActivity<ActivityMainBinding>() {
    private val viewModel by viewModel<MainViewModel>()

    override fun onViewCreated() {
        initBottomBar()
        initPager()
    }

    override fun onBindViewListener() {

    }

    private fun initBottomBar() {
        bnbMain.addItem(BottomNavigationItem(R.drawable.ic_home, "首页"))
                .addItem(BottomNavigationItem(R.drawable.ic_search, "搜索"))
                .addItem(BottomNavigationItem(R.drawable.ic_record, "记录"))
                .setActiveColor(R.color.colorPrimary)
                .setBarBackgroundColor("#FFFFFFFF")
                .setTabSelectedListener(object : BottomNavigationBar.SimpleOnTabSelectedListener() {
                    override fun onTabSelected(position: Int) {
                        vpMain.setCurrentItem(position, true)
                    }
                })
                .setFirstSelectedPosition(1)
                .initialise()
    }

    private fun initPager() {
        vpMain.adapter = MainPagerAdapter(supportFragmentManager, lifecycle)
        vpMain.isUserInputEnabled = false
        vpMain.setCurrentItem(1, false)
    }
}