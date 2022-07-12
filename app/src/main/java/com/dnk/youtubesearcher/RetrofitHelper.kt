package com.dnk.youtubesearcher

import retrofit2.Retrofit

object RetrofitHelper {

    val baseUrl = " https://www.youtube.com/results?search_query="

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl).build()
    }
}