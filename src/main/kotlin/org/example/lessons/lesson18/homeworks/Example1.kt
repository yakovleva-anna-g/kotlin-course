package org.example.lessons.lesson18.homeworks

interface Powerable {
    fun powerOn()
    fun powerOff()
}

interface Openable {
    fun open()
    fun close()
}

interface WaterContainer {
    val capacity: Int
    fun fillWater(amount: Int)
    fun getWater(amount: Int)
}

interface TemperatureRegulatable {
    val maxTemperature: Int
    fun setTemperature(temp: Int)
}

interface WaterConnection {
    fun connectToWaterSupply()
    fun getWater(amount: Int)
}

interface AutomaticShutdown {
    val sensorType: String
    val maxSensoredValue: Int
    fun startMonitoring()
}

interface Drainable {
    fun connectToDrain()
    fun drain()
}

interface Timable {
    fun setTimer(time: Int)
}

interface BatteryOperated {
    fun getCapacity(): Double
    fun replaceBattery()
}

interface Mechanical {
    fun performMechanicalAction()
}

interface LightEmitting {
    fun emitLight()
    fun completeLiteEmission()
}

interface SoundEmitting {
    fun setVolume(volume: Int)
    fun mute()
    fun playSound(stream: InputStream)
}

interface Programmable {
    fun programAction(action: String)
    fun execute()
}

interface Movable {
    fun move(direction: String, distance: Int)
}

interface Cleanable {
    fun clean()
}

interface Rechargeable {
    fun getChargeLevel(): Double
    fun recharge()
}

// 1. Холодильник
abstract class Refrigerator:
    Powerable, Openable, TemperatureRegulatable, SoundEmitting

// 2. Стиральная машина
abstract class WashingMachine :
    Powerable, Openable, WaterContainer, TemperatureRegulatable,
    WaterConnection, Drainable, Timable, SoundEmitting, Programmable

// 3. Умная лампа
abstract class SmartLamp :
    Powerable, LightEmitting, Programmable

// 4. Электронные часы
abstract class ElectronicClock :
    Powerable, Timable, SoundEmitting, Programmable, LightEmitting

// 5. Робот-пылесос
abstract class RobotVacuumCleaner :
    Powerable, Movable, Rechargeable, SoundEmitting,
    Programmable, Cleanable, Timable, AutomaticShutdown

// 6. Механические часы
abstract class MechanicalClock :
    Mechanical, Timable, SoundEmitting

// 7. Фонарик
abstract class Flashlight :
    Powerable, LightEmitting, BatteryOperated, Movable

// 8. Кофемашина
abstract class CoffeeMachine :
    Powerable, WaterContainer, WaterConnection, TemperatureRegulatable,
    Drainable, Timable, SoundEmitting, Programmable

// 9. Умная колонка
abstract class SmartSpeaker :
    Powerable, SoundEmitting, Programmable, Rechargeable, LightEmitting