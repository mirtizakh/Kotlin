package string_immutable
fun main(){
   val stringTest = StringTest()
    stringTest.testString()
}

class  StringTest{
    fun testString(){
        val stringName = "Note Book"
        val stringBookName = "Note Book"
        val test2 = StringBuffer();
        test2.append("Note Book")
        val test = String(test2)

        val number = 123;
        // == works like equals in Java
        // === works like == in Java
        println("stringName == stringBookName ${stringName == stringBookName}")
        println("stringName equals stringBookName ${stringName.equals(stringBookName)}")
        println("stringName === stringBookName ${stringName === stringBookName}")
    }
}
class Data{

}
