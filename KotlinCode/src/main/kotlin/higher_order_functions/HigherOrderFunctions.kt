package higher_order_functions

typealias IntMapper = (Int) -> Int

fun calculate(param: Int, operation: IntMapper): Int {
    return operation(param)
}