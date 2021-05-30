package com.example.tracksbuddy.presenter.trackslist

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tracksbuddy2.data.Repository
import com.example.tracksbuddy2.data.SpotifyConstants.TAG
import com.example.tracksbuddy2.data.remote.JsonData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TracksListViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    lateinit var myToken: String
    lateinit var liveData: MutableLiveData<ArrayList<JsonData>>

    fun spotifyRequest() {
        val request = repository.getSpotifyData(myToken)
        if (request.isSuccessful) {
            val json = request.body()!!.items
            for (items in json) {
                Log.d(TAG, items.toString())
            }
        }
    }
}