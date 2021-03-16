package com.csci448.trentdouglas.trentdouglas_a2.repo

import android.content.Context
import androidx.lifecycle.LiveData
import com.csci448.trentdouglas.trentdouglas_a2.Game
import com.csci448.trentdouglas.trentdouglas_a2.database.GameDao
import com.csci448.trentdouglas.trentdouglas_a2.database.GameDatabase
import java.util.*
import java.util.concurrent.Executors

class GameRepository private constructor (private val gameDao: GameDao) {
    fun getGames(): LiveData<List<Game>> = gameDao.getGames()
    fun getGame(id: UUID): LiveData<Game?> = gameDao.getGame(id)
    private val executor = Executors.newSingleThreadExecutor()
    companion object {
        private var INSTANCE: GameRepository? = null
        fun getInstance(context: Context): GameRepository {
            synchronized(this) {
                var instance = INSTANCE
                if(instance == null) {
                    val database = GameDatabase.getInstance(context)
                    instance = GameRepository(database.gameDao)
                    INSTANCE = instance
                }
                return instance
            }
        }

    }
    fun addGame(game: Game){
        executor.execute{
            gameDao.addGame(game)
        }
    }
    fun updateGame(game: Game){
        executor.execute{
            gameDao.updateGame(game)
        }
    }
    fun clearData(){
        executor.execute{
            gameDao.clearData()
        }
    }


}