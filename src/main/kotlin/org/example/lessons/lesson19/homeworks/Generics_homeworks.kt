package org.example.lessons.lesson19.homeworks

//1.Напиши функцию getMiddleElement с дженериком, которая будет принимать список и возвращать средний элемент,
// если он существует, иначе возвращать null. Например, у списка из четырёх элементов - среднего элемента нет.

fun <T> getMiddleElement(list: List<T>): T? {
    if (list.size%2 == 0){
        return null
    }
    return list[list.size / 2]
}