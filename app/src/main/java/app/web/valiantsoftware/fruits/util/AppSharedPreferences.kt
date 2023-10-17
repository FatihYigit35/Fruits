package app.web.valiantsoftware.fruits.util

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import androidx.core.content.edit
import androidx.preference.PreferenceManager
import app.web.valiantsoftware.fruits.R

class AppSharedPreferences {
    companion object {
        private var sharedPreferences: SharedPreferences? = null
        private var resources: Resources? = null


        @Volatile
        private var instance: AppSharedPreferences? = null

        private val lock = Any()
        operator fun invoke(context: Context): AppSharedPreferences = instance ?: synchronized(lock) {
            instance ?: createSharedPreferences(context).also {
                instance = it
            }
        }

        private fun createSharedPreferences(context: Context): AppSharedPreferences {
            sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            this.resources = context.resources
            return AppSharedPreferences()
        }
    }

    fun saveTime( time: Long){
        sharedPreferences?.edit(commit = true){
            putLong(resources?.getString(R.string.shared_preferences_key_time) ,time)
        }
    }
}