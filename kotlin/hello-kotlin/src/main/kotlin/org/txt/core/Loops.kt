package org.txt.hello.org.txt.core

class Loops {
    fun ForLoop() {
        println("ForLoop:")
        println("Duyệt từ 1 đến 5 (bao gồm cả 5)")
        for (i in 1..5) {
            print("$i ") // Output: 1 2 3 4 5
        }

        println("\nDuyệt ngược từ 5 về 1 với bước nhảy là 2")
        for (i in 5 downTo 1 step 2) {
            print("$i ") // Output: 5 3 1
        }

        println("\nDuyệt đến 5 nhưng không bao gồm 5 (1, 2, 3, 4)")
        for (i in 1 until 5) { /*...*/
            print("$i ")
        }
    }

    fun WhileLoop() {
        println("\n\nWhileLoop:")
        var x = 3
        while (x > 0) {
            println(x--)
        }
    }
}

fun main() {
    val forLoop = Loops()
    forLoop.ForLoop()
    forLoop.WhileLoop()
}
