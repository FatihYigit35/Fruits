package app.web.valiantsoftware.fruits.service

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import app.web.valiantsoftware.fruits.model.Fruit

@Database(entities = [Fruit::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun fruitDao(): FruitDAO

    //Singleton
    companion object {
        @Volatile //Needed for other Threads to access
        private var instance: AppDatabase? = null

        private val lock = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(lock) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext, AppDatabase::class.java, "app_database"
            ).build()
    }
}