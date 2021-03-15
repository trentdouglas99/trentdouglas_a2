package com.csci448.trentdouglas.trentdouglas_a2.fragments

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.csci448.trentdouglas.trentdouglas_a2.repo.GameRepository

class Game_Fragment_View_Model_Factory (private val context: Context) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return modelClass.getConstructor(GameRepository::class.java).newInstance(GameRepository.getInstance(context))
        }

}