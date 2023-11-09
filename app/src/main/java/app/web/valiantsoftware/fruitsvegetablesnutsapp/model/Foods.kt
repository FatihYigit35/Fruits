package app.web.valiantsoftware.fruitsvegetablesnutsapp.model

abstract class Foods (
    open val name: String?,
    open val description: String?,
    open val calories: String?,
    open val carbohydrate: String?,
    open val protein: String?,
    open val fat: String?,
    open val vitamins: String?,
    open val image: String?
){
    open var uuid: Int = 0
}