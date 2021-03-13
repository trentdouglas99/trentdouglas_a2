package com.csci448.trentdouglas.trentdouglas_a2.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.csci448.trentdouglas.trentdouglas_a2.R
import com.csci448.trentdouglas.trentdouglas_a2.databinding.HistoryFragmentBinding
import com.csci448.trentdouglas.trentdouglas_a2.databinding.SettingsFragmentBinding

class Settings_Fragment: Fragment() {
    private var _binding: SettingsFragmentBinding? = null

    // This property is only valid between onCreateView and onDestroyView
    private val binding get() = _binding!!
    private val LOG_TAG = "A2 settings fragment "
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SettingsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.d(LOG_TAG, "onOptionsItemSelected() called")

        if (item.itemId == R.id.play_game) {
            val action = Settings_FragmentDirections.actionSettingsFragmentToGameFragment()
            findNavController().navigate(action)
            return true
        }
        if (item.itemId == R.id.history) {
            val action = Settings_FragmentDirections.actionSettingsFragmentToHistoryFragment()
            findNavController().navigate(action)
            return true
        }
        if (item.itemId == R.id.preferences) {
            val action = Settings_FragmentDirections.actionSettingsFragmentSelf()
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