//package extension_functions
//
//// Declaring extensions as members
//
///*
//You can declare extensions for one class inside another class. Inside such an extension, there are multiple implicit receivers -
// objects whose members can be accessed without a qualifier. An instance of a class in which the extension is declared is called
// a dispatch receiver, and an instance of the receiver type of the extension method is called an extension receiver.
// */
//
//class Host(val hostname: String) {
//    fun printHostname() { print(hostname) }
//}
//
//class Connection(val host: Host, val port: Int) {
//    fun printPort() { print(port) }
//    fun printHostname() { print("xyz")
//
//    fun Host.printConnectionString() {
//        printHostname()   // calls Host.printHostname()
//        print(":")
//        printPort()   // calls Connection.printPort()
//        this@Connection.printHostname()
//    }
//
//    fun connect() {
//        /*...*/
//        host.printConnectionString()   // calls the extension function
//    }
//}
//
////fun main() {
////    //Connection(Host("kotl.in"), 443).connect()
////   // Host("kotl.in").printConnectionString()  // error, the extension function is unavailable outside Connection
////}
//
///*
//In the event of a name conflict between the members of a dispatch receiver and an extension receiver, the extension
//receiver takes precedence. To refer to the member of the dispatch receiver, you can use the qualified this syntax.
// */
//
////class Connection2 {
////    fun Host.getConnectionString() {
////        toString()         // calls Host.toString()
////        this@Connection2.toString()  // calls Connection.toString()
////    }
////}