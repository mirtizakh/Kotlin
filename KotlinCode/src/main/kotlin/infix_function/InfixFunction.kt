package infix_function

class InfixFunction {

    // Kotlin allows some functions to be called without using the period and brackets. These are called infix methods,
    // Omitting dot and parentheses.

    val countryCities: Map<String, String> = mapOf(
        "Pakistan" to "Islamabad",
        "China" to "Beijing",
        "Bangladesh" to "Dhaka"
    )

    // You can even write like this

    val countryCities2: Map<String, String> = mapOf(
        "Pakistan".to("Islamabad"),
        "China".to("Beijing"),
        "Bangladesh".to("Dhaka")
    )

    // What's really happening

    val countryCities3: Map<String, String> = mapOf(
        Pair("Pakistan", "Islamabad"),
        Pair("China", "Beijing"),
        Pair("Bangladesh", "Dhaka")
    )

     infix fun <T> List<T>.combineWith(otherList: List<T>): List<T> {
        val combinedList = mutableListOf<T>()
        combinedList.addAll(this)
        combinedList.addAll(otherList)
        return combinedList
    }

    val completeList = listOf(1,2,3).combineWith(listOf(4,5,6))

    // or we can write like
    val completeList2 = listOf(1,2,3) combineWith listOf(4,5,6)

    // Better approach to combine list

    infix fun <T> List<T>.improvedCombineWith(otherList: List<T>): List<T> {
        return this + otherList
    }

    /* Note

     1- Must be a member function or extension function

     2- Must have single parentheses (no vararg , no default value)

     */
}