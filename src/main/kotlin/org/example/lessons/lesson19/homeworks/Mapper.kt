package org.example.lessons.lesson19.homeworks

//3. Создай интерфейс Mapper с двумя дженериками,
// который будет определять методы для преобразования:
// 3.1. элементов одного типа в элементы другого типа
// 3.2. списка элементов одного типа в список элементов другого типа

interface Mapper <T, R> {
    fun map(element: T): R
    fun map(element: List<T>): List<R>
}