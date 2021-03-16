package com.csci448.trentdouglas.trentdouglas_a2.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.core.content.ContextCompat.getColor
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.preference.PreferenceManager
import androidx.preference.PreferenceManager.getDefaultSharedPreferences
import com.csci448.trentdouglas.trentdouglas_a2.Game
import com.csci448.trentdouglas.trentdouglas_a2.R
import com.csci448.trentdouglas.trentdouglas_a2.databinding.GameFragmentBinding

class Game_Fragment: Fragment() {
    private var _binding: GameFragmentBinding? = null
    private var move = 1
    var used_list = mutableListOf(false, false, false, false, false, false, false, false, false)

    var player_chose = mutableListOf<Int>()
    var computer_chose = mutableListOf<Int>()
    var player_wins = false
    var computer_wins = false
    var game_over = false

    private lateinit var game_Fragment_View_Model: GameFragmentViewModel

    // This property is only valid between onCreateView and onDestroyView
    private val binding get() = _binding!!
    private val LOG_TAG = "A2 game fragment "
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        move = 1

        var sharedPref = getDefaultSharedPreferences(context)
        var darkMode = sharedPref.getBoolean("dark_mode", false)
        var smartJoe = sharedPref.getBoolean("smart_joe", false)


        _binding = GameFragmentBinding.inflate(inflater, container, false)

        if(darkMode){
            binding.background.setBackgroundColor(resources.getColor(R.color.black))
        }



        used_list = mutableListOf<Boolean>(false, false, false, false, false, false, false, false, false)
        binding.one.setOnClickListener {
            if(!game_over) {
                if (!used_list[0]) {
                    binding.one.background = resources.getDrawable(R.drawable.ex)
                    used_list[0] = true
                    player_chose.add(0)
                    check_for_win()
                    if(smartJoe) smart_joe_play()
                    else computer_play()

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
                    if(smartJoe) smart_joe_play()
                    else computer_play()

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
                    if(smartJoe) smart_joe_play()
                    else computer_play()

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
                    if(smartJoe) smart_joe_play()
                    else computer_play()

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
                    if(smartJoe) smart_joe_play()
                    else computer_play()

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
                    if(smartJoe) smart_joe_play()
                    else computer_play()

                }
            }

        }
        binding.seven.setOnClickListener {
            if(!game_over){
                if(!used_list[6]) {
                    binding.seven.background = resources.getDrawable(R.drawable.ex)
                    used_list[6] = true
                    player_chose.add(6)
                    check_for_win()
                    if(smartJoe) smart_joe_play()
                    else computer_play()
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
                    if(smartJoe) smart_joe_play()
                    else computer_play()

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
                    if(smartJoe) smart_joe_play()
                    else computer_play()

                }
            }

        }
        binding.back.setOnClickListener {
            val action = Game_FragmentDirections.actionGameFragmentToWelcomeFragment()
            findNavController().navigate(action)
        }
        binding.playAgain.setOnClickListener {
            val action = Game_FragmentDirections.actionGameFragmentSelf()
            findNavController().navigate(action)
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

        var count = 0
        var used_count = 0
        while (count < 9) {
            if (used_list[count]) {
                used_count++
            }
            count++
        }
        if (used_count == 9){
            Toast.makeText(requireContext(), "Draw!", Toast.LENGTH_SHORT).show()
            val game = Game()
            game_over = true
            game.winner = "Draw"
            game_Fragment_View_Model.addGame(game)
            binding.back.visibility = View.VISIBLE
            binding.playAgain.visibility = View.VISIBLE
        }


        if(player_wins){
            Toast.makeText(requireContext(), "Player Wins!", Toast.LENGTH_SHORT).show()
            val game = Game()
            game_over = true
            game.winner = "Player"
            game_Fragment_View_Model.addGame(game)
            binding.back.visibility = View.VISIBLE
            binding.playAgain.visibility = View.VISIBLE
        }
        if(computer_wins){
            var sharedPref = getDefaultSharedPreferences(context)
            var smartJoe = sharedPref.getBoolean("smart_joe", false)

            if(smartJoe) Toast.makeText(requireContext(), "Smart Joe Wins!", Toast.LENGTH_SHORT).show()
            else Toast.makeText(requireContext(), "Average Joe Wins!", Toast.LENGTH_SHORT).show()

            val game = Game()
            game_over = true

            if(smartJoe)game.winner = "Smart Joe"
            else game.winner = "Average Joe"
            game_Fragment_View_Model.addGame(game)
            binding.back.visibility = View.VISIBLE
            binding.playAgain.visibility = View.VISIBLE
        }

    }

