package com.csci448.trentdouglas.trentdouglas_a2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.csci448.trentdouglas.trentdouglas_a2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        private const val LOG_TAG = "448.MainActivity"
    }
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)


//        val currentFragment = supportFragmentManager.findFragmentById(binding.fragmentContainer.id)
//        if (currentFragment == null) {
//            val fragment = welcome_fragment()
//            supportFragmentManager
//                .beginTransaction()
//                .add(binding.fragmentContainer.id, fragment)
//                .commit()
//        }


        val navHostFragment = supportFragmentManager.findFragmentById((binding).navHostFragment.id) as NavHostFragment
        NavigationUI.setupActionBarWithNavController(this, navHostFragment.navController)
    }


    override fun onSupportNavigateUp(): Boolean {
        return findNavController((binding as ActivityMainBinding).navHostFragment.id).navigateUp() || super.onSupportNavigateUp()
    }


    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "onResume() called")
    }

    override fun onPause() {
        Log.d(LOG_TAG, "onPause() called")
        super.onPause()
    }

    override fun onStop() {
        Log.d(LOG_TAG, "onStop() called")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(LOG_TAG, "onDestroy() called")
        super.onDestroy()
    }
}