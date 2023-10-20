package app.web.valiantsoftware.fruitsvegetablesnutsapp.service

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import app.web.valiantsoftware.fruitsvegetablesnutsapp.model.Fruit

@Dao
interface FruitDAO {
    @Insert
    suspend fun insertAll(vararg fruit: Fruit): List<Long>

    @Query("SELECT * FROM fruit")
    suspend fun getAllFruit(): List<Fruit>

    @Query("SELECT * FROM fruit WHERE uuid = :fruitId")
    suspend fun getFruit(fruitId: Int): Fruit

    @Query("DELETE FROM fruit")
    suspend fun deleteAllFruit()

    @Delete
    suspend fun deleteFruit(fruit: Fruit)
}