package com.csci448.trentdouglas.trentdouglas_a2.fragments
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.preference.Preference
import androidx.preference.Preference.OnPreferenceClickListener
import androidx.preference.PreferenceFragmentCompat
import com.csci448.trentdouglas.trentdouglas_a2.R
import com.csci448.trentdouglas.trentdouglas_a2.repo.GameRepository


class Settings_Fragment: PreferenceFragmentCompat() {

    private lateinit var sharedPref:SharedPreferences
    private lateinit var clearData:Preference
    private val LOG_TAG = "testing"

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        val gameRepository: GameRepository = GameRepository.getInstance(requireContext())
        setPreferencesFromResource(R.xml.preferences, rootKey)
        Log.d(LOG_TAG, ".........................started...............................")

        preferenceManager.findPreference<Preference>("clear_data")!!.onPreferenceClickListener =
            OnPreferenceClickListener {
                gameRepository.clearData()
                Log.d(LOG_TAG, ".........................cleared...............................")

                true
            }

    }



    //override fun onSharedPreferenceChanged()

}