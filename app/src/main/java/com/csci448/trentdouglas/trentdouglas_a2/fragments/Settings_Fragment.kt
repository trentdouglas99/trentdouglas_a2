package com.csci448.trentdouglas.trentdouglas_a2.fragments
import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.csci448.trentdouglas.trentdouglas_a2.R


class Settings_Fragment: PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)
    }

    //override fun onSharedPreferenceChanged()

}