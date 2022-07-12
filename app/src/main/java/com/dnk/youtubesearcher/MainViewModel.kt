package com.dnk.youtubesearcher

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val TAG = "MainViewModel"

    private val repository = AppClass.instance.repository

    val allVideos = MutableLiveData<List<String>>()

    fun setVideos(rawData: String) {
        allVideos.value = RawDataTransformer.transform(rawData)
    }

    fun retrieveVideos() {
        AppClass.instance.repository.getData(allVideos)
    }
}

