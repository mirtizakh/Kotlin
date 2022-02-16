package sealed_class

/* Enum class can't have generic type parameters
enum class EnumCar<out T:Any>
*/
enum class EnumCar
{
    BMW,
    AUDI,
    MERCEDES
}

/* Sealed class can have generic type parameters
sealed class SealedCar<out T:Any>
*/

sealed class SealedCar {
    object BMW : SealedCar()
    object Audi : SealedCar()
    object Mercedes : SealedCar()
}

/* Sealed classes can hold instance specific data

enum class EnumCar(val model:String)
{
    BMW("M5"),
    AUDI("M10"),
    MERCEDES("M20")
}

sealed class SealedCar (val model:String) {
    data class BMW (val model:String) : SealedCar(model)
    data class Audi (val model:String) : SealedCar(model)
    data class Mercedes (val model:String) : SealedCar(model)
}

* */


