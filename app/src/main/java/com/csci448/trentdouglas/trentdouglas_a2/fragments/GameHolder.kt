package com.csci448.trentdouglas.trentdouglas_a2.fragments

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.csci448.trentdouglas.trentdouglas_a2.Game
import com.csci448.trentdouglas.trentdouglas_a2.databinding.ListItemGameBinding

class GameHolder(val binding: ListItemGameBinding) : RecyclerView.ViewHolder(binding.root) {

    private lateinit var game: Game

    fun bind(game: Game) {
        this.game = game
        var displayText = "Winner: " + this.game.winner
        binding.gameWinner.text =displayText
        binding.gameDateTextView.text = this.game.date.toString()
    }
}