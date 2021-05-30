package com.example.tracksbuddy.presenter.login

import android.app.Application
import android.content.Intent
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    val app: Application,
) : ViewModel() {

    fun onSpotifyResult(requestCode: Int, resultCode: Int, intent: Intent?) {

    }
}


