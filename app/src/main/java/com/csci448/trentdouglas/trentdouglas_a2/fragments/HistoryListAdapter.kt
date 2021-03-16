package com.csci448.trentdouglas.trentdouglas_a2.fragments

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat.getColor
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.RecyclerView
import com.csci448.trentdouglas.trentdouglas_a2.Game
import com.csci448.trentdouglas.trentdouglas_a2.R
import com.csci448.trentdouglas.trentdouglas_a2.databinding.ListItemGameBinding

class HistoryListAdapter(private val games: List<Game>, private val context: Context?) : RecyclerView.Adapter<GameHolder>() {

    override fun getItemCount(): Int{
        return games.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameHolder {
        val binding = ListItemGameBinding.inflate( LayoutInflater.from(parent.context), parent, false )

        var sharedPref = PreferenceManager.getDefaultSharedPreferences(context)
        var darkMode = sharedPref.getBoolean("dark_mode", false)
        if(darkMode){
            if (context != null) {
                binding.background.setBackgroundColor(context.getResources().getColor(R.color.black))
            }
        }

        return GameHolder(binding)

    }

    override fun onBindViewHolder(holder: GameHolder, position: Int) {
        val game = games[position]
        holder.bind(game)
    }

}