package com.example.tracksbuddy2.presenter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.tracksbuddy2.R
import com.example.tracksbuddy2.data.SpotifyConstants
import com.example.tracksbuddy2.data.SpotifyConstants.TAG
import com.spotify.sdk.android.auth.AuthorizationClient
import com.spotify.sdk.android.auth.AuthorizationRequest
import com.spotify.sdk.android.auth.AuthorizationResponse
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        spotifySignIn()
    }

    private fun spotifySignIn() {
        val builder =
            AuthorizationRequest.Builder(
                SpotifyConstants.CLIENT_ID, AuthorizationResponse.Type.TOKEN,
                SpotifyConstants.REDIRECT_URI
            )
        builder.setScopes(arrayOf("user-library-read"))
        val request = builder.build()
        AuthorizationClient.openLoginActivity(
            this,
            SpotifyConstants.REQUEST_CODE,
            request
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
        if (requestCode == SpotifyConstants.REQUEST_CODE) {
            val response = AuthorizationClient.getResponse(resultCode, intent)
            when (response.type) {
                AuthorizationResponse.Type.TOKEN -> {
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show()

                }
                AuthorizationResponse.Type.ERROR -> {
                    Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show()
                }
                else -> {
                }
            }
        }
    }
}