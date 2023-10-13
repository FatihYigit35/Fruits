package app.web.valiantsoftware.fruits.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.web.valiantsoftware.fruits.model.Fruit
import app.web.valiantsoftware.fruits.service.FruitAPIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class FruitsViewModel : ViewModel() {
    val fruitsLiveData = MutableLiveData<List<Fruit>>()
    val errorMessageLiveData = MutableLiveData<Boolean>()
    val progressBarLiveData = MutableLiveData<Boolean>()
    private val fruitApiService = FruitAPIService()
    private val disposable = CompositeDisposable()

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
                        fruitsLiveData.value = t
                        errorMessageLiveData.value = false
                        progressBarLiveData.value = false
                    }

                    override fun onError(e: Throwable) {
                        errorMessageLiveData.value = true
                        progressBarLiveData.value = false
                        e.printStackTrace()
                    }

                })
        )
    }
}