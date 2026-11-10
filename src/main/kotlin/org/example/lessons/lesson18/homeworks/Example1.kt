package org.example.lessons.lesson18.homeworks

import java.io.InputStream


interface Powerable { // мощность включается/выключается
    fun powerOn()
    fun powerOff()
}

interface Openable { // открывается
    fun open()
    fun close()
}

interface WaterContainer { // контейнер для воды
    val capacity: Int // вместимость
    fun fillWater(amount: Int) // наполненный водой
    fun getWater(amount: Int) // берет воду
}

interface TemperatureRegulatable { // регулировать температуру
    val maxTemperature: Int
    fun setTemperature(temp: Int) // уставленная температура
}

interface WaterConnection { // подключение воды
    fun connectToWaterSupply() // подключение к водопроводу
    fun getWater(amount: Int) // берет воды
}

interface AutomaticShutdown { // автоматическое отключение
    val sensorType: String // тип датчика
    val maxSensoredValue: Int // максимальное значение
    fun startMonitoring() // начать мониторинг
}

interface Drainable { // сливной
    fun connectToDrain() //подключен слив
    fun drain() // слив
}

interface Timable { //время
    fun setTimer(time: Int) // установленное время
}

interface BatteryOperated { // работает от батареи
    fun getCapacity(): Double // вмещает (емкость)
    fun replaceBattery() // берет батарею
}

interface Mechanical { // механический
    fun performMechanicalAction() // выполняет механические действия
}

interface LightEmitting { // светоизлучающий
    fun emitLight() // излучает свет
    fun completeLiteEmission() // полное излучение
}

interface SoundEmitting { //звукоизлучающий
    fun setVolume(volume: Int) // уставлен объем
    fun mute() // без звука (немой)
    fun playSound(stream: InputStream) //проигрывается музыка
}

interface Programmable { // программируемый
    fun programAction(action: String) // программа активирована
    fun execute() // выполнить
}

interface Movable { // подвижный
    fun move(direction: String, distance: Int) // перемещается
}

interface Cleanable { // стирается
    fun clean()
}

interface Rechargeable { // перезаряжаемый
    fun getChargeLevel(): Double // получен уровень зарядки
    fun recharge() // перезаряжать
}

// 1. Холодильник
abstract class Refrigerator:
    Powerable, Openable, TemperatureRegulatable, SoundEmitting

// 2. Стиральная машина
abstract class WashingMachine :
    Powerable, Openable, WaterContainer, // контейнер для воды
    TemperatureRegulatable,
    WaterConnection, // подключение к воде
    Drainable, Timable, SoundEmitting, Programmable

// 3. Умная лампа
abstract class SmartLamp :
    Powerable, LightEmitting, Programmable

// 4. Электронные часы
abstract class ElectronicClock :
    Powerable, Timable, SoundEmitting, Programmable, LightEmitting // излучение света

// 5. Робот-пылесос
abstract class RobotVacuumCleaner :
    Powerable, Movable, Rechargeable, // перезаряжаемый
    SoundEmitting,
    Programmable, Cleanable, Timable, AutomaticShutdown // автоматическое отключение

// 6. Механические часы
abstract class MechanicalClock :
    Mechanical, Timable, SoundEmitting

// 7. Фонарик
abstract class Flashlight :
    Powerable, LightEmitting, BatteryOperated, Movable

// 8. Кофемашина
abstract class CoffeeMachine :
    Powerable, WaterContainer, WaterConnection, // подключение к воде
    TemperatureRegulatable,
    Drainable, Timable, SoundEmitting, Programmable

// 9. Умная колонка
abstract class SmartSpeaker :
    Powerable, SoundEmitting, Programmable, Rechargeable, LightEmitting