package org.example.lessons.lesson18.homeworks

//Задача 3. Создай абстрактный класс для программируемого оборудования
// (с имплементацией соответствующего интерфейса и реализацией методов) и
// наследуй его от абстрактного класса включаемого оборудования.

abstract class ProgrammableDevice: PoweredDevice(), Programmable1  {
    override fun programAction(action: String) {
        if (!isOn) {
            println("Устройство выключено - программирование невозможно")
            return
        }
        println("Запрограммировано: $action")
    }
    override fun execute() {
        if (!isOn) {
            println("Устройство выключено - программирование невозможно")
            return
        }
        println("Выполнение запрограммированного действия")
    }
}
