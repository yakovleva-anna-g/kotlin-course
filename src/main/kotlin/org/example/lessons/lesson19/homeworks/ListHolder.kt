package org.example.lessons.lesson19.homeworks

//2. Напиши класс ListHolder, который будет хранить список элементов типа T и
// иметь метод для добавления нового элемента и получения всех элементов в виде неизменяемого списка.

class ListHolder <T> {
    val list = mutableListOf<T>()
    fun add(element: T) {
        list.add(element)
    }
    fun get(): List<T> {
        return list.toList()
    }
}
