package com.csci448.trentdouglas.trentdouglas_a2.fragments

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.csci448.trentdouglas.trentdouglas_a2.R
import com.csci448.trentdouglas.trentdouglas_a2.databinding.GameFragmentBinding
import com.csci448.trentdouglas.trentdouglas_a2.databinding.WelcomeFragmentBinding

class Game_Fragment: Fragment() {
    private var _binding: GameFragmentBinding? = null

    var used_list = mutableListOf(false, false, false, false, false, false, false, false, false)

    var player_chose = mutableListOf<Int>()
    var computer_chose = mutableListOf<Int>()
    var player_wins = false
    var computer_wins = false
    var game_over = false

    // This property is only valid between onCreateView and onDestroyView
    private val binding get() = _binding!!
    private val LOG_TAG = "A2 game fragment "
    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = GameFragmentBinding.inflate(inflater, container, false)
        used_list = mutableListOf(false, false, false, false, false, false, false, false, false)
        binding.one.setOnClickListener {
            if(!game_over) {
                if (!used_list[0]) {
                    binding.one.background = resources.getDrawable(R.drawable.ex)
                    used_list[0] = true
                    player_chose.add(0)
                    check_for_win()
                    computer_play()
                }
            }
        }
        binding.two.setOnClickListener {
            if(!game_over){
                if(!used_list[1]){
                    binding.two.background = resources.getDrawable(R.drawable.ex)
                    used_list[1] = true
                    player_chose.add(1)
                    check_for_win()
                    computer_play()
                }
            }

        }
        binding.three.setOnClickListener {
            if(!game_over){
                if(!used_list[2]){
                    binding.three.background = resources.getDrawable(R.drawable.ex)
                    used_list[2] = true
                    player_chose.add(2)
                    check_for_win()
                    computer_play()
                }
            }

        }
        binding.four.setOnClickListener {
            if(!game_over){
                if(!used_list[3]){
                    binding.four.background = resources.getDrawable(R.drawable.ex)
                    used_list[3] = true
                    player_chose.add(3)
                    check_for_win()
                    computer_play()
                }
            }

        }
        binding.five.setOnClickListener {
            if(!game_over){
                if(!used_list[4]){
                    binding.five.background = resources.getDrawable(R.drawable.ex)
                    used_list[4] = true
                    player_chose.add(4)
                    check_for_win()
                    computer_play()
                }
            }

        }
        binding.six.setOnClickListener {
            if(!game_over){
                if(!used_list[5]){
                    binding.six.background = resources.getDrawable(R.drawable.ex)
                    used_list[5] = true
                    player_chose.add(5)
                    check_for_win()
                    computer_play()
                }
            }

        }
        binding.seven.setOnClickListener {
            if(!game_over){
                if(!used_list[6]){
                    binding.seven.background = resources.getDrawable(R.drawable.ex)
                    used_list[6] = true
                    player_chose.add(6)
                    check_for_win()
                    computer_play()
                }
            }

        }
        binding.eight.setOnClickListener {
            if(!game_over){
                if(!used_list[7]){
                    binding.eight.background = resources.getDrawable(R.drawable.ex)
                    used_list[7] = true
                    player_chose.add(7)
                    check_for_win()

                    computer_play()
                }
            }

        }
        binding.nine.setOnClickListener {
            if(!game_over){
                if(!used_list[8]){
                    binding.nine.background = resources.getDrawable(R.drawable.ex)
                    used_list[8] = true
                    player_chose.add(8)
                    check_for_win()
                    computer_play()
                }
            }

        }




