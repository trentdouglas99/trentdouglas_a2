package com.csci448.trentdouglas.trentdouglas_a2.fragments

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.csci448.trentdouglas.trentdouglas_a2.Game
import com.csci448.trentdouglas.trentdouglas_a2.R
import com.csci448.trentdouglas.trentdouglas_a2.databinding.FragmentListBinding
import com.csci448.trentdouglas.trentdouglas_a2.databinding.GameFragmentBinding
import com.csci448.trentdouglas.trentdouglas_a2.databinding.HistoryFragmentBinding

class History_Fragment: Fragment() {

    private var _binding: FragmentListBinding? = null
    // This property is only valid between onCreateView and onDestroyView
    private val binding get() = _binding!!
    private lateinit var historyListViewModel: HistoryListViewModel

    private lateinit var adapter: HistoryListAdapter
    private val LOG_TAG = "A2 history fragment "
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        _binding = FragmentListBinding.inflate(inflater, container, false)
//        return binding.root
//    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        Log.d(LOG_TAG, "onCreateView() called")
        _binding = FragmentListBinding.inflate(inflater, container, false)

        binding.gameListRecyclerView.layoutManager = LinearLayoutManager(context)



        updateUI(emptyList())

        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        Log.d(LOG_TAG, "onViewCreated() called")
        super.onViewCreated(view, savedInstanceState)
        historyListViewModel.gameListLiveData.observe(
            viewLifecycleOwner,
            Observer { games ->
                games?.let{
                    Log.i(LOG_TAG, "Got games ${games.size}")
                    updateUI(games)
                }
            }
        )
    }
    private fun updateUI(games: List<Game>) {
        //adapter = HistoryListAdapter(games) { game: Game ->
            //val action = CrimeListFragmentDirections.actionCrimeListFragmentToCrimeDetailFragment(crime.id)
            //findNavController().navigate(action)

        //}

        adapter = HistoryListAdapter(games, context)
        binding.gameListRecyclerView.adapter = adapter
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.d(LOG_TAG, "onOptionsItemSelected() called")

        if (item.itemId == R.id.play_game) {
            val action = History_FragmentDirections.actionHistoryFragmentToGameFragment()
            findNavController().navigate(action)
            return true
        }
        if (item.itemId == R.id.preferences) {
            val action = History_FragmentDirections.actionHistoryFragmentToSettingsFragment()
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







    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        val factory = HistoryListViewModelFactory(requireContext())
        historyListViewModel = ViewModelProvider(this@History_Fragment, factory).get(HistoryListViewModel::class.java)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        Log.d(LOG_TAG, "onCreateOptionsMenu() called")
        inflater.inflate(R.menu.fragment_menu_bar_no_history, menu)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?){
        Log.d(LOG_TAG, "onActivityCreated() called")
        super.onActivityCreated(savedInstanceState)
    }
    override fun onStart(){
        Log.d(LOG_TAG, "onStart() called")
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
    override fun onDestroyView(){
        Log.d(LOG_TAG, "onDestroyView() called")
        super.onDestroyView()
    }
    override fun onDestroy(){
        Log.d(LOG_TAG, "onDestroy() called")
        super.onDestroy()
        _binding = null
    }
    override fun onDetach(){
        Log.d(LOG_TAG, "onDetach() called")
        super.onDetach()
    }
}