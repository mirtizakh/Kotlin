package sealed_class

// Sealed classes are used for managing state
// Like abstract classes sealed class allow you to represent hierarchies.
// The child class can be any type of class a data class , object class , regular class or even another sealed class.
// But unlike abstract classes you have to define the hierarchies in the same package
// Allows exhaustive when check , No need for else branch

sealed class Result<out T : Any> {
     class Success<out T : Any>(val data: T) : Result<T>()
     class Error(val e: Exception) : Result<Nothing>()
    object InProgress : Result<Nothing>()
}
// OR

sealed class Result2<out T : Any> {}
data class Success2<out T : Any>(val data: T) : Result2<T>()
data class Error2<out T : Any>(val e: Exception) : Result2<Nothing>()

// abstract class

abstract class Result3<out T : Any> {}
    data class Success3<out T : Any>(val data: T) : Result3<T>()
    data class Error3<out T : Any>(val e: Exception) : Result3<Nothing>()

private fun applyCondition(result :Result<Int>){
     val answer = when(result){
        is Result.Success -> { }
        is Result.Error -> { }
         Result.InProgress -> TODO()
     }
}

private fun applyCondition2(result :Result<Int>){
    when(result){
        is Result.Success -> { }
        is Result.Error -> { }
        Result.InProgress -> TODO()
    }.exhaustive
}

val <T> T.exhaustive : T
    get() = this
//------------------------------------------------------------------

sealed class Yarn {
    class Cotton : Yarn()
    open class Wool : Yarn()
}

class Merico : Yarn.Wool()

private fun applyCondition3(result :Yarn){
    // There are only 2 possibilities for the Yarn class
    val yarn = when(result){
        is Yarn.Cotton -> TODO()
        is Yarn.Wool -> TODO()
    }
}

sealed class Yarnn {
    class Cotton : Yarnn()
    class Silk : Yarnn()
    sealed class Wool : Yarnn(){
        class Merico : Wool()
        class Alpaca :Wool()
    }
}

private fun applyCondition4(result :Yarnn){
    // Now we have all as cases
    val yarn = when(result){
        is Yarnn.Cotton -> TODO()
        is Yarnn.Silk -> TODO()
        is Yarnn.Wool.Alpaca -> TODO()
        is Yarnn.Wool.Merico -> TODO()
    }

    // Also

    val yarn2 = when(result){
        is Yarnn.Cotton -> TODO()
        is Yarnn.Silk -> TODO()
        is Yarnn.Wool-> TODO()
    }
}


sealed class Yarnnn {
    class Cotton : Yarnnn()
    class Silk : Yarnnn()

}

sealed class Wool : Yarnnn(){
    class Merico : Wool()
    class Alpaca :Wool()
}

private fun applyCondition4(result :Yarnnn) {
    // Now we have all as cases
    val yarn = when (result) {
        is Yarnnn.Cotton -> TODO()
        is Yarnnn.Silk -> TODO()
        is Wool.Alpaca -> TODO()
        is Wool.Merico -> TODO()
    }
    // Also

    val yarn2 = when(result){
        is Yarnnn.Cotton -> TODO()
        is Yarnnn.Silk -> TODO()
        is Wool -> TODO()
    }
}

