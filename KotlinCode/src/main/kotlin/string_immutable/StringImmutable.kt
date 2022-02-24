package string_immutable
fun main(){
   val stringTest = StringTest()
    stringTest.testString()
}

class  StringTest{
    fun testString(){
        val stringName = "Note Book"
        val stringBookName = "Note Book"

        // == works like equals in Java
        // === works like == in Java
        println("stringName == stringBookName ${stringName == stringBookName}")
        println("stringName equals stringBookName ${stringName.equals(stringBookName)}")
        println("stringName === stringBookName ${stringName === stringBookName}")
    }
}
