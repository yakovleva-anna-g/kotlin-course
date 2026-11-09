package org.example.lessons.lesson17.homeworks

import java.awt.Color
import javax.print.DocFlavor

// 1. Игровой автомат
//Опиши схематически класс игрового автомата, правильно расставив объявление
// полей (val или var) и методов (аргументы и возвращаемые значения),
// включая модификаторы доступа (private для приватных)

class SlotMachine(
    //Поля:
    //цвет color
val color: String,
//модель model
    val model: String,
    //наличие джойстика
    private val hasJoystick: Boolean,
    //владелец
    val owner: String,
    //телефон поддержки.
    val supportPhoneNumber: String,
    //пин-код автомата
    private var pinCode: String
) {
//параметры
//включен isOn
var isOn: Boolean = false
    //ОС загружена isOsLoaded
private var isOsLoaded: Boolean = false
    //список установленных игр
var installedGames: MutableList<String> = mutableListOf()
    //баланс вырученных средств
    private var balance: Double = 0.0
    //игровой сеанс оплачен.
    var isSessionPaid: Boolean = false
    //стоимость одного игрового сеанса.
    var sessionPrice: Double = 0.0

//Методы:
//включить
fun turnOn(){}
//выключить
fun turnOff(){}
//загрузить ОС
fun loadOS(){}
//завершить работу ОС
fun shutDownOS(){}
//показать список игр
fun showGames(): List<String> = listOf()
//включить игру
fun startGames(nameGame: String): Boolean {return true} // автомат должен знать какую игру запустить
// поэтому нужно указать входящий параметр и что он должен возвращать

//оплатить игровой сеанс
fun payForSession(amount: Double): Boolean {return false}
//забрать наличные с помощью пин-кода
fun withdrawCash(pin: String): Double {return 0.0}
//открыть сейф и выдать наличные
private fun openSafe(amount: Double) {}
}

// 2.Почемучка НЕ доделано еще
//Нужно скопировать код к себе и постараться ответить на все “почему” в
// комментариях и заданным образом доработать класс ChildrenClass (BaseClass доработке не подлежит)

abstract class BaseClass(
    // 1. объясни, почему это поле доступно в main() для чтения из класса ChildrenClass
    private val privateVal: String,
    // 2. объясни, почему это поле недоступно в main()
    protected val protectedVal: String,
    val publicVal: String
) {
    var publicField = "3. измени меня из функции main() на Антонио Бандераса и проверь через функцию getAll()" +
            "4. Доработай ChildrenClass таким образом, чтобы это получилось"
        set(value) {
            if (verifyPublicField(value)) {
                field = value
            }
        }
    protected var protectedField = "5. измени меня из функции main() через сеттер в наследнике"
    private var privateField = "6. добавь сеттер чтобы изменить меня из main()"
    fun getAll(): String {
        return mapOf(
            "privateVal" to privateVal,
            "protectedVal" to protectedVal,
            "publicVal" to publicVal,
            "publicField" to publicField,
            "protectedField" to protectedField,
            "privateField" to privateField,
            "generate" to generate(),
        ).map { "${it.key}: ${it.value}" }
            .joinToString("\n")
    }
    fun printText() {
        privatePrint()
    }
    // 7. объясни, почему эта функция не может быть публичной
    protected open fun getProtectedClass() = ProtectedClass()
    protected open fun verifyPublicField(value: String): Boolean {
        return value.length < 3
    }
    // 8. Распечатай getAll() и объясни, почему в поле "generate" другой текст
    open fun generate(): String {
        return "Это генерация из родительского класса"
    }
    private fun privatePrint() {
        println("Печать из класса BaseClass")
    }
    // 9. объясни, почему эта функция не может быть публичной или protected
    private fun getPrivateClass() = PrivateClass()

    protected class ProtectedClass() {}

    private class PrivateClass() {}
}
class ChildrenClass(
    val privateVal: String, // новое публичное поле, не родительское private
    protectedVal: String, // это просто параметр без val
    // 10. объясни, почему этот аргумент доступен в main() несмотря на то, что это не поле
    publicVal: String // это просто параметр без val
) : BaseClass(privateVal, protectedVal, publicVal) {
    // 11. объясни, почему в main() доступна функция getAll() хотя её здесь нет
    // 12. проверь, что выводится на печать при вызове функции printText()
    // и объясни, почему не происходит переопределение метода privatePrint()
    private fun privatePrint() { // новая функция
        println("Печать из класса ChildrenClass")
    }
    override fun generate(): String {
        return "Это генерация из дочернего класса"
    }
}