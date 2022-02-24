package higher_order_functions

import enum.Days

typealias IntMapper = (Int) -> Int

fun calculate(param: Int, operation: IntMapper): Int {
    return operation(param)
}

// If you use more lambdas in your code objects are created

inline fun calculateInline(param: Int, operation:(Int) -> Int): Int {
    return operation(param)
}

  inline fun calculateNoInline(param: Int,  noinline operation:(Int) -> Int, ): Int {
    val o = operation
    return operation(param)
}
/* Why noinline because inline has restrictions
  1- You can inline when function type param is called or passed to other inline function.
  2- You cannot inline when function is being assigned to variable.
  because assigned function has to be part of an object.
  3- You should not inline long functions, think about generate byte code
 */

// Higher order function as extension function
inline fun Int.calculateSelf(operation:IntMapper) = operation(this)