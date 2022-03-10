package extension_functions

// Extensions are resolved statically

open class Shape
class Rectangle: Shape()

fun Shape.getName() = "Shape"

fun Rectangle.getName() = "Rectangle"

fun printClassName(s: Shape) {
    println(s.getName())
}

fun main() {
    printClassName(Rectangle())  // --> It will print Shape , Extension function take parent class method as priority
    printClassName1(Rectangle1()) // --> It will print Rectangle
}

// On the other hand
open class Shape1 {
    open fun getName() = "Shape"
}
class Rectangle1: Shape1() {
    override fun getName() = "Rectangle"
}

fun printClassName1(s: Shape1) {
    println(s.getName())
}
