package com.example.tracksbuddy.data.remote

import com.example.tracksbuddy2.data.remote.JsonData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface APIRequests {

    @GET("v1/me/tracks?market=BR")
    fun getUserData(@Header("Authorization") myToken: String?): Response<JsonData>

}