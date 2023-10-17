package app.web.valiantsoftware.fruits.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import app.web.valiantsoftware.fruits.model.Fruit
import app.web.valiantsoftware.fruits.service.AppDatabase
import app.web.valiantsoftware.fruits.service.FruitAPIService
import app.web.valiantsoftware.fruits.util.AppSharedPreferences
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

class FruitsViewModel(application: Application) : BaseViewModel(application) {
    val fruitsLiveData = MutableLiveData<List<Fruit>>()
    val errorMessageLiveData = MutableLiveData<Boolean>()
    val progressBarLiveData = MutableLiveData<Boolean>()
    private val fruitApiService = FruitAPIService()
    private val disposable = CompositeDisposable()
    private val sharedPreferences = AppSharedPreferences(getApplication())

    fun refreshData() {
        getDataFromRetrofit()
    }

    private fun getDataFromRetrofit() {
        progressBarLiveData.value = true

        disposable.add(
            fruitApiService
                .getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Fruit>>() {
                    override fun onSuccess(t: List<Fruit>) {
                        insertFruitsToRoom(t)
                    }

                    override fun onError(e: Throwable) {
                        errorMessageLiveData.value = true
                        progressBarLiveData.value = false
                        e.printStackTrace()
                    }

                })
        )
    }

    private fun showFruits(fruits: List<Fruit>){
        fruitsLiveData.value = fruits
        errorMessageLiveData.value = false
        progressBarLiveData.value = false
    }

    private fun insertFruitsToRoom(fruits: List<Fruit>){
        launch {
            val dao = AppDatabase(getApplication()).fruitDao()
            dao.deleteAllFruit()
            dao.insertAll(*fruits.toTypedArray())
            showFruits(dao.getAllFruit())
        }

        sharedPreferences.saveTime(System.nanoTime())
    }
}