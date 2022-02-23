package data_class

import sealed_class.Result2

//    https://www.programiz.com/kotlin-programming/data-class
//    https://www.callicoder.com/kotlin-data-classes/

data  class User(val name:String,val age:Int)

/*
Kotlin data class vs normal class.

A class represents some data "type" and its behaviour(s) so from that point of view data class isn't any different
than a class.
But there are certain behaviours and rules about a data class that makes it a bit different:
1- Calling toString() on a data class dumps a string with all its member properties.
2- It has componentN method that get member properties by their order n.
This was possible because the compiler generates componentN() functions all properties for a data class. For example:

    val u1 = User("John", 29)

    println(u1.component1())     // John
    println(u1.component2())     // 29

3- It has a copy method which takes the member properties as parameters for making a diff copy of the object.

      val a = User("John",20)
      val b = User("John",30)

      println(a == b) // false
      println(a.copy(age = b.age) == b) // true

4- A data class can not be open. Can't be inherited.
5- It can not be abstract.
6- It can not be nested, inner or sealed.
7- Although it can inherit, define abstract methods and implement interfaces.
8- Data class properties can be destructed into individual variables e.g val (name, address) = Person("name", "address")
You can destructure an object into a number of variables using destructing

    val u1 = User("John", 29)

    val (name, age) = u1
    println("name = $name")
    println("age = $age")

9- Pair(a, b) internally uses data class.
10- A data class generates the equals function (compare is not generated) based on the properties that are
 declared in the primary constructor.
 */