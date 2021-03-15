package com.csci448.trentdouglas.trentdouglas_a2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.csci448.trentdouglas.trentdouglas_a2.Game
@Database(entities = [ Game::class ], version = 2)
@TypeConverters(GameTypeConverters::class)

abstract class GameDatabase : RoomDatabase() {
    abstract val gameDao: GameDao
    companion object {
        private const val DATABASE_NAME = "game-database"
        private var INSTANCE: GameDatabase? = null

        private val migration_1_2 = object : Migration(1,2) {
            override fun migrate(database: SupportSQLiteDatabase) { database.execSQL( "ALTER TABLE game ADD COLUMN suspect TEXT DEFAULT NULL")
                database.execSQL( "ALTER TABLE game ADD COLUMN suspectNumber TEXT DEFAULT NULL")
            }
        }


        fun getInstance(context: Context): GameDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if(instance == null) {
                    instance = Room.databaseBuilder(context.applicationContext,
                        GameDatabase::class.java,
                        DATABASE_NAME)
                        .addMigrations(migration_1_2)
                        .build()
                }
                return instance
            }
        }
    }
}
