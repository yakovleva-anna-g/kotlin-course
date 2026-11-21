package org.example.lessons.lesson21.homeworks

//Задача 1
//
//Напишите функцию analyzeDataType, принимающую параметр типа Any.
// Функция должна определить тип аргумента и вывести соответствующее сообщение:
//
//Для строки: "Это строка: [значение]".
//Для любого числа: "Это число: [значение]".
//Для списка: "Это список, количество элементов: [количество]".
//Для словаря: "Это словарь, количество пар: [количество]".
//Для остальных типов: "Неизвестный тип данных".
//Используйте оператор is для проверки типов.

fun analyzeDataType(arg: Any): String {
if (arg is String) {
    return "Это строка: $arg"
}
    if (arg is Number) {
        return "Это число: $arg"
    }
    if (arg is List<*>) // здесь звездочка потому что мы не знаем из каких элементов состоит список
        return "Это список, количество элементов: ${arg.size}"
    if (arg is Map<*,*>) {
        return "Это словарь, количество пар: ${arg.size}" // (у Map size — число записей);
    }
    else {
        return "Неизвестный тип данных"
    }
}

fun analyzeDataType1(arg: Any): String {
    return when {
        arg is String -> "Это строка: $arg"
        arg is Number -> "Это число: $arg"
        arg is List<*> -> "Это список, количество элементов: ${arg.size}"
        arg is Map<*,*> -> "Это словарь, количество пар: ${arg.size}"
        else -> "Неизвестный тип данных"
    }
}

//Задача 2
//
//Создайте функцию safeCastToList, принимающую параметр типа Any и возвращающую размер списка,
// если аргумент можно безопасно привести к типу List.
// В случае неудачного приведения функция должна возвращать -1.
// Используйте as? для безопасного приведения типа.

fun safeCastToList(parameter: Any): Int{
        return (parameter as? List<*>)?.size ?: -1
    // ?.size — если не null — взять размер; если null — всё выражение станет null;
    //?: -1 — если слева null — вернуть -1;
    }

fun  safeCastToList1(parameter: Any): Int{
    val list = parameter as? List<*>
    return if (list !=null) {
        list.size
    } else {
        -1
    }
}

//Задача 3
//
//Создайте функцию getStringLengthOrZero, которая принимает параметр типа Any? и возвращает длину строки,
// если аргумент можно привести к типу String. В случае, если аргумент равен null или не является строкой,
// функция должна возвращать 0.

fun getStringLengthOrZero (parameter1: Any?): Int {
    return (parameter1 as? String)?.length ?: 0
}

//Задача 4
//
//Создайте функцию-расширение класса Any toSquare.
// Функция гарантированно вызывается у числа
// (в виде числа или строки, например 4 или 4.2 или “4.2”)
// и должна вернуть квадрат этого числа.
// Если придёт число, его нужно возвести в квадрат, если придёт строка,
// то его нужно преобразовать в число через функцию toDouble() и возвести в квадрат.

fun Any.toSquare(): Double {
    val number = (this as? Number)?.toDouble()
        ?: (this as String).toDouble()
    return number*number
}

// Левая часть ?:: (this as? Number)?.toDouble()
//
//this as? Number — безопасное приведение к Number:
//
//если this число (Int, Double, Float, Long) → вернёт его как Number;
//если this строка (String) → вернёт null;
//?.toDouble() — если не null → вызвать toDouble() (метод Number) → получить Double;
//если левая часть была null — всё выражение даст null.
//Итог левой части: Double? — либо число, либо null (если this — не Number).
//
//Правая часть ?:: (this as String).toDouble()
//
//this as String — жёсткое приведение к String (без ?);
//.toDouble() — парсит строку в Double;
//выполнится только если левая часть вернула null.

//без оператора Элвиса
fun Any.toSquare1(): Double {
    val number: Double
    if (this is Number) {
        number = this.toDouble()
    } else {
        number = (this as String).toDouble()
    }
    return number * number
}


//Задача 5
//
//Напишите функцию sumIntOrDoubleValues,
// которая принимает список элементов типа Any
// и возвращает сумму всех целочисленных (Int)
// и вещественных (Double) значений в списке.
// Все остальные типы должны быть проигнорированы.

fun sumIntOrDoubleValues(arg5: List<Any>): Double {
    return arg5.sumOf { (it as? Int)?.toDouble() ?: (it as? Double) ?: 0.0 }
}

// Шаг 1: (it as? Int)?.toDouble()
//
//it as? Int — безопасное приведение:
//
//если элемент — Int → вернёт его (тип Int?);
//если нет → null;
//?.toDouble() — если не null → вызвать toDouble() → получить Double;
//если левая часть была null — всё выражение даст null.
//Результат шага — Double?: число из Int или null.
//
//Шаг 2: ?: (it as? Double)
//
//если шаг 1 дал null — выполняется правая часть;
//it as? Double — безопасное приведение:
//
//если элемент — Double → вернёт его (тип Double?);
//если нет → null.
//Результат шага — Double?: значение как Double или null.
//
//Шаг 3: ?: 0.0
//
//если и шаг 2 дал null — значит, элемент не Int и не Double;
//возвращаем 0.0 — нейтральное значение для суммы (не влияет на результат).
//Результат — всегда Double (не Double?)