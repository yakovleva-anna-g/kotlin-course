package org.example.lessons.lesson18.homeworks

import java.io.InputStream

// Задача 5. Создай не абстрактные классы устройств с наследованием от абстрактного
// класса с возможностью устанавливать температуру и открываться.
// Пусть это будет холодильник, стиральная машина, чайник, духовка.
// Добавь недостающие интерфейсы и реализуй необходимые методы
// (достаточно вывод в консоль производимого действия).
// Обрати внимание на то, что установка температуры и
// программирование устройства (считай - задание режима работы)
// не имеет смысла при выключенном питании - добавь эту проверку.

class Refrigerator1: TemperatureOpenableDevice(), SoundEmitting {
    override fun open() {
     println("Холодильник: дверца открыта, включился свет")
    }

    override fun close() {
        println("Холодильник: дверца  закрыта")
    }

    override fun setVolume(volume: Int) {
        println("Холодильник: громкость $volume")
    }

    override fun mute() {
        println("Холодильник: без звука")
    }

    override fun playSound(stream: InputStream) {
        println("Холодильник: играет сигнал")
    }

    override val maxTemperature: Int = 10

}
