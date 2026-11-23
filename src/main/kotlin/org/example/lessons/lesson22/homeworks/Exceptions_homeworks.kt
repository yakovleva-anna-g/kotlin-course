package org.example.lessons.lesson22.homeworks

//Воспроизвести фрагменты кода, которые могут привести к возникновению исключений:

// 1.NullPointerException

// 2.IndexOutOfBoundsException
// 3.ClassCastException
// 4.IllegalArgumentException
// 5.NumberFormatException
// 6.IllegalStateException
// 7.OutOfMemoryError
// 8.StackOverflowError
fun main() {
    // 1
    try {
        null!!
    } catch (e: NullPointerException) {
        println("It is NullPointerException! \uD83C\uDF89")
    }
// 2
    try {
        listOf("")[1]
    } catch (e: IndexOutOfBoundsException) {
        println("It is IndexOutOfBoundsException! \uD83C\uDF89")
    }
// 3
    try {
        "" as Int
    } catch (e: ClassCastException) {
        println("It is ClassCastException! \uD83C\uDF89")
    }
// 4
    try {
        require(false)
    } catch (e: IllegalArgumentException) {
        println("It is IllegalArgumentException! \uD83C\uDF89")
    }
// 5
    try {
        "".toInt()
    } catch (e: NumberFormatException) {
        println("It is NumberFormatException! \uD83C\uDF89")
    }
// 6
    try {
        check(false)
    } catch (e: IllegalStateException) {
        println("It is IllegalStateException! \uD83C\uDF89")
    }
// 7
    try {
        (0..Long.MAX_VALUE).map { Long.MAX_VALUE }
    } catch (e: OutOfMemoryError) {
        println("It is OutOfMemoryError! \uD83C\uDF89")
    }
// 8
    try {
        a()
    } catch (e: StackOverflowError) {
        println("It is StackOverflowError! \uD83C\uDF89")
    }
}

fun a() {
    a()
}