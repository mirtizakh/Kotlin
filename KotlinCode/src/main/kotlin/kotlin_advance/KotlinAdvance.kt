package kotlin_advance

// A NOTE ABOUT SUBTYPES

// Subtype: A type "A" is a subtype of type "B" if "A" can be used anywhere "B" can
// E.g Cat is a subtype of animal because anywhere you need an animal
// a cat will suffice

// In simple cases, the type can be interchangeably with the class name
val str: String = "string" // <-- String is the class and the type

// But this quickly falls apart with nullables
val str2: String? = "string" // <-- String is the class, String? is the type


// In the simplest cases, classes can create two types
// With Collections, there can be near infinite

val call1: List<Int> = TODO()
val call2: List<String>? = TODO() // List is the class
val call3: List<List<Pair<Int,List<String>>>> = TODO()


/* Why is this cool? Well we have null safety, because you can
   only assign a value to something that is a super type of it
 */

val num: Number = Int.MAX_VALUE  // Number is a super type of Int
val nullableStr: String? = null
//val nonNullableStr: String = nullableStr  // Would not compile, because String? is not a subtype of String

