package org.example.lessons.lesson21

import org.example.lessons.lesson06.a

fun main() {
    val ex1: Any = "ам"
    println(ex1 as String)
    // println(ex1 as Int)
    if (ex1 is String) {
        println("Строка")
    }  else {
        println("Не строка")
    }

    val ex2: Any = listOf(1, "sdssf", "sdsf")
    println(ex2 as List<String>)
 //   println(ex2 as List<Int>)
   //  ex2[0].minus(1)
if (ex2 is List<String>) {
    println(ex2[0])
}
    if (ex2[0] is String) {
        println("Это строка")
    }
println((ex2[0] as? String) ?: "Не строка")

    val ex3: String? = null
    println(ex3 as? String)

    println(tryMultiple(2))
    println(tryMultiple("sjdsf"))
    println(tryMultiple("2"))
}


fun tryMultiple(arg: Any): Int? {
//    if (arg is Int) {
//        return arg*2
//    }
//    if  (arg is String) {
//        return arg.toIntOrNull()?.times(2)
//    }
//    return null
//
    return (arg as? Int)?.times(2)
        ?:(arg as? String)?.toIntOrNull()?.times(2)
}
