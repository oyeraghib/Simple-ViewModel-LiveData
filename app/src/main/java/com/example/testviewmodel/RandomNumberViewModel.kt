package com.example.testviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber
import kotlin.random.Random

class RandomNumberViewModel: ViewModel() {

    private var _randomNumber: MutableLiveData<String> = MutableLiveData()

    val randomNumber: LiveData<String> get() = _randomNumber

    fun createRandomNumber() {
        _randomNumber.value = "Random : ${Random.nextInt(10) + 1}"
        Timber.i("Random number address going from ViewModel is $randomNumber")
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("ViewModel Destroyed")
    }
}