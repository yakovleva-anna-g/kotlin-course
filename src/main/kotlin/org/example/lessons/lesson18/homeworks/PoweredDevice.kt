package org.example.lessons.lesson18.homeworks

// Задача 2. Создай абстрактный класс для включаемого оборудования и имплементируй
// соответствующий интерфейс с реализацией методов
// (достаточно println с выполняемым действием)

abstract class PoweredDevice : Powerable1 {
    var isOn: Boolean = false
        protected set // читать можно снаружи, менять - только внутри иерархии
    override fun powerOff() {
        isOn = false
        println("Оборудование выключено")
    }

    override fun powerOn() {
        isOn = true
        println("Оборудование включено")
    }
}


