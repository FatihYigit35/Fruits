package app.web.valiantsoftware.fruits.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.web.valiantsoftware.fruits.model.Fruit

class FruitsViewModel: ViewModel() {
    val fruitsLiveData = MutableLiveData<List<Fruit>>()
    val errorMessageLiveData = MutableLiveData<Boolean>()
    val progressBarLiveData = MutableLiveData<Boolean>()

    fun refleshData(){
        val banana = Fruit(
            "Banana",
            "A banana is the common name for a type of fruit and also the name for the herbaceous plants that grow it. " +
                    "These plants belong to the genus Musa. " +
                    "They are native to the tropical region of southeast Asia.",
            "77",
            "23g",
            "1.1g",
            "0.3g",
            "https://raw.githubusercontent.com/FatihYigit35/JSONDatas/main/FruitsApp/banana.png")

        val walnut = Fruit(
            "Walnut",
            "Walnut trees, genus Juglans, are plants which mostly grow in the northern hemisphere. " +
                    "They can reach ten to forty metres (30-130 ft) in height. They are used for timber. " +
                    "The wood is very hard, and dark in color. It is mostly used in furniture.",
            "77",
            "23g",
            "1.1g",
            "0.3g",
            "https://raw.githubusercontent.com/FatihYigit35/JSONDatas/main/FruitsApp/banana.png")

        val apple = Fruit(
            "Apple",
            "An apple is the edible fruit of a number of trees, known for its juicy, green, or red fruits. " +
                    "The tree (Malus spp.) is grown worldwide. " +
                    "Its fruit is low-cost, popular, and common all over the earth.",
            "77",
            "23g",
            "1.1g",
            "0.3g",
            "https://raw.githubusercontent.com/FatihYigit35/JSONDatas/main/FruitsApp/banana.png")

        val fruitList = arrayListOf(banana,walnut,apple)
        fruitsLiveData.value = fruitList
        errorMessageLiveData.value = false
        progressBarLiveData.value = false

    }
}