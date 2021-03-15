package com.csci448.trentdouglas.trentdouglas_a2

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Game(@PrimaryKey val id: UUID = UUID.randomUUID(),
                 var winner: String = "",
                 var date: Date = Date())

