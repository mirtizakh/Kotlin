package enum

fun main(){
    val day = Days.SUNDAY

    for(i in Days.values()){
        println(i)
    }

    day.printFormattedDay()
}

enum class Days{
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY;

    fun printFormattedDay(){
        println("Day is $this")
    }
}