package com.csci448.trentdouglas.trentdouglas_a2.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.csci448.trentdouglas.trentdouglas_a2.Game
import com.csci448.trentdouglas.trentdouglas_a2.databinding.ListItemGameBinding

class HistoryListAdapter(private val games: List<Game>, private val clickListener: (Game) -> Unit ) : RecyclerView.Adapter<GameHolder>() {

    override fun getItemCount(): Int{
        return games.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameHolder {
        val binding = ListItemGameBinding.inflate( LayoutInflater.from(parent.context), parent, false )
        return GameHolder(binding)

    }

    override fun onBindViewHolder(holder: GameHolder, position: Int) {
        val game = games[position]
        holder.bind(game, clickListener)
    }

}