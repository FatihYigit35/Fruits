package app.web.valiantsoftware.fruitsvegetablesnutsapp.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import app.web.valiantsoftware.fruitsvegetablesnutsapp.model.Fruit
import app.web.valiantsoftware.fruitsvegetablesnutsapp.service.AppDatabase
import app.web.valiantsoftware.fruitsvegetablesnutsapp.service.FoodsAPIService
import app.web.valiantsoftware.fruitsvegetablesnutsapp.util.AppSharedPreferences
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

class FruitsViewModel(application: Application) : BaseViewModel(application) {
    val fruitsLiveData = MutableLiveData<List<Fruit>>()
    val errorMessageLiveData = MutableLiveData<Boolean>()
    val progressBarLiveData = MutableLiveData<Boolean>()
    private val fruitApiService = FoodsAPIService()
    private val disposable = CompositeDisposable()
    private val sharedPreferences = AppSharedPreferences(getApplication())
    private val nanoTimeToMinutes = 60 * 1000 * 1000 * 1000L
    private val refreshTime = 30 * nanoTimeToMinutes

    fun refreshData() {
        val savedTime = sharedPreferences.getTimeFruit()
        if (savedTime != null && savedTime != 0L && System.nanoTime() - savedTime < refreshTime) {
            getDataFromRoom()
        } else {
            getDataFromRetrofit()
        }
    }

    fun refreshFromInternet() {
        getDataFromRetrofit()
    }

    private fun getDataFromRetrofit() {
        progressBarLiveData.value = true

        disposable.add(
            fruitApiService
                .getFruitsWithEN()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Fruit>>() {
                    override fun onSuccess(t: List<Fruit>) {
                        insertFruitsToRoom(t)
                        Toast.makeText(
                            getApplication(),
                            "Data came from the internet.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    override fun onError(e: Throwable) {
                        errorMessageLiveData.value = true
                        progressBarLiveData.value = false
                        e.printStackTrace()
                    }
                })
        )
    }

    private fun getDataFromRoom() {
        progressBarLiveData.value = true

        launch {
            val dao = AppDatabase(getApplication()).fruitDao()
            val fruitsList = dao.getAllFruit()
            showFruits(fruitsList)
            Toast.makeText(getApplication(), "Data came from local database", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun showFruits(fruits: List<Fruit>) {
        fruitsLiveData.value = fruits
        errorMessageLiveData.value = false
        progressBarLiveData.value = false
    }

    private fun insertFruitsToRoom(fruits: List<Fruit>) {
        launch {
            val dao = AppDatabase(getApplication()).fruitDao()
            dao.deleteAllFruit()
            dao.insertAll(*fruits.toTypedArray())
            showFruits(dao.getAllFruit())
        }

        sharedPreferences.saveTimeFruit(System.nanoTime())
    }
}