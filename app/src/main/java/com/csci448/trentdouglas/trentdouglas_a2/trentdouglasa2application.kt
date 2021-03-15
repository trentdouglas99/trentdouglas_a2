package com.csci448.trentdouglas.trentdouglas_a2

import android.app.Application
import android.util.Log
import com.csci448.trentdouglas.trentdouglas_a2.repo.GameRepository

class trentdouglasa2application:Application() {


    val initialOrientation by lazy {
        resources.configuration.orientation
    }

    companion object {
        private const val LOG_TAG = "448.criminalIntentApplication"
    }
    override fun onCreate(){
        super.onCreate()
        Log.d(LOG_TAG, "onCreate() called")
        GameRepository.getInstance(this)
    }
}