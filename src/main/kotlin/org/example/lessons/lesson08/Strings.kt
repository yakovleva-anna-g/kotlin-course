package org.example.lessons.lesson08

// Конкатенация(это объединение, склеивания) строк
// val
//Kotlin предоставляет множество функций для работы со строками. Например, можно взять подстроку, разделить строку на части, заменить часть строки и так далее:
//
//val originalString = "Kotlin is fun"
//val subString = originalString.substring(7)  // "is fun"
//val subString2 = originalString.substring(3, 6) // "lin"
//val replacedString = originalString.replace("fun", "awesome")  // "Kotlin is awesome"
//val words = originalString.split(" ")  // ["Kotlin", "is", "fun"]
//val length = "Hello".length  // 5
//val upper = "hello".uppercase()  // "HELLO"
//val lower = "HELLO".lowercase()  // "hello"
//val trimmed = "  hello  ".trim()  // "hello"
//val starts = "Kotlin".startsWith("Kot")  // true
//val ends = "Kotlin".endsWith("lin")  // true
//val contains = "Hello".contains("ell")  // true
//val empty = "".isNullOrEmpty()  // true
//val blank = "  ".isNullOrBlank()  // true
//val repeat = "ab".repeat(3)  // "ababab"
//val letter = originalString[5] // 'n'
//val indexOfChar = "Kotlin".indexOf('t')
//val indexOfWord = "Kotlin is the best language".indexOf("best")
//val backReverse = "niltoK".reversed()

//Правила Проверки и Преобразования:

//Если фраза начинается с "ошибка":
//Преобразование: Замените "ошибка" на "небольшое недоразумение".
//Если фраза заканчивается на "важно":
//Преобразование: Добавьте в конец фразы "…но не критично".
//Если фраза содержит слово "проблема":
//Преобразование: Замените "проблема" на "неожиданность".
//Если индекс слова "срочно" находится в промежутке от 0 до 10:
//Преобразование: Замените "срочно" на "когда-нибудь".
//Если строка пустая:
//Преобразование: Верните "Кажется, кто-то забыл что-то сказать".
//
//fun main() {
//
//    example1("Ошибка в системе вызвала панику.")
//    example1("Для завершения проекта важно.")
//    example1("Обнаружена проблема с сетью.")
//    example1("Срочно нужно обновить данные!")
//    example1("")
//}
//fun example1(phrase: String) {
//    val result = when {
//        phrase.startsWith("ошибка", true) -> phrase.replace("ошибка", "небольшое недоразумение", true)
//        phrase.endsWith("важно.") -> "$phrase …но не критично"
//        phrase.contains("проблема") -> phrase.replace("проблема", "неожиданность")
//        phrase.indexOf("срочно", ignoreCase = true) in 0..10 -> phrase.replace("срочно", "когда-нибудь", ignoreCase = true)
//        phrase.isBlank() -> "Кажется, кто-то забыл что-то сказать"
//        else -> phrase
//    }
//    println(result)
//}
