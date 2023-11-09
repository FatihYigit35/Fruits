package app.web.valiantsoftware.fruitsvegetablesnutsapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity("nuts")
data class Nuts(
    //Using @SerializedName, we match the variables in the json file with the variables in our class.
    //It may not be necessary to use variable names if they are the same.
    @ColumnInfo("name")
    @SerializedName("name")
    override val name: String?,

    @ColumnInfo("description")
    @SerializedName("description")
    override val description: String?,

    @ColumnInfo("calories")
    @SerializedName("calories")
    override val calories: String?,

    @ColumnInfo("carbohydrate")
    @SerializedName("carbohydrate")
    override val carbohydrate: String?,

    @ColumnInfo("protein")
    @SerializedName("protein")
    override val protein: String?,

    @ColumnInfo("fat")
    @SerializedName("fat")
    override val fat: String?,

    @ColumnInfo("vitamins")
    @SerializedName("vitamins")
    override val vitamins: String?,

    @ColumnInfo("image")
    @SerializedName("image")
    override val image: String?
) : Foods(name, description, calories, carbohydrate, protein, fat, vitamins, image) {
    @PrimaryKey(autoGenerate = true)
    override var uuid: Int = 0
}