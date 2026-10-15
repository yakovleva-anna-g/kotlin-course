package org.example.lessons.lesson12

val numbers = listOf(-1, 2, -3, 4, -5, 8, 264)
fun main() {

//    Итерация коллекции через forEach
//   Функция forEach работает как цикл, перебирая каждый элемент коллекции,
//   помещая его в специальную переменную 'it' и выполняет блок кода с каждым элементом коллекции.

//    Почему используется it?
//    Удобство: Не нужно придумывать имя переменной для каждого элемента.
//    Ясность: Код становится короче и читается проще.
//    Стандарт: Это общепринятый способ обращения к элементу в подобных ситуациях в Kotlin.
//    Можно запомнить так: it в переводе означает "это", например "этот элемент коллекции".
    // Так же это сокращение от item (элемент) или от iteration (итерация).
//    Итак, it — это просто способ сказать "тот элемент, который я сейчас рассматриваю".

    //   Рассмотрим два примера:
    val positive = mutableListOf<Int>()
// перебор через цикл:
    for (i in numbers) {
        val isPositive = i > 0 // если выполнится это условие i > 0, то в переменную попадет true
        // т.е. проверяем что число положительное, то добавлять его в список
        if (isPositive) { //
            positive.add(i)
        }
    }
//    numbers.forEach {it:Int
//        // it - это специальная переменная по умолчанию в Kotlin для
//        // хранения значения коллекции из текущей итерации
//        val isPositive = it > 0
//        if (isPositive) {
//            positive.add(it)
//        }
//    }

    // Фильтрация коллекций

    fun filter(collection: List<Int>): List<Int> { // придумали цикл с фильтром
        val result = mutableListOf<Int>()
        for (i in collection) {
             if (i in 7..17) result.add(i)
        }
        return result
    }

    val list = listOf(8, 56, 23, 87, 12, 18, 11) // создаем список
    val filtered1 = filter(list) // вызываем метод список и передаем ему список и происходит фильтрация
    println(filtered1) // получаем результат и распечатываем.
    // Это типичная ситуация когда мы обрабатываем какие-то данные в коллекции через фильтр

    val filtered1 = list.filter { // встроенный метод для фильтра
        // функция фильтр будет проверять каждую цифру на условие
        // если в ходе проверки элемент не проходит это условие то получает false и не попадает в список
        // функция filter формирует новый список не изменяет изначальный listOf и этот список попадает
        // в переменную которую задали - positiveNumbers
        it in 7..17
    }
    println(filtered2)

    // через лямбда выражения
    val filtered2 = list.filter {it in 7..17} // {it in 7..17} - лямбда выражения


    val positiveNumbers = listOf(8, 56, 23, 87, 12, 18, 11).filter { it > 0 }
    println(positiveNumbers) // Вывод: [2, 4]

    // filterNot будет проверять условие { it > 0 } и переворачивать его наоборот
   //  Похож на filter, но выбирает элементы, которые не соответствуют условию.
    val notPositiveNumbers = numbers.filterNot { it > 0 }
    println(notPositiveNumbers) // Вывод: [-1, -3, -5]

//    filterNotNull
//    Используется для отбрасывания всех null значений из коллекции.
//    Пример: Удалить null элементы из списка.

    val nullableList = listOf(1, null, 2, null, 3)
    val nonNullList = nullableList.filterNotNull()
    println(nonNullList) // Вывод: [1, 2, 3]


//    Получение первого или последнего элемента коллекции
//    В массивах и списках мы можем взять первый элемент списка по индексу 0.
//    В множествах set нет индексов, но иногда бывает нужно взять первый элемент множества.
//    Для этого можно использовать метод first().
//    Так же бывает необходимость взять последний элемент коллекции.
//    В массивах и списках порой нужно вычислять индекс последнего элемента, что не очень удобно,
//    а в множествах индексов и вовсе нет. Эту задачу легко решает метод last().

    val setOfNumbers = setOf(3, 4, 5, -5, 14)
    val firstElement = setOfNumbers.first() // взять первый элемент
    val lastElement = setOfNumbers.last() // взять последний элемент. last - проходит по всем элементам цепочки
    println(firstElement)
    println(lastElement)


//    Получение элемента с условием, что его может не быть

//    firstOrNull и getOrElse
//    firstOrNull или lastOrNull возвращает первый или последний элемент, который соответствует условию,
//    или null, если такого элемента нет.
//    getOrElse возвращает элемент по индексу или значение по умолчанию, если индекс вне диапазона списка.

    val firstPositive = numbers.firstOrNull { it > 0 }
    println(firstPositive) // Вывод: 2
    val nullable = numbers.firstOrNull { it > 1000 } // если в списке ни одного положительного числа то вернется null
    println(nullable) // Вывод: null
   //  val elementOrElse = numbers.getOrElse(10, { -1 }) // { -1 } - это второй аргумент
    val elementOrElse = numbers.getOrElse(10) { -1 } // если такого индекса нет,
    // то мы через функцию { -1 } говорим что нам вернуть в этом случае, то есть в данном случае будет возвращена -1
    println(elementOrElse) // Вывод: -1

    // Преобразование коллекций
    // Преобразование - это цикл который берет каждый элемент и преобразует его с помощью функции во все что угодно
           // map
    // Преобразует каждый элемент коллекции согласно заданной функции.

    // Пример: Увеличить каждое число в списке на 1.

    val incrementedNumbers = numbers.map { it + 1 }
    println(incrementedNumbers) // Вывод: [0, 3, -2, 5, -4, 9, 265]

    // но если сделаем:
    val incrementedNumbers = numbers.map { "${it + 1}" } // мы увеличили каждый элемент списка на 1
    // а потом все это преобразовали в строку и мы получили список строк

    val incrementedNumbers = numbers.map { it > 0 } // List<Boolean> то будет список из true и false

    //associate [асошиэйт] преобразует список в словарь
    // Создает словарь (Map) из списка, используя предоставленную функцию для генерации ключей.
    // Пример: Создать словарь, где каждому числу соответствует его квадрат.

    val numberSquareMap: Map<Int, Int> = numbers.associate { it to it * it } // формула преобразования { it to it * it }
    println(numberSquareMap) // Вывод: {-1=1, 2=4, -3=9, 4=16, -5=25, 8=64, 264=69696}

    val numberSquareMap1: Map<Int, Boolean> = numbers.associate { it to ((it*it) > 0 )}

    // flatten
    // Склеивает каждую коллекцию в коллекции между собой в одну общую коллекцию.
    // flatten [флатен] вызывается> у списка

    val multipleList: List<List<Int>> = listOf(
        listOf(1, 2, 3),
        listOf(4, 5, 6)
    )
    val flattenList: List<Int> = multipleList.flatten()
    println(flattenList) // получилось: [1, 2, 3, 4, 5, 6]

    // flatMap
    // Выполняет одновременно преобразование вложенных коллекций и склеивание в одну общую коллекцию.

    val flattenListAfterMapping = multipleList.flatMap {list ->
        list.map { it * 2 }
    }
    println(flattenListAfterMapping)

    //joinToString
   // Преобразует все элементы коллекции в строки и объединяет их в одну строку с заданным разделителем.
    // По умолчанию используется разделитель запятая с пробелом - ", ".

   // Пример: Преобразовать список чисел в строку, разделенную двоеточием.

    val numbersString = numbers.joinToString(separator = " : ")
    println(numbersString) // Вывод: "-1 : 2 : -3 : 4 : -5 : 8 : 264"

// по умолчанию используется сепаратор с запятой, т.е.

    val numbersString1 = numbers.joinToString()
    println(numbersString) // Вывод: "-1, 2, -3, 4, -5, 8, 264"

   // Сортировка Коллекций
           // sorted
    //коллекции - это какие-то наборы данных и эти наборы данных можно всегда каким-то образом сортировать

    // сортирует элементы коллекции в возрастающем порядке.

    val sortedNumbers = numbers.sorted()
    println(sortedNumbers) // Вывод: [-5, -3, -1, 2, 4, 8, 264]

    // sortedDescending
  //  сортирует элементы в убывающем порядке.

    val sortedDescendingNumbers = numbers.sortedDescending()
    println(sortedDescendingNumbers) // Вывод: [264, 8, 4, 2, -1, -3, -5]

   // Длина коллекции
       //     size возвращает длину коллекции.

    println(numbers.size)

    //Удаление элементов коллекции
    val elements = mutableListOf(23, 6, 76, 4)

    elements.remove(6) // удалит объект 6 из списка или множества
    elements.removeAt(3) // удалит объект с индексом 3 (работает только со списком)

    //Проверка коллекции
         //   isEmpty
    //Проверяет, является ли коллекция пустой

    if (numbers.isEmpty()) {
        println("Коллекция пуста")
    } else {
        println("В коллекции ${numbers.size} значений")
    }
    // isNotEmpty
    //Проверяет, что коллекция не пустая. Команда противоположна предыдущей.

    //contains
    //Проверяет, что коллекция содержит нужный элемент.

    if (numbers.contains(42)) {
        println("Коллекция содержит ответ на главный вопрос")
    } else {
        println("В коллекции нет ответа на главный вопрос")
    }
    //Так же можно использовать оператор in.

    if (42 in numbers) {
        println("Коллекция содержит ответ на главный вопрос")
    } else {
        println("В коллекции нет ответа на главный вопрос")
    }
    //containsAll
    //Проверяет вхождение одной коллекции в другую.

    if (setOfNumbers.containsAll(listOf(4, 3))) {
        println("Коллекция содержит числа 4 и 3, при этом порядок не имеет значения")
    } else {
        println("В коллекции нет одного из чисел либо всех проверяемых чисел")
    }
    //Другие полезные методы
    //sum
    //sum возвращает сумму всех элементов списка чисел.

    val sumOfNumbers = numbers.sum()
    println(sumOfNumbers) // Вывод: 269

    //average
    //возвращает среднее значение элементов списка чисел.

    val averageOfNumbers = numbers.average()
    println(averageOfNumbers) // Вывод: 38.42857142857143

    //maxOrNull и minOrNull
    //maxOrNull возвращает максимальный элемент списка или null, если список пуст.

    //minOrNull возвращает минимальный элемент или null.

    val maxNumber = numbers.maxOrNull()
    println(maxNumber) // Вывод: 264
    val minNumber = numbers.minOrNull()
    println(minNumber) // Вывод: -5

    //groupBy
    //Группирует элементы коллекции по заданному критерию.

    ///Пример: Группировка чисел по положительным и отрицательным.

    val groupedBySign = numbers.groupBy { if (it > 0) "Positive" else "Negative" }
    println(groupedBySign) // Вывод: {Negative=[-1, -3, -5], Positive=[2, 4, 8, 264]}

    //distinct
    //Возвращает список, содержащий только уникальные элементы из исходного списка.

    val distinctNumbers = listOf(1, 2, 2, 3, 3, 3, 4).distinct()
    println(distinctNumbers) // Вывод: [1, 2, 3, 4]

    //take
   // Возвращает первые n элементов списка

    println(numbers.take(3)) // Вывод: [-1, 2, -3]

    //takeLast
   // Возвращает последние n элементов

            println(numbers.takeLast(3)) // Вывод: [-5, 8, 264]
    //drop
    //Возвращает всю коллекцию за исключением первых нескольких элементов

            println(numbers.drop(2)) // [-3, 4, -5, 8, 264]



//    Задачи на приведение коллекции к значению
//    1.Проверить, что размер коллекции больше 5 элементов.
    val ex1 = listOf(1, 2, 3, 4, 5, 6)
    println(ex1.size>5)

//    2.Проверить, что коллекция пустая
    println(ex1.isEmpty())

//    3.Проверить, что коллекция не пустая
    println(ex1.isNotEmpty())

//    4.Взять элемент по индексу или создать значение если индекса не существует
    println(ex1.getOrElse(index = 1){123})

//    5.Собрать коллекцию в строку
    println(ex1.joinToString { })

//    6.Посчитать сумму всех значений
    println(ex1.sum())

//    7.Посчитать среднее
    println(ex1.average())
//    8.Взять максимальное число
    println(ex1.maxOrNull())

//    9.Взять минимальное число
    println(ex1.minOrNull())
//    10.Взять первое число или null
//    11.Проверить что коллекция содержит элемент

}