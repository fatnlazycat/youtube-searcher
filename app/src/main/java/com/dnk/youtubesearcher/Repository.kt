package com.dnk.youtubesearcher

import android.util.Log
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

class Repository {
    val TAG = "Repository"
    val api: ServerApi by lazy {
        RetrofitHelper.getInstance().create(ServerApi::class.java)
    }

    fun getData(liveData: MutableLiveData<List<String>>) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = api.getData().body()
            response?. let {
                val parsed = RawDataTransformer.transform(it)
                liveData.postValue(parsed)
            }

        }
    }
}

object RawDataTransformer {
    val REGEX = Regex("\"/watch\\?v=(.*?)\"")
    fun transform(raw: String): List<String> {
        val allMatches = REGEX.findAll(raw).map { m -> m.destructured.component1() }.toList()
        return allMatches
    }
}