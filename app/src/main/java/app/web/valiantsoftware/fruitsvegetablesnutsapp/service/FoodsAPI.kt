package app.web.valiantsoftware.fruitsvegetablesnutsapp.service

import app.web.valiantsoftware.fruitsvegetablesnutsapp.model.Fruit
import app.web.valiantsoftware.fruitsvegetablesnutsapp.model.Nuts
import app.web.valiantsoftware.fruitsvegetablesnutsapp.model.Vegetable
import io.reactivex.Single
import retrofit2.http.GET


interface FoodsAPI {
    @GET("Fruits/fruits_EN.json")
    fun getFruitsWithEN(): Single<List<Fruit>>

    @GET("Fruits/fruits_TR.json")
    fun getFruitsWithTR(): Single<List<Fruit>>

    @GET("Fruits/fruits_EN.json") //TODO: Change json name
    fun getVegetablesWithEN(): Single<List<Vegetable>>

    @GET("Fruits/fruits_TR.json") //TODO: Change json name
    fun getVegetablesWithTR(): Single<List<Vegetable>>

    @GET("Fruits/fruits_EN.json") //TODO: Change json name
    fun getNutsWithEN(): Single<List<Nuts>>

    @GET("Fruits/fruits_TR.json") //TODO: Change json name
    fun getNutsWithTR(): Single<List<Nuts>>
}