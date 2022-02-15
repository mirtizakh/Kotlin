package sealed_class



sealed class Result<out T : Any> {
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val e: Exception) : Result<Nothing>()
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



// Like abstract classes sealed class allow you to represent hierarchies.
// The child class can be any type of class a data class , object class , regular class or even another sealed class.
// But unlike abstract classes you have to define the hierarchies in the same file

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

// var count: Int by Delegates.notNull<Int>()