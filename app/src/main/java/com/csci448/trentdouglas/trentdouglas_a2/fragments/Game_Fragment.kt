package com.csci448.trentdouglas.trentdouglas_a2.fragments

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.csci448.trentdouglas.trentdouglas_a2.R
import com.csci448.trentdouglas.trentdouglas_a2.databinding.GameFragmentBinding
import com.csci448.trentdouglas.trentdouglas_a2.databinding.WelcomeFragmentBinding

class Game_Fragment: Fragment() {
    private var _binding: GameFragmentBinding? = null

    var used_list = mutableListOf(false, false, false, false, false, false, false, false, false)

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
            if(!used_list[0]){
                binding.one.background = resources.getDrawable(R.drawable.ex)
                used_list[0] = true
                computer_play()
            }
        }
        binding.two.setOnClickListener {
            if(!used_list[1]){
                binding.two.background = resources.getDrawable(R.drawable.ex)
                used_list[1] = true
                computer_play()
            }
        }
        binding.three.setOnClickListener {
            if(!used_list[2]){
                binding.three.background = resources.getDrawable(R.drawable.ex)
                used_list[2] = true
                computer_play()
            }
        }
        binding.four.setOnClickListener {
            if(!used_list[3]){
                binding.four.background = resources.getDrawable(R.drawable.ex)
                used_list[3] = true
                computer_play()
            }
        }
        binding.five.setOnClickListener {
            if(!used_list[4]){
                binding.five.background = resources.getDrawable(R.drawable.ex)
                used_list[4] = true
                computer_play()
            }
        }
        binding.six.setOnClickListener {
            if(!used_list[5]){
                binding.six.background = resources.getDrawable(R.drawable.ex)
                used_list[5] = true
                computer_play()
            }
        }
        binding.seven.setOnClickListener {
            if(!used_list[6]){
                binding.seven.background = resources.getDrawable(R.drawable.ex)
                used_list[6] = true
                computer_play()
            }
        }
        binding.eight.setOnClickListener {
            if(!used_list[7]){
                binding.eight.background = resources.getDrawable(R.drawable.ex)
                used_list[7] = true
                computer_play()
            }
        }
        binding.nine.setOnClickListener {
            if(!used_list[8]){
                binding.nine.background = resources.getDrawable(R.drawable.ex)
                used_list[8] = true
                computer_play()
            }
        }




        return binding.root
    }


    fun computer_play(){
        var count = 0
        var used_count = 0
        while (count < 9){
            if(used_list[count]){
                used_count++
            }
            count++
        }
        if(used_count == 9) return

        var choice = (0..8).random()
        while (used_list[choice]){
            choice = (0..8).random()
        }
        if(choice == 0) {
            binding.one.background = resources.getDrawable(R.drawable.oh)
            used_list[0] = true
        }
        if(choice == 1) {
            binding.two.background = resources.getDrawable(R.drawable.oh)
            used_list[1] = true
        }
        if(choice == 2) {
            binding.three.background = resources.getDrawable(R.drawable.oh)
            used_list[2] = true
        }
        if(choice == 3) {
            binding.four.background = resources.getDrawable(R.drawable.oh)
            used_list[3] = true
        }
        if(choice == 4) {
            binding.five.background = resources.getDrawable(R.drawable.oh)
            used_list[4] = true
        }
        if(choice == 5) {
            binding.six.background = resources.getDrawable(R.drawable.oh)
            used_list[5] = true
        }
        if(choice == 6) {
            binding.seven.background = resources.getDrawable(R.drawable.oh)
            used_list[6] = true
        }
        if(choice == 7) {
            binding.eight.background = resources.getDrawable(R.drawable.oh)
            used_list[7] = true
        }
        if(choice == 8) {
            binding.nine.background = resources.getDrawable(R.drawable.oh)
            used_list[8] = true
        }


    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.d(LOG_TAG, "onOptionsItemSelected() called")

        if (item.itemId == R.id.play_game) {
            val action = Game_FragmentDirections.actionGameFragmentSelf()
            findNavController().navigate(action)
            return true
        }
        if (item.itemId == R.id.history) {
            val action = Game_FragmentDirections.actionGameFragmentToHistoryFragment()
            findNavController().navigate(action)
            return true
        }
        if (item.itemId == R.id.preferences) {
            val action = Game_FragmentDirections.actionGameFragmentToSettingsFragment()
            findNavController().navigate(action)
            return true
        }
        if (item.itemId == R.id.exit) {
            //MainActivity.finish()
            System.exit(0);
            return true
        }
        return false

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
        inflater.inflate(R.menu.fragment_menu_bar, menu)
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
