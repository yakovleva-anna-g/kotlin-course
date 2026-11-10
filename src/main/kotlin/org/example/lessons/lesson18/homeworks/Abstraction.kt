package org.example.lessons.lesson18.homeworks

//Абстрактный класс отвечает на вопрос ЧТО?

// Интерфейс говорит у нас есть какая-то в будущем вещь, сейчас это какая-то абстрактная вещь,
// которую можем включить. Чтобы ее включить мы будем пользоваться методом -turnOn,
// а чтобы выключить - turnOff. Всё что будет в будущем изготовлено с помощью этого интерфейса
// будет обязательно абсолютно иметь два метода как минимум turnOn и turnOff/
// Любой класс который имплементирует(это внедрять, воплотить в жизнь) этот класс
// будет обязан реализовать перечисленные
// методы интерфейса - это и называется КОНТРАКТ

// любой метод, который будет принимать объект с типом Powerable

interface Powerable {
    fun turnOn()
    fun turnOff()
}

// интерфейсы могут НАСЛЕДОВАТЬСЯ

interface Device : Powerable { // создаю новый интерфейс Device - это какой-то новый
    // интерфейс с НАСЛЕДОВАНИЕМ Powerable


    // Константа, определенная в companion object
    companion object {
        const val TYPE = "Device"
    }

    // Абстрактное свойство (поле), которое должно быть переопределено в классе, реализующем интерфейс
    val deviceId: String

    // Метод с реализацией, вызывающий приватный метод
    fun restart() {
        turnOff()
        logAction("Устройство с ID $deviceId выключено для перезагрузки.")
        turnOn()
        logAction("Устройство с ID $deviceId включено после перезагрузки.")
    }

    // Приватный метод с реализацией (доступно начиная с Kotlin 1.4)
    // приватная функция будет доступна в пределах данного тела этого класса Powerable
    // в данном случае этот метод нужен для того, чтобы уменьшить дублирование кода
    private fun logAction(action: String) {
        println("* Лог действия устройства: $action *")
    }
}

// создаем абстрактный класс с реализованными методами из интерфейса
abstract class HouseholdAppliance(
    val brand: String
) : Device {

    abstract val applianceType: String

    var isPoweredOn: Boolean = false
        private set

    abstract fun operate()

    override fun turnOn() {
        isPoweredOn = true
        onPowerChange()
    }

    override fun turnOff() {
        isPoweredOn = false
        onPowerChange()
    }

    private fun onPowerChange() {
        val state = if (isPoweredOn) {
            "включено"
        } else {
            "выключено"
        }
        println("Устройство '$applianceType $brand' $state.")
    }

    protected open fun performMaintenance() {
        println("*** Секция обслуживания устройства ***")
    }
}

// создание нового интерфейса
interface Programmable {
    // Programmable - программируемое
    // название для интерфейсов рекомендуют выбирать таким образом,
    // чтобы интерфейс сообщал, что это контракт делает и для чего предназначен
    // то что будет имплементировать этот интерфейс будет иметь свойство программируемости
    //за счет того что будут обязаны реализовать этот метод

    fun selectProgram(preset: Int)
}

class Microwave(
    brand: String,
    serialNumber: String
    // есть класс и мы можем наделить его множеством разных свойств :
) : HouseholdAppliance(brand), Programmable {

    private val programPresets = mapOf(
        1 to "warm up soup",
        2 to "warm up bread"
    )

    private var lastProgram = 1

    override val deviceId = serialNumber

    override val applianceType: String = "Микроволновая печь"

    override fun operate() {
        if (isPoweredOn) {
            invokeProgram()
            performMaintenance()
        } else {
            println("Микроволновая печь от $brand не включена. Пожалуйста, включите ее.")
        }
    }

    override fun performMaintenance() {
        super.performMaintenance()
        println("Чистка микроволновой печи от $brand.")
    }

    override fun selectProgram(preset: Int) {
        if (preset in programPresets) {
            lastProgram = preset
        }
    }

    private fun invokeProgram() {
        println(programPresets[lastProgram])
    }
}

/// как это выполнено в работе:
fun main() {
    // создаем объект нашей микроволновой печи "Samsung" и какой-то серийный номер "CX45HGR-T10"
    val mw = Microwave("Samsung", "CX45HGR-T10")
    println(mw.isPoweredOn)
    // mw.isPoweredOn = true // так нельзя
    println(mw.deviceId)
    mw.turnOn()
    mw.operate()
    mw.restart()
    mw.operate()
    mw.turnOff()
}