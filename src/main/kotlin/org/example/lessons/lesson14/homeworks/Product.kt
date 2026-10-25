package org.example.lessons.lesson14.homeworks
// Покупка: продукт. Создайте дата класс для продукта,
// который будет представлять продукт в магазине.
// У него должны быть свойства “название”, “цена”, “количество”.

data class Product(val name: String, val price: Double, var quantity: Int)
    fun main() {
        val apple = Product("Apple", 12.25, 12)
        println(apple)
    }