        return binding.root
    }

    fun check_for_win(){
        if(player_chose.contains(0) && player_chose.contains(1) && player_chose.contains(2)) player_wins = true
        if(player_chose.contains(3) && player_chose.contains(4) && player_chose.contains(5)) player_wins = true
        if(player_chose.contains(6) && player_chose.contains(7) && player_chose.contains(8)) player_wins = true
        if(player_chose.contains(0) && player_chose.contains(3) && player_chose.contains(6)) player_wins = true
        if(player_chose.contains(1) && player_chose.contains(4) && player_chose.contains(7)) player_wins = true
        if(player_chose.contains(2) && player_chose.contains(5) && player_chose.contains(8)) player_wins = true
        if(player_chose.contains(0) && player_chose.contains(4) && player_chose.contains(8)) player_wins = true
        if(player_chose.contains(6) && player_chose.contains(4) && player_chose.contains(2)) player_wins = true

        if(computer_chose.contains(0) && computer_chose.contains(1) && computer_chose.contains(2)) computer_wins = true
        if(computer_chose.contains(3) && computer_chose.contains(4) && computer_chose.contains(5)) computer_wins = true
        if(computer_chose.contains(6) && computer_chose.contains(7) && computer_chose.contains(8)) computer_wins = true
        if(computer_chose.contains(0) && computer_chose.contains(3) && computer_chose.contains(6)) computer_wins = true
        if(computer_chose.contains(1) && computer_chose.contains(4) && computer_chose.contains(7)) computer_wins = true
        if(computer_chose.contains(2) && computer_chose.contains(5) && computer_chose.contains(8)) computer_wins = true
        if(computer_chose.contains(0) && computer_chose.contains(4) && computer_chose.contains(8)) computer_wins = true
        if(computer_chose.contains(6) && computer_chose.contains(4) && computer_chose.contains(2)) computer_wins = true

        if(player_wins){
            Toast.makeText(requireContext(), "Player Wins!", Toast.LENGTH_SHORT).show()
            game_over = true
        }
        if(computer_wins){
            Toast.makeText(requireContext(), "Computer Wins!", Toast.LENGTH_SHORT).show()
            game_over = true
        }

    }


    fun computer_play(){
        if(!game_over) {
            var count = 0
            var used_count = 0
            while (count < 9) {
                if (used_list[count]) {
                    used_count++
                }
                count++
            }
            if (used_count == 9) return

            var choice = (0..8).random()
            while (used_list[choice]) {
                choice = (0..8).random()
            }
            if (choice == 0) {
                binding.one.background = resources.getDrawable(R.drawable.oh)
                used_list[0] = true
                computer_chose.add(0)
            }
            if (choice == 1) {
                binding.two.background = resources.getDrawable(R.drawable.oh)
                used_list[1] = true
                computer_chose.add(1)
            }
            if (choice == 2) {
                binding.three.background = resources.getDrawable(R.drawable.oh)
                used_list[2] = true
                computer_chose.add(2)
            }
            if (choice == 3) {
                binding.four.background = resources.getDrawable(R.drawable.oh)
                used_list[3] = true
                computer_chose.add(3)
            }
            if (choice == 4) {
                binding.five.background = resources.getDrawable(R.drawable.oh)
                used_list[4] = true
                computer_chose.add(4)
            }
            if (choice == 5) {
                binding.six.background = resources.getDrawable(R.drawable.oh)
                used_list[5] = true
                computer_chose.add(5)
            }
            if (choice == 6) {
                binding.seven.background = resources.getDrawable(R.drawable.oh)
                used_list[6] = true
                computer_chose.add(6)
            }
            if (choice == 7) {
                binding.eight.background = resources.getDrawable(R.drawable.oh)
                used_list[7] = true
                computer_chose.add(7)
            }
            if (choice == 8) {
                binding.nine.background = resources.getDrawable(R.drawable.oh)
                used_list[8] = true
                computer_chose.add(8)
            }
            check_for_win()
        }
    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    override fun onAttach(context: Context){
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        Log.d(LOG_TAG, "onCreateOptionsMenu() called")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }


    override fun onStart(){
        super.onStart()
    }


    override fun onResume(){
        Log.d(LOG_TAG, "onResume() called")
        super.onResume()
    }
    override fun onPause(){
        Log.d(LOG_TAG, "onPause() called")
        super.onPause()
    }
    override fun onStop(){
        Log.d(LOG_TAG, "onStop() called")
        super.onStop()
    }

    override fun onDestroy(){
        Log.d(LOG_TAG, "onDestroy() called")
        super.onDestroy()
    }
    override fun onDetach(){
        Log.d(LOG_TAG, "onDetach() called")
        super.onDetach()
    }


}
