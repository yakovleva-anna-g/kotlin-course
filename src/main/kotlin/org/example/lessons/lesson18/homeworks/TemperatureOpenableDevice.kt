package org.example.lessons.lesson18.homeworks

// Задача 4. Создай абстрактный класс оборудования с возможностью устанавливать
// температуру и открываться и с наследованием от программируемого оборудования.
// Также имплементируй интерфейсы.

abstract class TemperatureOpenableDevice: ProgrammableDevice(),
    TemperatureRegulatable, Openable {
    abstract override val maxTemperature: Int

    override fun setTemperature(temp: Int) {
        if (!isOn) {
            println("Устройство выключено - установка температуры невозможно")
            return
        }
        if (temp > maxTemperature) {
            println("Ошибка: $temp С с превышением максимума $maxTemperature C")
            return
        }
        println("Температура установлена на $temp С")
    }

    override fun open() {
        println("Открыто")
    }

    override fun close() {
        println("Закрыто")
    }
}