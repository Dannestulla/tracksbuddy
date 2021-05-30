package com.example.tracksbuddy2.data

import com.example.tracksbuddy.data.remote.APIRequests
import com.example.tracksbuddy2.data.remote.JsonData
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(
    private val api : APIRequests
) {
    fun getSpotifyData(myToken : String) : Response<JsonData> {
        return api.getUserData(myToken)
    }
}