    fun smart_joe_play(){
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

            var choice = 6


            if((player_chose.contains(3) || player_chose.contains(7)) && move == 2) choice = 8
            else if(player_chose.contains(3) && player_chose.contains(7) && move == 3) choice = 2
            else if(computer_chose.contains(6) && computer_chose.contains(8) && computer_chose.contains(2) && !player_chose.contains(4) && move == 4) choice = 4
            else if(computer_chose.contains(6) && computer_chose.contains(8) && computer_chose.contains(2) && !player_chose.contains(5) && move == 4) choice = 5

            else if(player_chose.contains(0) && move == 2) choice = 8
            else if(player_chose.contains(0) && player_chose.contains(7) && move == 3) choice = 2



            else if(player_chose.contains(5) && move == 2) choice = 8
            else if(player_chose.contains(5) && player_chose.contains(7) && move == 3) choice = 0
            else if(computer_chose.contains(0) && computer_chose.contains(8) && computer_chose.contains(2) && !player_chose.contains(3) && move == 4) choice = 3
            else if(computer_chose.contains(0) && computer_chose.contains(8) && computer_chose.contains(6) && !player_chose.contains(4) && move == 4) choice = 4

            else if(player_chose.contains(2) && move == 2) choice = 8
            else if(player_chose.contains(2) && player_chose.contains(7) && move == 3) choice = 0
            else if(computer_chose.contains(0) && computer_chose.contains(8) && computer_chose.contains(2) && !player_chose.contains(3) && move == 4) choice = 3
            else if(computer_chose.contains(0) && computer_chose.contains(8) && computer_chose.contains(6) && !player_chose.contains(4) && move == 4) choice = 4


            if(player_chose.contains(0) && player_chose.contains(1) && !computer_chose.contains(2)) choice = 2
            if(player_chose.contains(0) && player_chose.contains(2) && !computer_chose.contains(1)) choice = 1
            if(player_chose.contains(1) && player_chose.contains(2) && !computer_chose.contains(0)) choice = 0

            if(player_chose.contains(4) && player_chose.contains(5) && !computer_chose.contains(3)) choice = 3
            if(player_chose.contains(3) && player_chose.contains(5) && !computer_chose.contains(4)) choice = 4
            if(player_chose.contains(3) && player_chose.contains(4) && !computer_chose.contains(5)) choice = 5

            if(player_chose.contains(7) && player_chose.contains(8) && !computer_chose.contains(6)) choice = 6
            if(player_chose.contains(6) && player_chose.contains(8) && !computer_chose.contains(7)) choice = 7
            if(player_chose.contains(6) && player_chose.contains(7) && !computer_chose.contains(8)) choice = 8

            if(player_chose.contains(3) && player_chose.contains(6) && !computer_chose.contains(0)) choice = 0
            if(player_chose.contains(0) && player_chose.contains(6) && !computer_chose.contains(3)) choice = 3
            if(player_chose.contains(0) && player_chose.contains(3) && !computer_chose.contains(6)) choice = 6

            if(player_chose.contains(4) && player_chose.contains(7) && !computer_chose.contains(1)) choice = 1
            if(player_chose.contains(1) && player_chose.contains(7) && !computer_chose.contains(4)) choice = 4
            if(player_chose.contains(1) && player_chose.contains(4) && !computer_chose.contains(7)) choice = 7

            if(player_chose.contains(5) && player_chose.contains(8) && !computer_chose.contains(2)) choice = 2
            if(player_chose.contains(2) && player_chose.contains(8) && !computer_chose.contains(5)) choice = 5
            if(player_chose.contains(2) && player_chose.contains(5) && !computer_chose.contains(8)) choice = 8

            if(player_chose.contains(4) && player_chose.contains(8) && !computer_chose.contains(0)) choice = 0
            if(player_chose.contains(0) && player_chose.contains(8) && !computer_chose.contains(4)) choice = 4
            if(player_chose.contains(0) && player_chose.contains(4) && !computer_chose.contains(8)) choice = 8

            if(player_chose.contains(4) && player_chose.contains(2) && !computer_chose.contains(6)) choice = 6
            if(player_chose.contains(6) && player_chose.contains(2) && !computer_chose.contains(4)) choice = 4
            if(player_chose.contains(6) && player_chose.contains(4) && !computer_chose.contains(2)) choice = 2

            if(computer_chose.contains(6) && computer_chose.contains(8) && !player_chose.contains(7)) choice = 7
            if(computer_chose.contains(6) && computer_chose.contains(0) && !player_chose.contains(3)) choice = 3
            if(computer_chose.contains(6) && computer_chose.contains(2) && !player_chose.contains(4)) choice = 4
            if(computer_chose.contains(6) && computer_chose.contains(3) && !player_chose.contains(0)) choice = 0
            if(computer_chose.contains(6) && computer_chose.contains(4) && !player_chose.contains(2)) choice = 2
            if(computer_chose.contains(6) && computer_chose.contains(7) && !player_chose.contains(8)) choice = 8
            if(computer_chose.contains(2) && computer_chose.contains(8) && !player_chose.contains(5)) choice = 5


            else if(choice == 6 && move != 1){
                choice = (0..8).random()
                while (used_list[choice]) {
                    choice = (0..8).random()
                }
            }

            move++




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
        Log.d(LOG_TAG, "onDestroyView() called")
        _binding = null
    }


