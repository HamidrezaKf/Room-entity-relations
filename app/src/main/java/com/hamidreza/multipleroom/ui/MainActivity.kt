package com.hamidreza.multipleroom.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.hamidreza.multipleroom.R
import com.hamidreza.multipleroom.data.local.CollegeDao
import com.hamidreza.multipleroom.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    private val viewModel : MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.result()
        binding.button.setOnClickListener {
            val url = "https://github.com/HamidrezaKf/Room-entity-relations/blob/master/README.md"
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        }
    }
}