package app.web.valiantsoftware.fruits.util

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.preference.PreferenceManager

class AppSharedPreferences {
    companion object {
        private var sharedPreferences: SharedPreferences? = null
        private var TIMEKEY = "last_refresh_time"

        @Volatile
        private var instance: AppSharedPreferences? = null

        private val lock = Any()
        operator fun invoke(context: Context): AppSharedPreferences =
            instance ?: synchronized(lock) {
                instance ?: createSharedPreferences(context).also {
                    instance = it
                }
            }

        private fun createSharedPreferences(context: Context): AppSharedPreferences {
            sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            return AppSharedPreferences()
        }
    }

    fun saveTime(time: Long) {
        sharedPreferences?.edit(commit = true) {
            putLong(TIMEKEY, time)
        }
    }

    fun getTime() = sharedPreferences?.getLong(TIMEKEY,0)
}