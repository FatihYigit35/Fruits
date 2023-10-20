package app.web.valiantsoftware.fruitsvegetablesnutsapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity("fruit")
data class Fruit(

    //Using @SerializedName, we match the variables in the json file with the variables in our class.
    //It may not be necessary to use variable names if they are the same.
    @ColumnInfo("name")
    @SerializedName("name")
    val name: String?,

    @ColumnInfo("description")
    @SerializedName("description")
    val description: String?,

    @ColumnInfo("calories")
    @SerializedName("calories")
    val calories: String?,

    @ColumnInfo("carbohydrate")
    @SerializedName("carbohydrate")
    val carbohydrate: String?,

    @ColumnInfo("protein")
    @SerializedName("protein")
    val protein: String?,

    @ColumnInfo("fat")
    @SerializedName("fat")
    val fat: String?,

    @ColumnInfo("vitamins")
    @SerializedName("vitamins")
    val vitamins: String?,

    @ColumnInfo("image")
    @SerializedName("image")
    val image: String?
) {
    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0
}