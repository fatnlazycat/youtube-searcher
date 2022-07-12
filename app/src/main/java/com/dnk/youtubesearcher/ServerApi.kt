package com.dnk.youtubesearcher

import retrofit2.Response
import retrofit2.http.GET

interface ServerApi {
    @GET
    suspend fun getData() : Response<String>
}