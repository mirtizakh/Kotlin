package operator_overloading

import java.lang.IndexOutOfBoundsException

data class NumericHolder(val a :Int , val b :Int): Comparable<NumericHolder> {

    // You can ignore this
    override fun compareTo(other: NumericHolder): Int {
        return (a + b).compareTo(other.a + other.b)
    }
}

// 1
operator fun NumericHolder.plus(other: NumericHolder): NumericHolder {
    return NumericHolder(this.a + other.a, this.b + other.b)
}

// We can do like
val added = NumericHolder(1,2) + NumericHolder(3,4)

// 2
operator fun NumericHolder.minus(other: NumericHolder): NumericHolder {
    return NumericHolder(this.a + other.a, this.b + other.b)
}

// We can do like
val subtract = NumericHolder(50,40) - NumericHolder(1,2)

// 3
operator fun NumericHolder.inc(): NumericHolder {
    return NumericHolder(this.a + 1, this.b + 1)
}

// We can do like
var holder = NumericHolder(1,2)
val increment = holder++


// 4
operator fun NumericHolder.get(index:Int): Int {
   return when(index){
       0 -> this.a
       1 -> this.b
       else -> throw IndexOutOfBoundsException()
   }
}

val sum = holder[0] + holder[1]

// 5

operator fun NumericHolder.contains(value:Int): Boolean {
    return a == value || b == value
}

val result = 5 in holder

// 6
// The invoke() operator allows instances of your classes to be called as functions.
operator fun NumericHolder.invoke() {
    println(this)
}

val invoked = holder()
//               ^ that's how lambda worked


val lambda: (Pair<String, Int>) -> Unit = { (key, value) ->
    println("key:$key - value:$value")
}

fun main() {
    lambda("id123" to 5)
}

// 7
/* Redundant since NumericHolder type is comparable already */

operator fun NumericHolder.compareTo(other:NumericHolder): Int {
    return this.compareTo(other)
}

val greater = added > subtract
val greaterEqual = added >= subtract
val less = added < subtract
val lessEqual = added <= subtract


// https://medium.com/mobile-app-development-publication/amused-by-and-in-operator-in-kotlin-2cc7838e64f8
fun checkRange()
{
    // For range we have the object to implement comparable
    val range = subtract..added

    for(r in range)
    {
      println(r)
    }
}

operator fun ClosedRange<NumericHolder>.iterator() =
    object : Iterator<NumericHolder>{
        var current = start
        override fun hasNext(): Boolean {
            return current < endInclusive
        }

        override fun next(): NumericHolder {
           return current++
        }
    }


