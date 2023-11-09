package app.web.valiantsoftware.fruitsvegetablesnutsapp.service

import app.web.valiantsoftware.fruitsvegetablesnutsapp.model.Fruit
import app.web.valiantsoftware.fruitsvegetablesnutsapp.model.Nuts
import app.web.valiantsoftware.fruitsvegetablesnutsapp.model.Vegetable
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class FoodsAPIService {
    private val baseUrl = "https://raw.githubusercontent.com/FatihYigit35/JSONData/main/FruitsVegetablesNutsApp/"
    private val api =
        Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(FoodsAPI::class.java)

    fun getFruitsWithEN() : Single<List<Fruit>>{
        return api.getFruitsWithEN()
    }
    fun getFruitsWithTR() : Single<List<Fruit>>{
        return api.getFruitsWithTR()
    }
    fun getVegetablesWithEN() : Single<List<Vegetable>>{
        return api.getVegetablesWithEN()
    }
    fun getVegetablesWithTR() : Single<List<Vegetable>>{
        return api.getVegetablesWithTR()
    }
    fun getNutsWithEN() : Single<List<Nuts>>{
        return api.getNutsWithEN()
    }
    fun getNutsWithTR() : Single<List<Nuts>>{
        return api.getNutsWithTR()
    }
}