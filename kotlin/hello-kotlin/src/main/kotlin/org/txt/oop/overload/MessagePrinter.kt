package org.txt.hello.org.txt.oop.overload

class MessagePrinter {
    fun printMessage(message: String, times: Int, prefix: String = "Info") {
        repeat(times) {
            println("[$prefix]: $message")
        }
    }
}

class MessagePrinter2 {
    fun printMessage(message: String, times: Int, prefix: String = "Info") {
        repeat(times) {
            println("[$prefix]: $message")
        }
    }
}

fun main() {
    val printer = MessagePrinter()
    // Phải truyền times vì nó không có giá trị mặc định
    printer.printMessage("Hello", 1)
    printer.printMessage("Error", 1, "Alert")
    printer.printMessage("Ping", 3)

    val printer2 = MessagePrinter2()
    printer2.printMessage(message = "Hello", times = 1)
    printer2.printMessage(message = "Error", prefix = "Alert", times = 1)
    printer2.printMessage(message = "Ping", times = 3)
}
