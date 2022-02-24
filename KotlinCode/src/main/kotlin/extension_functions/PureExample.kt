package extension_functions

// --------------------------------------------------------------------------------------
class Person(private val name: String,
             val age: Int,
             val income: Int = 0){
    private fun test(){

    }
}

fun calculateDiscount(person: Person) : Int {
    return when {
        person.age > 65 -> 20
        person.age < 13 -> 10
        person.income > 1_000_000 -> 0
        else -> 5
    }
}

/*
This is fine but it’s not particularly great for readability. As our business logic grows, you can probably imagine this
 function becoming harder and harder to read. We’re also doing more than one thing here
  (a violation of the Single Responsibility Principle). The right side of the when expression is mapping discount amounts
  to certain classifications of Person. The left side of the when expression is evaluating if the Person instance meets those
  classifications.
 */

/*
It would be nicer if we could extract out each one of the boolean expressions on the left.
Each of these expressions such as person.age > 65 is a piece of logic by itself. We can express it better by giving it a name,
 and we can test it very easily if it wasn’t evaluated inline.
One option would be to move it to the Person class.
We’ll call these our “classification functions” for the rest of the example since they are classifying aspects of a person.
 */
// --------------------------------------------------------------------------------------

class Person2(private val name: String, val age: Int, val income: Int = 0) {

    fun over65(): Boolean {
        test()
        return age > 65
    }

    fun under13(): Boolean {
        return age < 13
    }

    fun isRich(): Boolean {
        return income > 1_000_000
    }

    private fun test(){

    }
}

fun calculateDiscount2(person: Person2) : Int  {
    return when {
        person.over65() -> 20
        person.under13() -> 10
        person.isRich() -> 0
        else -> 5
    }
}

// --------------------------------------------------------------------------------------
// all the code below is in the file DiscountCalculator.kt
class DiscountCalculator {
    fun calculateDiscount(person: Person) : Int  {
        return when {
            person.over65() -> 20
            person.under13() -> 10
            person.isRich() -> 0
            else -> 5
        }
    }
}

private fun Person.over65() : Boolean {
    return this.age > 65
}

private fun Person.under13() : Boolean {
    return this.age < 13
}

private fun Person.isRich() : Boolean {
    return this.income > 1_000_000
}

/*
Let’s take stock of the benefits of our extension function approach.
DiscountCalculator can see the classification functions like isRich()
isRich() can’t see the internals of DiscountCalculator
isRich() can’t see the internals of Person
isRich() is an easily testable, pure function
CouponEligibility can have a different meaning for isRich()
We’ve kept DiscountCalculator and CouponEligibility more decoupled by avoiding shared functions calls
calculateDiscount() is easy to read and expressive
calculateDiscount() is only doing one thing: mapping discounts to classifications
This business logic of classification such as isRich(), is grouped nearby where it is used in DiscountCalculator (functional cohesion)
 */

