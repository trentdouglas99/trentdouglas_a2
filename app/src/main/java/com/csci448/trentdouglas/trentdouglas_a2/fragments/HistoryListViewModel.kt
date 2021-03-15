package com.csci448.trentdouglas.trentdouglas_a2.fragments

import androidx.lifecycle.ViewModel
import com.csci448.trentdouglas.trentdouglas_a2.Game
import com.csci448.trentdouglas.trentdouglas_a2.repo.GameRepository

class HistoryListViewModel (private val gameRepository: GameRepository) : ViewModel() {
    val gameListLiveData = gameRepository.getGames()

    fun addCrime(game: Game) {
        gameRepository.addGame(game)
    }

}
