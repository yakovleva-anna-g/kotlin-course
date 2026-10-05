package org.example.lessons.lesson09.homeworks

import org.example.lessons.lesson09.emptySet
import org.example.lessons.lesson09.mutableList
import javax.lang.model.type.ArrayType
fun main() {


//Работа с массивами Array
//// 1.Создайте массив из 5 целых чисел и инициализируйте его значениями от 1 до 5.
    val example1: Array<Int> = arrayOf(1, 2, 3, 4, 5)

//// 2.Создайте пустой массив строк размером 10 элементов.
    val example2: Array<Int?> = arrayOfNulls(size = 10)

//// 3.Создайте массив из 5 элементов типа Double и заполните его значениями,
// являющимися удвоенным индексом элемента.
    val example3: DoubleArray = doubleArrayOf(1.1, 2.2, 3.3, 4.4, 5.5)

//// 4.Создайте массив из 5 элементов типа Int. Используйте цикл, чтобы присвоить каждому элементу значение,
// равное его индексу, умноженному на 3.

    val number = IntArray(5)
    for (index in number.indices) {
        number[index] = index * 3
        println(number[index])
    }
    println("=====Array=4========")
//// 5.Создайте массив из 3 nullable строк. Инициализируйте его одним null значением и двумя строками.
    val stringsnullable: Array<String?> = arrayOf(null, "тратата", "труляля")

//// 6.Создайте массив целых чисел и скопируйте его в новый массив в цикле.
    val ex6: Array<Int> = arrayOf(1, 2, 3, 4, 5)
    val copyEx6: Array<Int> = Array(5) { 0 }
    for (i in ex6.indices) {
        copyEx6[i] = ex6[i]
    }
    println(copyEx6.contentToString())

    println("=====Array=6========")
//// 7.Создайте два массива целых чисел одинаковой длины. Создайте третий массив, вычев значения одного из другого.
// Распечатайте полученные значения.

    val ex7: Array<Int> = Array(size = 6) { 8 }
    val newEx7: Array<Int> = Array(6) { 4 }
    val razEx7: Array<Int> = Array(6) { 0 }
    for (index in ex7.indices) {
        razEx7[index] = ex7[index] - newEx7[index]
    }
    println(razEx7.contentToString())
    println("=====Array=7========")

//// 8.Создайте массив целых чисел. Найдите индекс элемента со значением 5.
// Если значения 5 нет в массиве, печатаем -1. Реши задачу через цикл while.

    val ex8: Array<Int> = arrayOf(21, 43, 67, 5, 78)
    var i = 0
    var foundIndex = -1
    while (i in ex8.indices) {
        if (ex8[i] == 5) {
            foundIndex = i
            break
        }
        i++
    }
    println(foundIndex)

    println("=====Array=8========")
//// 9.Создайте массив целых чисел. Используйте цикл для перебора массива и вывода каждого элемента в консоль.
// Напротив каждого элемента должно быть написано “чётное” или “нечётное”.

    val ex9: Array<Int> = arrayOf(5, 6, 7, 8, 9)
    for (element in ex9) {
        if (element % 2 == 0)
            println("$element -четное")
        else {
            println("$element -нечетное")
        }
    }
    println("=====Array=9========")

//// 10.Создай функцию, которая принимает массив строк и строку для поиска.
// Функция должна находить в массиве элемент, в котором принятая строка является подстрокой (метод contains()).
// Распечатай найденный элемент.
    val ex10: Array<String> = arrayOf("возможно", "да", "нет")
    for (element10 in ex10) {
        if (element10.contains("возможно"))
            println(element10)
    }
    println("=====Array=10========")

//    Работа со списками List
// 1. Создайте пустой неизменяемый список целых чисел.
    val ex1List: List<Int> = listOf()
    val ex1List1: List<Int> = emptyList()
    // emptyList<Int>() - Когда список должен быть пустым по замыслу —
// как стартовое значение, как «пока ничего нет»
    // listOf<Int>() - Когда имя функции — просто факт «список без элементов», без акцента на пустоте

// 2. Создайте неизменяемый список строк, содержащий три элемента (например, "Hello", "World", "Kotlin").
    val ex2List: List<String> = listOf("Hello", "World", "Kotlin")

// 3.Создайте изменяемый список целых чисел и инициализируйте его значениями от 1 до 5.
    val ex3List: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5)

