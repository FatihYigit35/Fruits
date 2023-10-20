package app.web.valiantsoftware.fruitsvegetablesnutsapp.service

import app.web.valiantsoftware.fruitsvegetablesnutsapp.model.Fruit
import io.reactivex.Single
import retrofit2.http.GET


interface FruitAPI {
    //https://raw.githubusercontent.com/FatihYigit35/JSONDatas/main/FruitsApp/fruits.json
    //BASE_URL -> https://raw.githubusercontent.com/
    //FatihYigit35/JSONDatas/main/FruitsApp/fruits.json

    @GET("FatihYigit35/JSONDatas/main/FruitsVegetablesNutsApp/Fruits/fruits.json")
    fun getFruit(): Single<List<Fruit>>
}