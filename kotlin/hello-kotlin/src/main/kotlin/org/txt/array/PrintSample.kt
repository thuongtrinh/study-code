package org.txt.hello.org.txt.array

fun main() {
    val fruits = arrayOf("Apple", "Banana", "Cherry")

    // 1. Using a Lambda Expression (it refers to the current element)
    fruits.forEach { println(it) }

    // 2. Using an Explicit Name for the element
    fruits.forEach { fruit -> println(fruit) }

    // 3. Using a Method Reference (shorthand for println)
    fruits.forEach(::println)

    fruits.forEachIndexed { index, value ->
        println("Item at $index is $value")
    }
}