package app.web.valiantsoftware.fruits.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.web.valiantsoftware.fruits.model.Fruit

class FruitDetailViewModel : ViewModel() {
    val fruitLiveData = MutableLiveData<Fruit>()
    fun getFruit() {
        val banana = Fruit(
            "Banana",
            "A banana is the common name for a type of fruit and also the name for the herbaceous plants that grow it. " +
                    "These plants belong to the genus Musa. " +
                    "They are native to the tropical region of southeast Asia.",
            "77",
            "23g",
            "1.1g",
            "0.3g",
            "https://raw.githubusercontent.com/FatihYigit35/JSONDatas/main/FruitsApp/banana.png"
        )
        fruitLiveData.value = banana
    }
}