    override fun onAttach(context: Context){
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        val factory = GameFragmentViewModelFactory(requireContext())
        game_Fragment_View_Model = ViewModelProvider(this, factory).get(GameFragmentViewModel::class.java)

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
        var sharedPref = getDefaultSharedPreferences(context)
        var smartJoe = sharedPref.getBoolean("smart_joe", false)
        Log.d(LOG_TAG, "onResume()")
        game_over = game_Fragment_View_Model.gameOver
        used_list = game_Fragment_View_Model.games
        player_chose = game_Fragment_View_Model.playerChose
        computer_chose = game_Fragment_View_Model.computerChose
        if(smartJoe) smart_joe_play()

        if(game_over){
            binding.back.visibility = View.VISIBLE
            binding.playAgain.visibility = View.VISIBLE
        }

        for (index in player_chose){
            if(index == 0) binding.one.background = resources.getDrawable(R.drawable.ex)
            if(index == 1) binding.two.background = resources.getDrawable(R.drawable.ex)
            if(index == 2) binding.three.background = resources.getDrawable(R.drawable.ex)
            if(index == 3) binding.four.background = resources.getDrawable(R.drawable.ex)
            if(index == 4) binding.five.background = resources.getDrawable(R.drawable.ex)
            if(index == 5) binding.six.background = resources.getDrawable(R.drawable.ex)
            if(index == 6) binding.seven.background = resources.getDrawable(R.drawable.ex)
            if(index == 7) binding.eight.background = resources.getDrawable(R.drawable.ex)
            if(index == 8) binding.nine.background = resources.getDrawable(R.drawable.ex)
        }


        for (index in computer_chose){
            if(index == 0) binding.one.background = resources.getDrawable(R.drawable.oh)
            if(index == 1) binding.two.background = resources.getDrawable(R.drawable.oh)
            if(index == 2) binding.three.background = resources.getDrawable(R.drawable.oh)
            if(index == 3) binding.four.background = resources.getDrawable(R.drawable.oh)
            if(index == 4) binding.five.background = resources.getDrawable(R.drawable.oh)
            if(index == 5) binding.six.background = resources.getDrawable(R.drawable.oh)
            if(index == 6) binding.seven.background = resources.getDrawable(R.drawable.oh)
            if(index == 7) binding.eight.background = resources.getDrawable(R.drawable.oh)
            if(index == 8) binding.nine.background = resources.getDrawable(R.drawable.oh)
        }

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
        game_Fragment_View_Model.gameOver = game_over
        game_Fragment_View_Model.games = used_list
        game_Fragment_View_Model.playerChose = player_chose
        game_Fragment_View_Model.computerChose = computer_chose
        super.onDestroy()
    }
    override fun onDetach(){
        Log.d(LOG_TAG, "onDetach() called")
        super.onDetach()
    }


}
