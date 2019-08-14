package me.yangcx.downloader.image.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.noober.background.BackgroundLibrary
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BackgroundLibrary.inject2(this)
    }
}
