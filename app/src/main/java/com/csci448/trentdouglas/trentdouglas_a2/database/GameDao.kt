package com.csci448.trentdouglas.trentdouglas_a2.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.csci448.trentdouglas.trentdouglas_a2.Game
import java.util.*

@Dao
interface GameDao {
    @Query("SELECT * FROM game")
    fun getGames(): LiveData<List<Game>>

    @Query("SELECT * FROM game WHERE id=(:id)")
    fun getGame(id: UUID): LiveData<Game?>

    @Update
    fun updateGame(game: Game)

    @Insert
    fun addGame(game: Game)

    @Query("DELETE FROM game")
    fun clearData()

    @Query("SELECT COUNT(*) FROM game WHERE winner=(:type)")
    fun getStats(type:String) : LiveData<Int>

    @Query("SELECT COUNT(*) FROM game WHERE winner=(:type_one) OR winner=(:type_two)")
    fun getTwoStats(type_one:String, type_two:String) : LiveData<Int>
}
