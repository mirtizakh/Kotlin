package val_keyword

import kotlin.random.Random

fun main(){

    // val readable property

    val keyword = Keyword()

    println(keyword.weight)

    println(keyword.height)
    println(keyword.height)
}

class Keyword {
   val weight = 10;
   val height
   get() = Random.nextInt(5)
}