// 4.Имея изменяемый список целых чисел, добавьте в него новые элементы (например, 6, 7, 8).
    val ex4List: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5)
    ex4List.add(6,)
    ex4List.add(7,)
    ex4List.add(8)

// 5.Имея изменяемый список строк, удалите из него определенный элемент (например, "World").
    val ex5List: MutableList<String> = mutableListOf("Hello", "World", "Kotlin")
    ex5List.removeAt(1)

// 6.Создайте список целых чисел и используйте цикл для вывода каждого элемента на экран.
    val ex6List: List<Int> = listOf(1, 2, 3, 4,)
    for (element6 in ex6List) {
        println(element6)
    }
    println("=====List=6========")

// 7.Создайте список строк и получите из него второй элемент, используя его индекс.
    val ex7list: List<String> = listOf("Hello", "World", "Kotlin")
    println(ex7list[1])

    println("=====List=7========")

// 8.Имея изменяемый список чисел, измените значение элемента на определенной позиции
// (например, замените элемент с индексом 2 на новое значение).
    val ex8List: MutableList<Int> = mutableListOf(23, 43, 65, 87)
    ex8List[2] = 3
    println(ex8List)

    println("=====List=8========")
// 9.Создайте два списка строк и объедините их в один новый список, содержащий элементы обоих списков.
// Реши задачу с помощью циклов.
    val ex9ListA: List<String> = listOf("да")
    val ex9ListB: List<String> = listOf("нет")
    val resultEx9: MutableList<String> = mutableListOf()
    for (element9 in ex9ListA) {
        resultEx9.add(element9)
    }
    for (element9 in ex9ListB) {
        resultEx9.add(element9)
    }
    println(resultEx9)
    println("=====List=9========")
// 10.Создайте список целых чисел и найдите в нем минимальный и максимальный элементы используя цикл.
    val ex10list: List<Int> = listOf(2, 13, 36)
    var min = ex10list[0]
    var max = ex10list[0]
    for (element10 in ex10list) {
        if (element10 < min) {
            min = element10
        }

        if (element10 > max) {
            max = element10
        }
    }
    println(min)
    println(max)
    println("=====List=10========")
// 11.Имея список целых чисел, создайте новый список, содержащий только четные числа из исходного
// списка используя цикл.
    val ex11List: List<Int> = listOf(2, 5, 6, 7, 8)
    val newEx11List: MutableList<Int> = mutableListOf()
    for (element11 in ex11List) {
        if (element11 % 2 == 0) {
            newEx11List.add(element11)
        }
        println(newEx11List)
    }
//    Работа с Множествами Set
// 1.Создайте пустое неизменяемое множество целых чисел.
val ex1Set: Set<Int> = emptySet()

// 2.Создайте неизменяемое множество целых чисел, содержащее три различных элемента (например, 1, 2, 3).
val ex2Set: Set<Int> = setOf(1, 2, 3)

// 3.Создайте изменяемое множество строк и инициализируйте его несколькими значениями
// (например, "Kotlin", "Java", "Scala").
val ex3Set: MutableSet<String> = mutableSetOf("Kotlin", "Java", "Scala")

// 4.Имея изменяемое множество строк, добавьте в него новые элементы (например, "Swift", "Go").
    ex3Set.add("Swift")
    ex3Set.add("Go")

// 5.Имея изменяемое множество целых чисел, удалите из него определенный элемент (например, 2).
val ex5Set: MutableSet<Int> = mutableSetOf(1, 3, 4, 2)
ex5Set.remove(2)

// 6.Создайте множество целых чисел и используйте цикл для вывода каждого элемента на экран.
val ex6Set: Set<Int> = setOf(6, 7, 8, 9)
    for (element6Set in ex6Set)
        println(element6Set)
    println("=====Set=6========")
// 7.Создай функцию, которая принимает множество строк (set) и строку и проверяет, есть ли
// в множестве указанная строка. Нужно распечатать булево значение true если строка есть.
// Реши задачу через цикл.
val ex7Set: Set<String> = setOf("возможно", "да", "нет")
    for (element7Set in ex7Set) {
        if (element7Set == "да") {
            println(true)
            break
        }

    }

// 8.Создайте неизменяемое множество строк и конвертируйте его в изменяемый список строк с
// использованием цикла.
val ex8Set: Set<String> = setOf("яблоко", "груша", "слива")
    val mutabEx8List: MutableList<String> = mutableListOf()
    for (elemetEx8Set in ex8Set) {
        mutabEx8List.add(elemetEx8Set)
    }
    println(mutabEx8List)

}
