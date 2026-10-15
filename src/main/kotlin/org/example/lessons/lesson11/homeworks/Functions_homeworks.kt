package org.example.lessons.lesson11.homeworks

// fun имя(параметры): ВозвращаемыйТип {
//    // тело
//}

//   Задачи на сигнатуру (это название функции и возвращаемый тип) метода
////1.Не принимает аргументов и не возвращает значения
fun ex1() {

}

////2.Принимает два целых числа и возвращает их сумму.

fun sumEx2(a: Int, b: Int): Int {
    return a + b
}
////3.Принимает строку и ничего не возвращает.
fun ex3(c: String): Unit { println() // явно указали Unit, а можно ничего не указывать
}

////4.Принимает список целых чисел и возвращает среднее значение типа Double.

fun ex4(list: List<Int>): Double {
    var sum: Double = 0.0
    var count = 0
    for (element in list) {
        sum = sum + element
        count++
    }
    return sum / count

}
////5.Принимает nullable строку и возвращает её длину в виде nullable целого числа и
// доступна только в текущем файле.
private fun ex5(nullableString: String?): Int? {
    if (nullableString == null) return null
   return nullableString.length
}

////6.Не принимает аргументов и возвращает nullable вещественное число.
fun ex6(): Double? { return null

}

////7.Принимает nullable список целых чисел, не возвращает значения и доступна только в текущем файле.

private fun ex7(listEx7: List<Int>?): Unit {}

////8.Принимает целое число и возвращает nullable строку.
fun ex8(number: Int): String? {
    return null

}
////9.Не принимает аргументов и возвращает список nullable строк.

fun ex9(): List<String?> {
    return emptyList()
}

////10.Принимает nulаlable строку и nullable целое число и возвращает nullable булево значение.
fun ex10(x: String?, y: Int?): Boolean? {
    if (x== null) return null
    if (y == null) return null
    return (x!= null || y!= null)
}

//Задачи на написание кода
//Напишите валидную сигнатуру метода, а также рабочий код для задач.
//
//11.Напишите функцию multiplyByTwo, которая принимает целое число и возвращает его, умноженное на 2.
fun multiplyByTwo(multiply:Int): Int {
    return multiply * 2
}
// fun multiplyByTwo(multiply:Int) = multiply * 2   // написана в одну строку предыдущая функция

//12.Создайте функцию isEven, которая принимает целое число и возвращает true, если число чётное,
// и false в противном случае.
fun isEven(Even: Int): Boolean {
    if (Even%2==0) return true
    return false
}

//13.Напишите функцию printNumbersUntil, которая принимает целое число n и выводит на экран числа от 1 до n.
// Если число n меньше 1, функция должна прекратить выполнение с помощью return без вывода сообщений.

fun printNumbersUntil(n: Int): Unit{
    if (n<1) return
    for (i in 1..n) println(i)
}
//14.Создайте функцию findFirstNegative, которая принимает список целых чисел и возвращает первое
// отрицательное число в списке. Если отрицательных чисел нет, функция должна вернуть null.
fun findFirstNegative(listInt: List<Int>): Int?{
for (f in listInt) {if (f <0) {return f
}
}
    return null }

//15.Напишите функцию processList, которая принимает список строк. Функция должна проходить по списку и
// выводить каждую строку. Если встречается null значение, функция должна прекратить выполнение с помощью
// return без возврата значения.

fun processList(ListEx15: List<String?>) {
    for (element in ListEx15) {
        if (element == null) return
        println(element)
    }
}