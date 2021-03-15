package com.csci448.trentdouglas.trentdouglas_a2.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.csci448.trentdouglas.trentdouglas_a2.Game
import com.csci448.trentdouglas.trentdouglas_a2.repo.GameRepository
import java.util.*

class Game_Fragment_View_Model (private val gameRepository: GameRepository) : ViewModel(){
    private val gameIdLiveData = MutableLiveData <UUID>()

    var gameLiveData: LiveData<Game?> =
        Transformations.switchMap(gameIdLiveData) { gameId->
            gameRepository.getGame(gameId)
        }
    fun loadGame(gameId: UUID){
        gameIdLiveData.value = gameId
    }
    fun saveGame(game:Game){
        gameRepository.updateGame(game)
    }
    fun addGame(game:Game){
        gameRepository.addGame(game)
    }
}
