package org.example.lessons.lesson10.homeworks

import org.example.lessons.lesson09.mutableList

fun main() {

//    1.Создайте пустой неизменяемый словарь, где ключи и значения - целые числа.
    val ex1: Map<Int, Int> = mapOf() // - тип слева
    val ex1a = mapOf<Int, Int>() // - тип справа

//    2.Создайте словарь, инициализированный несколькими парами "ключ-значение",
//    где ключи - float, а значения - double
    // to-инфиксная функция
    val ex2: Map<Float, Double> = mapOf(12.546f to 1234.64, 69.66489f to 132.123)
    val ex2a = mapOf<Float, Double>(12.546f to 1234.64, 69.66489f to 132.123)

//    3.Создайте изменяемый словарь, где ключи - целые числа, а значения - строки.
    val ex3 = mutableMapOf(1 to "yes", 2 to "no")

//    4.Имея изменяемый словарь, добавьте в него новые пары "ключ-значение".
    ex3[3] = "possible"
    println(ex3)
    ex3[4] = "never"
    println(ex3)

    println("=======4=====")

//    5.Используя словарь из предыдущего задания, извлеките значение,
//    используя ключ. Попробуй получить значение с ключом, которого в словаре нет.
    println(ex3[1])
    println(ex3[5])
    println("=======5=====")

//    6.Удалите определенный элемент из изменяемого словаря по его ключу.
    ex3.remove(2)
    println(ex3)
    println("=======6=====")
//    7.Создайте словарь (ключи Double, значения Int) и выведи в цикле результат
//    деления ключа на значение. Не забудь обработать деление на 0 (в этом
//    случае выведи слово “бесконечность”)
    val ex7 = mapOf<Double, Int>(6.6 to 2, 12.9 to 3, 5.2 to 0)
    for ((keyDouble, valueInt) in ex7) {
        if (valueInt == 0) {
            println("бесконечность")
        } else {
            println(keyDouble / valueInt)
        }
    }
    println("=======7=====")

//    8.Измените значение для существующего ключа в изменяемом словаре.
    val ex8 = mutableMapOf(1 to "yes", 2 to "no")
    ex8[1] = "да"
    println(ex8)

    println("=======8=====")

//    9.Создайте два словаря и объедините их в третьем изменяемом словаре через циклы.
    val ex9 = mapOf<Int, String>(1 to "yes", 2 to "no")
    val ex9a = mapOf<Int, String>(3 to "Москва", 4 to "Воронеж")
    val ex9Union = mutableMapOf<Int, String>()
    for ((keyEx9, valueEx9) in ex9) {
        ex9Union[keyEx9] = valueEx9

    }
    for ((keyEx9, valueEx9) in ex9a) {
        ex9Union[keyEx9] = valueEx9

    }
    println(ex9Union)
    println("=======9=====")

//    10.Создайте словарь, где ключами являются строки, а значениями -
//    списки целых чисел. Добавьте несколько элементов в этот словарь.
    val ex10 =
        mutableMapOf<String, MutableList<Int>>("четные" to mutableListOf(2, 4, 8), "нечетные" to mutableListOf(3, 5, 7))
    ex10["четные"]?.add(10) // безопасный способ. Если ключ есть-добавит, если нет-ничего не сделает молча
    ex10.getValue("нечетные").add(9) // если ключа нет - бросит исключение
    println(ex10)
    println("=======10=====")

//    11.Создай словарь, в котором ключи - это целые числа, а значения
//    - изменяемые множества строк. Добавь данные в словарь.
//    Получи значение по ключу (это должно быть множество строк) и
//    добавь в это множество ещё строку. Распечатай полученное множество.

    val ex11 = mutableMapOf<Int, MutableSet<String>>(
        1 to mutableSetOf("яблоко", "груша"),
        2 to mutableSetOf("малина", "клубника")
    )
    val fruits = ex11.getValue(1)
    fruits.add("апельсин")
    println(fruits)

    println("=======11=====")

//    12.Создай словарь, где ключами будут пары чисел. Через перебор найди
//    значение у которого пара будет содержать цифру 5 в качестве первого
//    или второго значения.
    val ex12 = mapOf<Pair<Int, Int>, String>(Pair(2, 4) to "четные", Pair(3, 5) to "нечетные")
    for ((keyEx12, valueEx12) in ex12) {
        if (keyEx12.first == 5 || keyEx12.second == 5) {
            println(valueEx12)
        }
    }

//    Задачи на подбор оптимального типа для словаря
//  13.Словарь библиотека: Ключи - автор книги, значения - список книг

    val library = mapOf<String, List<String>>(
        "Братья Стругацкие" to listOf(
            "Пикник на обочине",
            "Понедельник начинается в субботу",
            "Трудно быть богом"
        )
    )
    val libraryMutable =
        mutableMapOf<String, MutableList<String>>("Сергей Лукьяненко" to mutableListOf("Семь дней до Мегиддо"))

//  14.Справочник растений: Ключи - типы растений (например, "Цветы", "Деревья"),
//  значения - списки названий растений
    val plantBook =
        mapOf<String, List<String>>("Цветы" to listOf("пионы", "ромашки"), "Деревья" to listOf("клен", "дуб"))

//  15.Четвертьфинала: Ключи - названия спортивных команд, значения - списки игроков
//  каждой команды
    val finals1_4 = mapOf<String, List<String>>(
        "Команда 1" to listOf("игрок А", "игрок В"),
        "Команда 2" to listOf("Игрок С", "Игрок D")
    )

//  16.Курс лечения: Ключи - даты, значения - список препаратов принимаемых в дату
    val courseTreatment = mapOf<String, List<String>>(
        "09.10.2026" to listOf("препарат 1", "препарат 2"),
        "10.10.2026" to listOf("препарат 1", "препарат 2")
    )

//  17.Словарь путешественника: Ключи - страны, значения - словари из городов со
//  списком интересных мест.
    val travelersDictionary: MutableMap<String, MutableMap<String, MutableList<String>>> =
        mutableMapOf(
            "Россия" to mutableMapOf("Калининград" to mutableListOf("Музей мирового океана", "Форт")),
            "Франция" to mutableMapOf(
                "Париж" to mutableListOf("Эйфелева башня", "Лувр"),
                "Лион" to mutableListOf("Старый город", "Античный театр")
            ))

}