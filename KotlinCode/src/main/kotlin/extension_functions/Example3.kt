package extension_functions

// Companion object extensions
/*
If a class has a companion object defined, you can also define extension functions and properties for the
 companion object. Just like regular members of the companion object, they can be called using only the class name as the qualifier:
 */

class MyClass {
    companion object { }  // will be called "Companion"
}

fun MyClass.Companion.printCompanion() { println("companion") }

fun main() {
    MyClass.printCompanion()
}