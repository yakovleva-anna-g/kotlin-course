package org.example.lessons.lesson16.homeworks

import org.example.lessons.lesson09.readOnlyList

//1.Животные и Их Звуки
// 1.Базовый класс: Animal с методом makeSound().
// 2.Классы наследники: Dog, Cat, Bird.
// 3.Базовый метод makeSound() в классе Animal выводит "This animal makes no sound."
// 4.Переопределите метод makeSound() в каждом классе-наследнике,
// чтобы Dog выводил "Bark", Cat - "Meow", Bird - "Tweet". Обогати вывод звуков цветом.
// 5.Создайте список животных List<Animal> и вызовите в цикле метод makeSound()

object Colors {
    object Colors {
        const val RESET = "\u001B[0m"
        const val RED = "\u001B[31m"
        const val GREEN = "\u001B[32m"
        const val YELLOW = "\u001B[33m"
}

abstract class Animal(){ // класс Animal описывает какой-то
    // класс заготовки для будущих животных
    open fun makeSound() { // обязательно метод должен быть open иначе
        // override в классы Dog и тд не скомпилируется
        println("This animal makes no sound.")
    }
}
class Dog: Animal(){
    val dog = Dog()
    override fun makeSound(){
        println("${Colors.RED}Bark${Colors.RESET}")
    }
}
    class Cat: Animal(){
        override fun makeSound(){
            println("${Colors.GREEN}Meow${Colors.RESET}")
        }
    }
    class Bird: Animal(){
        override fun makeSound(){
            println("${Colors.YELLOW}Tweet${Colors.RESET}")
        }
    }
}

//Геометрические Фигуры и Их Площадь
//Абстрактный (базовый) класс: Shape с open методом area().
//Классы наследники: Circle, Square, Triangle.
//Метод area() возвращает 0.0.
//Переопределите метод area() в каждом классе-наследнике для расчета площади
// соответствующей фигуры.
//Подсказка: каждый класс должен иметь аргументы конструктора, позволяющие
// вычислить площадь (для круга это радиус, для квадрата это сторона,
// для треугольника это две стороны и угол между ними)
//Создай набор геометрических фигур и выведи в цикле их площадь

abstract class  Shape (){
    open fun area(): Double {
        return 0.0
    }
    class Circle(
        val radius: Double // аргументы при создании объекта
    ) : Shape(){
        override fun area(): Double {
            return 3.14*radius*radius
        }
    }
    class Square(
        val side: Double // аргументы при создании объекта
    ): Shape(){
        override fun area(): Double {
            return side*side
        }
    }
    class Triangle(
        val sideA : Double, // аргументы при создании объекта
        val sideB : Double,
        val sinY : Double
    ) : Shape() {
        override fun area(): Double {
            return 0.5 * sideA * sideB * sinY
        }
    }
}

//Принтер
//Создай абстрактный принтер, который имеет абстрактный метод печати, принимающий в качестве
// аргумента строку.
//Создай классы наследники: лазерный и струйный
//Лазерный принтер должен разбивать фразу на слова по пробелу и выводить каждое слово
// отдельно чёрными буквами на белом фоне (хорошо работает на тёмной теме)
//Струйный принтер должен разбивать фразу на слова по пробелу и выводить каждое слово
// отдельно цветными буквами на цветном фоне. Слова должны быть разноцветны.
// Можно сделать список пар с цветом текста и фона и проходить циклически по этому списку
// при выводе текста. Проверить работу на длинном тексте

object ColorsPrinter {
    const val RESET = "\u001B[0m"
    // Цвета текста
    const val TEXT_BLACK  = "\u001B[30m"
    const val TEXT_RED    = "\u001B[31m"
    const val TEXT_GREEN  = "\u001B[32m"
    const val TEXT_YELLOW = "\u001B[33m"
    const val TEXT_BLUE   = "\u001B[34m"
    const val TEXT_PURPLE = "\u001B[35m"
    const val TEXT_CYAN   = "\u001B[36m"
    const val TEXT_WHITE  = "\u001B[37m"

    // Цвета фона
    const val BG_BLACK  = "\u001B[40m"
    const val BG_RED    = "\u001B[41m"
    const val BG_GREEN  = "\u001B[42m"
    const val BG_YELLOW = "\u001B[43m"
    const val BG_BLUE   = "\u001B[44m"
    const val BG_PURPLE = "\u001B[45m"
    const val BG_CYAN   = "\u001B[46m"
    const val BG_WHITE  = "\u001B[47m"
}
abstract class Printer {
    abstract fun printPage(text: String)
}
class LaserPrinter(): Printer (){
    override fun printPage(text: String) {
        val words = text.split(" ")
    for (item in words){
println("${ColorsPrinter.TEXT_BLACK}${ColorsPrinter.BG_WHITE}$item $ColorsPrinter.RESET")
    }
    }
}

class InkjetPrinter: Printer() {
    val schemes = listOf<Pair<String, String>>(
        ColorsPrinter.TEXT_RED to ColorsPrinter.BG_WHITE,    // красный на белом
        ColorsPrinter.TEXT_GREEN  to ColorsPrinter.BG_BLACK,    // зелёный на чёрном
        ColorsPrinter.TEXT_YELLOW to ColorsPrinter.BG_BLUE,     // жёлтый на синем
        ColorsPrinter.TEXT_BLUE   to ColorsPrinter.BG_YELLOW,   // синий на жёлтом
        ColorsPrinter.TEXT_PURPLE to ColorsPrinter.BG_WHITE,    // фиолетовый на белом
        ColorsPrinter.TEXT_CYAN   to ColorsPrinter.BG_BLACK,    // голубой на чёрном
        ColorsPrinter.TEXT_WHITE  to ColorsPrinter.BG_RED)   // белый на красном)

                override fun printPage(text: String) {
        val words = text.split(" ")
            var i = 0
            var colorIndex = 0
                    do {println("$bgColor$textColor${words[i]}$ColorsPrinter.RESET")
                    } while (++i<words.size)
                val (textColor, bgColor) = schemes[colorIndex]

                if (++colorIndex>= schemes.size) {colorIndex = 0}
        }
    }

//Перегрузка методов
//
//Класс “Корзина товаров”: содержит поле словаря из ID товаров и их количества.
//Базовый метод addToCart(itemId) добавляет одну единицу товара к уже существующим в корзине.
//Выполнить перегрузку addToCart который:
//Принимает два аргумента (itemId и количество amount)
//Принимает словарь из id и количества и добавляет всё в корзину
//Принимает список из id (добавляет по одной единице).
//Учесть, что если товар уже есть в корзине, нужно увеличить его количество, если нет - добавить.
//Попробуй создать корзину и положить в неё товар разными способами, потом распечатать корзину
// в консоль.
//Переопредели у корзины метод toString для красивого форматирования содержимого таблицы,
// включая итоговое количество артикулов и общее количество всего товара в корзине.

class BasketGoods() {
    val field = mutableMapOf<Int,Int>()
    fun addToCart(itemId: Int) {val amount = field[itemId]
    if (amount == null) {
        field[itemId] = 1
    } else {
        field[itemId] = amount+1
    }
    }

    fun addToCart(itemId: Int, amount: Int) {
        for (i in 1..amount) {
            addToCart(itemId)
        }
    }

    fun addToCart(field: Map<Int, Int>) {
        for (product in field) {
            addToCart(product.key, product.value)
        }
    }
}