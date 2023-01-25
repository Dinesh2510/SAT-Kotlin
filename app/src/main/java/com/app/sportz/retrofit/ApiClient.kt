package com.app.sportz.retrofit

import com.app.sportz.retrofit.Response.ResponseGame
import retrofit2.Call
import retrofit2.http.*

interface ApiClient {

    @GET("nzin01312019187360.json")
    fun getGameData(): Call<ResponseGame>



}