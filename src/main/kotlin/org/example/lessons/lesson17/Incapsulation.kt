package org.example.lessons.lesson17

//Инкапсуляция — это один из основных принципов ООП.
// Он играет ключевую роль в управлении доступом к данным и методам класса,
// защищая данные от некорректных изменений и предотвращая исполнение методов,
// не предназначенных для прямого вызова извне. Инкапсуляция позволяет скрыть детали реализации класса,
// предоставляя внешнему миру только необходимый интерфейс для взаимодействия с объектом.
//
//Инкапсуляция в Kotlin
//
//В Kotlin инкапсуляция реализуется с помощью модификаторов доступа:
// private, protected, internal и public.
// Эти модификаторы определяют уровень доступа к классам, полям, методам и конструкторам в вашем коде.
//
//Private: Члены класса доступны только внутри этого класса.
//Protected: Члены класса доступны внутри класса и в производных классах.
//Internal: Члены класса доступны в любом месте того же модуля.
//Public: Члены класса доступны отовсюду, где есть доступ к классу.


//class Account(private var balance: Double) { // это поле инкапсулировано в класс
//
//    fun deposit(amount: Double) {
//        if (amount > 0) {
//            balance += amount
//        }
//    }
//
//    fun getBalance(): Double {
//        return balance
//    }
//
//    fun withdraw(amount: Double): Double {
//        if (amount > 0) {
//            val withdraw = min(amount, balance)
//            balance -= withdraw
//            return withdraw
//        }
//        return 0.0
//    }
//}
//
//fun main() {
//
//    val account = Account(0.0)
//    account.deposit(15.0)
//    println("Текущий баланс ${account.getBalance()}")
//    println("Хочу снять 12 и получаю ${account.withdraw(12.0)}")
//    println("Текущий баланс ${account.getBalance()}")
//    println("Хочу снять 10 но получаю ${account.withdraw(10.0)}")
//    println("Текущий баланс ${account.getBalance()}")
//}
//
//
//// Примеры с наследованием
//
//open class Person(private val name: String, protected val age: Int) {
//    // Публичный метод
//    fun greet() {
//        secret()
//        println("Привет, меня зовут $name.")
//    }
//    // Защищённый метод
//    protected fun getName(): String {
//        return name
//    }
//    // Приватный метод
//    private fun secret() {
//        println("Это секретный метод.")
//    }
//}
//
//class Student(
//    name: String,
//    age: Int,
//    val studentId: Int
//) : Person(name, age) {
//    // Публичный метод
//    fun study() {
//        // Используем защищённый метод getName() из родительского класса
//        println("${getName()} (id: $studentId) учится.")
//    }
//    fun showAge() {
//        // Обращаемся к защищённому полю age из родительского класса
//        println("Мне $age лет.")
//    }
//    fun tryAccessSecret() {
////         Попытка вызвать приватный метод secret() из родительского класса
////         secret() // Ошибка компиляции: метод secret() недоступен
//    }
//}
//fun main() {
//    val student = Student("Алексей", 20, 12345)
//    student.greet()        // Вывод: Это секретный метод. \n Привет, меня зовут Алексей.
//    student.study()        // Вывод: Алексей учится.
//    student.showAge()      // Вывод: Мне 20 лет.
//    println(student.studentId)
////    println(student.name)
////    println(student.age)
////    student.secret()    // Ошибка: метод secret() недоступен
//    student.tryAccessSecret()
//}

//Практические задания
//Инкапсуляция полей
//Класс "Лампа": Разработайте класс Lamp с приватными полями isOn (включена ли лампа)
// и публичными методами turnOn() и turnOff() для управления состоянием лампы.

class Lamp(){
    private var isTurnedOn = false
    fun turnOn() {
        isTurnedOn = true
    }
    fun turnOff() {
        isTurnedOn = false
    }
}
