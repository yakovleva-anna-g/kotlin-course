package org.example.lessons.lesson13.homeworks

import org.example.lessons.lesson10.map

fun main() {


//Для решения каждой задачи постарайтесь использовать наиболее подходящий метод,
// не повторяясь с решением других задач.

// 1.Дан словарь с именем и временем выполнения каждого автоматизированного теста в секундах.
// Определите среднее время выполнения теста.
    val averageTime = mapOf<String, Double>()
    val ex1 = averageTime.values.average()


// 2.Имеется словарь с метаданными автоматизированных тестов, где ключи — это имена тестовых методов
// а значения - строка с метаданными. Выведите список всех тестовых методов.
    val autoTest = mapOf<String, String>()
    val testMethods = autoTest.keys
///.keys - возвращает множество Set ключей

// 3.В изменяемый словарь с данными о прохождении тестов добавьте новый тест и его результат.
    val mutableTest = mutableMapOf(1 to "ghgh", 2 to "regffg")
    val ex3 = mutableTest.put(3, "fjjbg")
    println(ex3)

println("=======3=====")
// 4.Посчитайте количество успешных тестов в словаре с результатами (ключ - название,
// значение - результат из passed, failed, skipped).
    val test = mapOf<Int, String>(1 to "passed", 2 to "failed", 3 to "skipped", 4 to "passed")

// val testEx4 = test.entries.count{it.value== "passed"}
    val testEx4 = test.values.count { it == "passed" }
    println(testEx4 )

    println("=======4=====")
// 5.Удалите из изменяемого словаря с баг-трекингом запись о баге,
// который был исправлен (ключ - название, значение - статус исправления).

    val bugTracking =
        mutableMapOf<String, String>("title1" to "assigned", "title2" to "fixed", "title3" to "inProgress")
    val bugTrackingEx5 = bugTracking.values.remove("fixed")
    println(bugTrackingEx5)

    println("=======5=====")
// 6.Для словаря с результатами тестирования веб-страниц (ключ — URL страницы, значение — статус ответа),
// выведите сообщение о странице и статусе её проверки.
    val testWeb = mapOf("URL1" to 404, "URL2" to 500, "URL3" to 200)
//for (entry in testWeb.entries) {
//    println("Сообщение о странице: ${entry.key}, Статус проверки: ${entry.value}")
//}
    for ((url, status) in testWeb) {
        println("Сообщение о странице: $url, Статус проверки: $status")
    }
    println("=======6=====")
// 7.Найдите в словаре с названием и временем ответа сервисов только те,
// время ответа которых превышает заданный порог.

    val titleTime = mapOf("title1" to 4.44, "title2" to 5.86, "title3" to 8.32)
    //val titleTimeEx7 =
    println(titleTime.filter { it.value > 5.0 })

    println("=======7=====")
// 8.В словаре хранятся результаты тестирования API (ключ — endpoint, значение — статус ответа в виде строки).
// Для указанного endpoint найдите статус ответа, если endpoint отсутствует, предположите,
// что он не был протестирован.
    val resultAPI = mapOf("endpoint1" to "200 OK", "endpoint2" to "400 Bad Request", "endpoint3" to "401 Unauthorized")
    val resultAPIEx8 = resultAPI.getOrDefault("endpoint5", "не был протестирован")
    println(resultAPIEx8)

    println("=======8=====")
// 9.Из словаря, содержащего конфигурации тестового окружения (ключ — название параметра конфигурации,
// значение - сама конфигурация), получите значение для "browserType". Ответ не может быть null.

    val testEnvironment = mapOf<String, List<String>>("log" to listOf("INFO", "DEBUG"),  "mocks" to listOf("true" ,"false"), "browserType" to listOf("chrome", "firefox"))
    println(testEnvironment.getValue("browserType"))
    println("=======9=====")
// 10.Создайте копию неизменяемого словаря с данными о версиях тестируемого ПО, добавив новую версию.

    val versions = mapOf("ПО1" to "163.736", "ПО2" to "8374.49.03")
    val copiVersions = versions.toMutableMap()
    copiVersions["ПО3"] = "378.0"
println(copiVersions)

// 11.Используя словарь с настройками тестирования для различных мобильных устройств (ключ — модель устройства,
// значение - строка с настройками), получите настройки для конкретной модели или верните настройки по умолчанию.
val mobilForTest = mapOf("iPhone 14" to "Экран 6.1 дюйма, iOS 16, Safari", "Samsung Galaxy S23" to "Экран 6.5 дюйма, Android 13, Chrome")
println(mobilForTest.getOrElse(key = "iPhone 15"){"настройки по умолчанию"})

//    get(key) — базовый доступ
//    fun <K, V> Map<K, V>.get(key: K): V?
//    возвращает значение по ключу;
//    если ключа нет — возвращает null;
//    тип — V? — nullable.
//
//    val map = mapOf("a" to 1, "b" to 2)
//    map.get("a")    // 1
//    map.get("z")    // null
//    getValue(key) — строгий доступ
//
//    kotlin
//    fun <K, V> Map<K, V>.getValue(key: K): V
//    возвращает значение;
//    если ключа нет — бросает NoSuchElementException;
//    тип — V — не-nullable.

//    getOrDefault(key, defaultValue) — с fallback
//
//    kotlin
//    fun <K, V> Map<K, V>.getOrDefault(key: K, defaultValue: V): V
//    возвращает значение по ключу;
//    если ключа нет — возвращает defaultValue;
//    тип — V — не-nullable.
//    Пример:
//
//    kotlin
//    map.getOrDefault("a", 0)    // 1
//    map.getOrDefault("z", 0)    // 0
//    Когда: дефолт постоянный и простой — например, 0, "", "unknown".
//
//    🎯 getOrElse(key) { ... } — с лямбдой
//
//    kotlin
//    fun <K, V> Map<K, V>.getOrElse(
//        key: K,
//        defaultValue: () -> V
//    ): V
//    возвращает значение по ключу;
//    если ключа нет — вызывает лямбду и возвращает её результат;
//    тип — V — не-nullable.

// 12.Проверьте, содержит ли словарь с ошибками тестирования (ключ - код ошибки, значение - описание ошибки)
// определенный код ошибки.
val errors = mapOf(404 to "Resource not found", 500 to "Internal server error")
    println(errors.containsKey(404)) // true или false

// 13.Дан неизменяемый словарь, где ключи — это идентификаторы тестовых сценариев в формате "TestID_Version",
// а значения — статусы выполнения этих тестов ("Passed", "Failed", "Skipped").
// Отфильтруйте словарь, оставив только те сценарии, идентификаторы которых соответствуют определённой
// версии тестов, то-есть в ключе содержится требуемая версия.
    // length - количество символо (возвращае Int)
    // startsWith - начинается с (возвращает Boolean (true/false)
    // endsWith — заканчивается на (возвращает Boolean (true/false)
    // substring — вырезать часть строки


    val testVersions = mapOf("Test1_v1.0" to "Passed", "Test2_v1.0" to "Failed", "Test3_ve2.0" to "Skipped","Test4_v2.0" to "Failed" )
    println(testVersions.filterKeys { it.endsWith("v1.0") })

// 14.У вас есть словарь, где ключи — это названия функциональных модулей приложения,
// а значения — результаты их тестирования. Проверьте, есть ли модули с неудачным тестированием.

val moduleTests = mapOf("Profile" to "Passed", "Search" to "Failed", "Payment" to "Skipped")
    println(moduleTests.containsValue("Failed")) // true или false

// 15.Добавьте в изменяемый словарь с настройками тестовой среды настройки из другого словаря.

    val testEnv = mutableMapOf("параметр1" to "значение1", "параметр2" to "значение2", "параметр3" to "значение3",)
    val extraSettings = mapOf("параметр4" to "значение4", "параметр5" to "значение5")
    testEnv.putAll(extraSettings)
    println(testEnv)


// 16.Объедините два неизменяемых словаря с данными о багах.

     val bag1 = mapOf("ID1" to "название бага 1", "ID2" to "название бага 2", "ID3" to "название бага 3")
    val bag2 = mapOf("ID4" to "название бага 4", "ID5" to "название бага 5")
   println( bag1+bag2)

// 17.Очистите изменяемый словарь с временными данными о последнем прогоне автоматизированных тестов.
val ex17 = mutableMapOf("runId" to "RUN-2026-10-19-001", "startTime" to "2026-10-19T10:15:00", "browser" to "chrome")
   ex17.clear()
    println(ex17)

// 18.Исключите из отчета по автоматизированному тестированию те случаи, где тесты были пропущены
// (имеют статус “skipped”). Ключи - название теста, значения - статус.

    val ex18 = mutableMapOf("тест1" to "skipped", "тест2" to "Passed", "тест3" to "Failed","тест4" to "skipped")
val filtered = (ex18 - "тест1") - "тест4"
println(filtered)

// 19.Создайте копию словаря с конфигурациями тестирования удалив из него несколько конфигураций.

val ex19 = mutableMapOf("browserType" to "chrome", "log" to "INFO")
    val config = listOf("log")
    val copy = ex19-config
println(ex19)
    println(copy)

// 20.Создайте отчет о тестировании, преобразовав словарь с результатами тестирования
// (ключ — идентификатор теста, значение — результат) в список строк формата "Test ID: результат".

    val testResults = mapOf("Test 1" to "Passed", "Test 2" to  "Failed",  "Test 3" to "Skipped", "Test 4" to "Passed")
    val report = testResults.map { "${it.key}: ${it.value}" }

// 21.Преобразуйте изменяемый словарь с результатами последнего тестирования в неизменяемый для архивации.

// 22.Преобразуйте словарь, содержащий числовой ID теста и данные о времени выполнения тестов,
// заменив идентификаторы тестов на их строковый аналог (например через toString()).

// 23.Для словаря с оценками производительности различных версий приложения (ключи - строковая версия,
// значения - дробное число времени ответа сервера) увеличьте каждую оценку на 10%,
// чтобы учесть новые условия тестирования.

// 24.Проверьте, пуст ли словарь с ошибками компиляции тестов.

// 25.Убедитесь, что словарь с результатами нагрузочного тестирования не пуст.

// 26.Проверьте, прошли ли успешно все автоматизированные тесты в словаре с результатами.

// 27.Определите, содержит ли словарь с результатами тестирования хотя бы один тест с ошибкой.

// 28.Отфильтруйте словарь с результатами тестирования сервисов, оставив только те тесты,
// которые не прошли успешно и содержат в названии “optional”.
}