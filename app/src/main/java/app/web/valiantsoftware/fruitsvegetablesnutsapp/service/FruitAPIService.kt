package app.web.valiantsoftware.fruitsvegetablesnutsapp.service

import app.web.valiantsoftware.fruitsvegetablesnutsapp.model.Fruit
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class FruitAPIService {
    //https://raw.githubusercontent.com/FatihYigit35/JSONDatas/main/FruitsApp/fruits.json
    //BASE_URL -> https://raw.githubusercontent.com/
    //FatihYigit35/JSONDatas/main/FruitsApp/fruits.json

    private val BASE_URL = "https://raw.githubusercontent.com/"
    private val api =
        Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(FruitAPI::class.java)

    fun getData() : Single<List<Fruit>>{
        return api.getFruit()
    }
}