package app.web.valiantsoftware.fruitsvegetablesnutsapp.util

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.preference.PreferenceManager

class AppSharedPreferences {
    companion object {
        private var sharedPreferences: SharedPreferences? = null
        private var TIMEKEYFRUIT = "last_refresh_time_fruit"
        private var TIMEKEYVEGETABLE = "last_refresh_time_vegetable"
        private var TIMEKEYNUTS = "last_refresh_time_nuts"

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

    fun saveTimeFruit(time: Long) {
        sharedPreferences?.edit(commit = true) {
            putLong(TIMEKEYFRUIT, time)
        }
    }

    fun getTimeFruit() = sharedPreferences?.getLong(TIMEKEYFRUIT,0)

    fun saveTimeVegetable(time: Long) {
        sharedPreferences?.edit(commit = true) {
            putLong(TIMEKEYVEGETABLE, time)
        }
    }

    fun getTimeVegetable() = sharedPreferences?.getLong(TIMEKEYVEGETABLE,0)

    fun saveTimeNuts(time: Long) {
        sharedPreferences?.edit(commit = true) {
            putLong(TIMEKEYNUTS, time)
        }
    }

    fun getTimenuts() = sharedPreferences?.getLong(TIMEKEYNUTS,0)
}