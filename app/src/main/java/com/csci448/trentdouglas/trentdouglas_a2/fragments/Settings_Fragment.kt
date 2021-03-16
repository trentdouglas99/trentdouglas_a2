package com.csci448.trentdouglas.trentdouglas_a2.fragments
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceManager
import com.csci448.trentdouglas.trentdouglas_a2.R


class Settings_Fragment: PreferenceFragmentCompat() {

    private lateinit var sharedPref:SharedPreferences

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)

    }





    //override fun onSharedPreferenceChanged()

}