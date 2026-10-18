package org.example.lessons.lesson13
fun main() {


//Создание и Инициализация
    val fruitsPrices = mapOf("apple" to 2.99, "banana" to 1.99, "cherry" to 3.99)

//Пара Pair используется в качестве переносчика объекта - курьера, а Map.Entry - для хранения этих объектов
// внутри словаря

//Работа с Map.Entry в Kotlin
//В Kotlin каждая пара ключ-значение в словаре представлена объектом Map.Entry.
// Этот объект хранит ключ и значение как свойства key и value соответственно.
// Работа с Map.Entry позволяет нам получить доступ к ключу и значению каждой пары в словаре.
//
//Доступ к Элементам Словаря через Map.Entry
//Когда вы итерируете словарь, каждый элемент, с которым вы работаете в цикле, является объектом Map.Entry.
// Вот как можно получить доступ к ключам и значениям:

    for (entry in fruitsPrices.entries) { // entries - хранит в себе множество всех ячеек ключ-значение
        //т.к. entries -это множество/коллекция, то нам предоставляется возможность,
        //с помощью цикла for перебирать элементы этой коллекции
        println("Key: ${entry.key}, Value: ${entry.value}")
    }
//Альтернативно, можно использовать деструктуризацию для получения ключа и значения напрямую:
   //  for (entry in fruitsPrices.entries) - структура
    //  for ((key, value) in fruitsPrices) - деструктуризацию

    for ((key, value) in fruitsPrices) { // key, value - название переменных
        // in разбивает словарь fruitsPrices на объекты которые преобразуются автоматически на ключ-значения
        println("Key: $key, Value: $value")
    }
//Почему мы изучали Pair а не Map.Entry?
//Дело в том, что класс Pair не является частью класса Map а используется как контейнер для
// удобной инициализации начальных значений. На этом его функция завершается, дальше Pair может быть в
// Map только в качестве данных, например в качестве ключа или значения.
//
//Map.Entry в свою очередь является составляющей класса Map.
// Стандартная библиотека не позволяет создавать объект Map.Entry отдельно
// (но для особо настырных, можно использовать анонимные объекты).
//
//В дальнейшей работе со словарём Kotlin предлагает нам методы для работы как отдельно с ключами или значениями,
// так и для работы с Map.Entry который является по сути контейнером для ключа и значения.


    //Получение Элементов
           // entries, keys, values
    val entries = fruitsPrices.entries // entries вернем нам множества Set из объектов Map.Entry
    val keys = fruitsPrices.keys // через keys можем получить множество ключей, потому что ключи уникальные и
    // хранить их в множестве логичнее
    val values = fruitsPrices.values //через values вернет нам коллекцию из значений или список,
    // а список означает что значения будут не уникальными
    println(entries)
    println(keys)
    println(values)

   /// getOrElse, getValue, getOrDefault
    val priceOfPearOrElse = fruitsPrices.getOrElse("pear") { 9999.99 } // взять элемент по индексу,
    // если такого индекса нет то создаст какое-то значение { 9999.99 },
    // в словаре у нас индексов нет то в данном случае get оперирует ключами
    // getOrElse позволяет  нам выполнить какую-то функцию
    val t: Double= fruitsPrices["fjjgf"] //[] квадратные скобки это функция get
    // если ключа такого нет то функция get вернет нам null
    val priceOfApple = fruitsPrices.getValue("apple") // getValue возвращает notNullbn[нотналобн] объект
    // а если объекта не могло быть и не было исключения то данная функция упадет
    val priceOfPearOrDefault = fruitsPrices.getOrDefault("pear", 0.0)
    // Default - это базовое состояние, если элемента нету то будет возвращено како-то дефолтное значение
    // getOrDefault - используем в тех случаях когда нужно вернуть ноль

  ////  Изменение состава словаря

    val fruitsWithoutBanana = fruitsPrices - "banana" // создание нового словаря в котором нет "banana"
    val fruitsWithPineapple = fruitsPrices + ("pineapple" to 3.5) // создание нового словаря с дополнительной парой
    val mutableFruits = fruitsPrices.toMutableMap() // Создание нового изменяемого словаря с теми же значениями
    mutableFruits["kiwi"] = 2.75 // Добавление элемента. В квадратных скобках указываем ключ и ключу присваиваем значение
    mutableFruits.putAll(mapOf("lime" to 1.1, "avocado" to 1.9)) // создается новый словарь и в него
    // Добавляются элементы
    mutableFruits + mapOf("lime" to 1.1, "avocado" to 1.9) // Не добавляет данные в существующий словарь а создаёт новый,
    // в который включены данные из обоих словарей
    mutableFruits.remove("apple") // Удаление элемента
    mutableFruits.clear() // Очистка словаря если он изменяемый

    // Проверка наличия элементов
    ////////////containsKey, containsValue, isEmpty, isNotEmpty

    val containsApple = fruitsPrices.containsKey("apple") // проверит есть ли ключ в словаре
    val containsValue1_5 = fruitsPrices.containsValue(1.5) // проверит если значение в словаре
    val isEmpty = fruitsPrices.isEmpty()
    val isNotEmpty = fruitsPrices.isNotEmpty()
    val areAllFruitsExpensive = fruitsPrices.all { it.value > 1.0 } // эта функция скажет все ли значения в словаре >1.0,
    // то есть он берет каждый элемент этого словаря через it и проверяет > 1.0 и записывает true или false и
    // так следующий проверяет. Все должно быть истина тогда all вернет истину
    val isAnyFruitCheap = fruitsPrices.any { it.value < 1.0 } // означает любой
    // если любой, т.е. если хотя бы один соответствует этому значению < 1.0 то будет true

  //  Фильтрация и преобразование
  //////  filter, filterKeys, filterValues, filterNot, count

    val filteredByPrice = fruitsPrices.filter { it.value > 1.0 } // создает новый словарь в котором есть лишь отфильтрованные элементы
    val filteredByKeys = fruitsPrices.filterKeys { it.startsWith("a") }// создает новый словарь в котором есть лишь отфильтрованные элементы
    val filteredByValues = fruitsPrices.filterValues { it < 2.0 }// создает новый словарь в котором есть лишь отфильтрованные элементы
    val filteredNotApple = fruitsPrices.filterNot { it.key == "apple" }// создает новый словарь в котором есть лишь отфильтрованные элементы
    // проверяет сначала условие а потом его переворачивает благодаря Not
    val countExpensiveFruits = fruitsPrices.count { it.value > 1.5 } // это функция которая посчитает количества
    // в скобках можем задать фильтр для подсчета количества, то есть он сначала отфильтрует по условию
// а потом по count подсчитает количество отфильтрованного

    // map, mapKeys, mapValues

    val increasedPrices: Map<String, Double> = fruitsPrices.mapValues { it.value * 1.1 }
    val fruitNamesUppercase = fruitsPrices.mapKeys { it.key.uppercase() } // создает новый словарь в котором изменяются ключи
    // и они будут при помощи uppercase в верхнем регистре и может даже измениться тип
    val fruitsList = fruitsPrices.map { "${it.key} costs ${it.value}" }// map преобразует одену ячейку словаря в элемент списка

  /////  Преобразование в Map и MutableMap
    val toMap = mutableFruitsPrices.toMap()
    val toMutableMap = fruitsPrices.toMutableMap()

//    Эти примеры демонстрируют основные методы работы со словарями в Kotlin,
//    начиная от создания и получения элементов до фильтрации, преобразования и работы с изменяемыми словарями.
//    Создание переменных для хранения результатов делает код более читаемым и позволяет легко
//    увидеть результаты выполнения каждого метода.

////    Итерация с forEach
///    С использованием деструктуризации

    fruitsPrices.forEach { (fruit, price) ->
        println("$fruit costs $price")
    }
    /// С использованием it как объекта Map.Entry

            fruitsPrices.forEach {
                println("${it.key} costs ${it.value}")
            }
 ///   Размер словаря
  ////          size и count
    fruitsPrices.size // количество ключей
    fruitsPrices.count() // тоже количество ключей
    fruitsPrices.count { it.value > 2 } // количество ключей если сначала применить фильтрацию по условию
}