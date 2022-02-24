package extension_functions

/*
If a class has a member function, and an extension function is defined which has the same receiver type,
the same name, and is applicable to given arguments, the member always wins. For example:
 */

class Example {
    fun printFunctionType() { println("Class method") }
}

fun Example.printFunctionType() { println("Extension function") }

 var example1: Example?=null
fun main() {
    val example = Example()
    example.printFunctionType()  // --> "Class method"

    println(example1.toString())
}
// Nullable receiver

//fun Any?.toString(): String {
//    if (this == null) return "null"
//    // after the null check, 'this' is autocast to a non-null type, so the toString() below
//    // resolves to the member function of the Any class
//    return toString()
//}

