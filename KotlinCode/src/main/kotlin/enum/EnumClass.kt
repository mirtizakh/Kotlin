package enum

import data_class.User

fun main(){
    val day = Days.SUNDAY

    for(i in Days.values()){
        println(i)
    }

    day.printFormattedDay()

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