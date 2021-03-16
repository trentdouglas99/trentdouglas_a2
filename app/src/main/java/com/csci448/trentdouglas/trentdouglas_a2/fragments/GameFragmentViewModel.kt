package com.csci448.trentdouglas.trentdouglas_a2.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.csci448.trentdouglas.trentdouglas_a2.Game
import com.csci448.trentdouglas.trentdouglas_a2.repo.GameRepository
import java.util.*

class GameFragmentViewModel (private val gameRepository: GameRepository) : ViewModel(){
    private val gameIdLiveData = MutableLiveData <UUID>()

    public var games = mutableListOf<Boolean>(false, false, false, false, false, false, false, false, false)
    public var playerChose = mutableListOf<Int>()
    public var computerChose = mutableListOf<Int>()
    public var gameOver = false

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
