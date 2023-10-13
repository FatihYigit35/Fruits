package app.web.valiantsoftware.fruits.model

import com.google.gson.annotations.SerializedName

data class Fruit(
    //Using @SerializedName, we match the variables in the json file with the variables in our class.
    //It may not be necessary to use variable names if they are the same.
    @SerializedName("name")
    val name: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("calories")
    val calories: String?,
    @SerializedName("carbohydrate")
    val carbohydrate: String?,
    @SerializedName("protein")
    val protein: String?,
    @SerializedName("fat")
    val fat: String?,
    @SerializedName("image")
    val image: String?
) {}