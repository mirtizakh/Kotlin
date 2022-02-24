package enum

import data_class.User
import sealed_class.Result
import sealed_class.Result3

class User2(val name:String){

}
fun main(){
    val day = Days.SUNDAY

    for(i in Days.values()){
        println(i)
    }

    day.printFormattedDay()

    val user = User("ali",20);
    val user2 = User2("ali");
    user.age = 30;
}

enum class Days{
    SUNDAY{
        fun printFormattedDay2(){
            println("Day is $this")
        }
    },
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY;
    // enum functions
    fun printFormattedDay(){
        println("Day is $this")
    }
}