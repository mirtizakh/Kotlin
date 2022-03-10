package data_class

/*
While building any application, we often need to create classes whose primary purpose is to hold data/state.
 These classes generally contain the same old boilerplate code in the form of getters, setters, equals(),
  hashcode() and toString() methods.
 */

class CustomerRegular(var id: String?, var name: String?) {

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val customer = o as CustomerRegular
        if (if (id != null) id != customer.id else customer.id != null) return false
        return if (name != null) name == customer.name else customer.name == null
    }

    override fun hashCode(): Int {
        var result = if (id != null) id.hashCode() else 0
        result = 31 * result + if (name != null) name.hashCode() else 0
        return result
    }
}

// The above class is equal to below data class with 1 line of code
data class Customer(val id: Long, val name: String)


// 1. Data class’s equals() method

val customer1 = Customer(1, "John")
val customer2 = Customer(1, "John")

fun test(){

    customer1.equals(customer2)
}
// println(customer1.equals(customer2))  // Prints true

/*
You can also use Kotlin’s Structural equality operator == to check for equality.
The == operator internally calls the equals() method -

println(customer1 == customer2)  // Prints true
 */

// 2. Data class’s toString() method

val customer3 = Customer(2, "Robert")
/*
println("Customer Details : $customer")

# Output
Customer Details : Customer(id=2, name=Robert)
 */

// 3- Data Classes and Immutability: The copy() function
// We use data classes to create immutable value objects

/*
Although the properties of a data class can be mutable (declared using var), It’s strongly recommended
to use immutable properties (declared using val) so as to keep the instances of the data class immutable.

Immutable objects are easier to work with and reason about while working with multi-threaded applications.
Since they can not be modified after creation

Kotlin makes working with immutable data objects easier by automatically generating a copy() function
for all the data classes. You can use the copy() function to copy an existing object into a new object
and modify some of the properties while keeping the existing object unchanged.

The following example shows how copy() function can be used -
 */

val customer = Customer(3, "James")

/*
   Copies the customer object into a separate Object and updates the name.
   The existing customer object remains unchanged.
*/
val updatedCustomer = customer.copy(name = "James Altucher")
// println("Customer : $customer")
// println("Updated Customer : $updatedCustomer")

// 4. The componentN() functions

/* Kotlin also generates componentN() functions corresponding to all the properties declared in
the primary constructor of the data class.


For the Customer data class that we defined in the previous section,
Kotlin generates two componentN() functions - component1() and component2() corresponding to
the id and name properties -
*/
val customer4 = Customer(4, "Joseph")

// println(customer4.component1()) // Prints 4
// println(customer4.component2()) // Prints "Joseph"
/* The component functions enable us to use the so-called Destructuring Declaration in Kotlin.
 The Destructuring declaration syntax helps you destructure an object into a number of variables like this -
 */

val customer5 = Customer(4, "Joseph")

// Destructuring Declaration
// val (id, name) = customer5
// println("id = $id, name = $name")

/*
Requirements for Data Classes
Every Data Class in Kotlin needs to fulfill the following requirements -

1- The primary constructor must have at least one parameter
2- All the parameters declared in the primary constructor need to be marked as val or var.
   We can define variables in primary constructor of regular class without val or var but not in data class
3- Data classes cannot be abstract, open, sealed or inner.
Conclusion
Data classes help us avoid a lot of common boilerplate code and make the classes clean and concise.
 */


