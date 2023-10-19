package app.web.valiantsoftware.fruits.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import app.web.valiantsoftware.fruits.model.Fruit
import app.web.valiantsoftware.fruits.service.AppDatabase
import kotlinx.coroutines.launch

class FruitDetailViewModel(application: Application) : BaseViewModel(application) {
    val fruitLiveData = MutableLiveData<Fruit>()
    fun getFruit(uuid: Int) {
        launch {
            val dao = AppDatabase(getApplication()).fruitDao()
            val fruit = dao.getFruit(uuid)
            fruitLiveData.value = fruit
        }

    }
}