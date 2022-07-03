package com.example.testviewmodel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.testviewmodel.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: RandomNumberViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Timber.i("OnCreate called")

        viewModel = ViewModelProvider(this)[RandomNumberViewModel::class.java]

        viewModel.randomNumber.observe(this, Observer {
            binding.tvRandomNumber.text = it
            Timber.d("Random Number coming is : $it")
        })

        binding.btnFetchRandomNumber.setOnClickListener {
            viewModel.createRandomNumber()
            Timber.i("Fetch Button Pressed")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("Activity Destroyed")
    }
}