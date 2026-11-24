package org.example.lessons.lesson22.homeworks

//Воспроизвести фрагменты кода, которые могут привести к возникновению исключений:
fun main() {
// 1.NullPointerException - IOException: Исключения, связанные с вводом-выводом.
try {
val text: String? = null
    println(text!!.length) // читается так: Напечатай длину строки text предварительно утвердив,
// что text не null
} catch (e: NullPointerException) {
    println("NullPointerException")
}

// 2.IndexOutOfBoundsException -
// RuntimeException: Исключения времени выполнения,
// которые могут быть выброшены во время выполнения программы из-за ошибок
// в логике программы (например, NullPointerException, IndexOutOfBoundsException).
// Возникает, когда код обращается к элементу коллекции/массива/строки по индексу,
// которого не существует.

 //   IndexOutOfBoundsException
 //   ├── ArrayIndexOutOfBoundsException    (массивы)
 //   └── StringIndexOutOfBoundsException   (строки)

  //  List.get() → бросает IndexOutOfBoundsException (напрямую)

    val list = listOf("a", "b", "c")
  try {
      println(list[10])
  } catch (e: IndexOutOfBoundsException) {
      println("I00BE #2: список, индекс 10 при размере ${list.size}")
  }

// 3.ClassCastException
// ClassCastException — подкласс RuntimeException — исключение времени выполнения.
// Возникает при неудачном приведении типа через оператор as —
// когда объект на самом деле не является тем типом, к которому его приводят.

    val ex3: Any = 42
    try {
        val s = ex3 as String // приводит Int к String
        println(s.length)
    } catch (e: ClassCastException) { // catch ловит, программа продолжает работать
        println("It is ClassCastException" )
    }

// 4.IllegalArgumentException

// IllegalArgumentException — подкласс RuntimeException — исключение времени выполнения.
// Возникает, когда метод получает аргумент, который не подходит по смыслу:
// отрицательное число там, где нужно положительное,
// пустая строка там, где нужна непустая,
// значение вне допустимого диапазона и т.д.

// Два способа возникновения:
//
//Явно — программист бросает сам (через throw или require);
//Неявно — стандартная функция Kotlin бросает сама, если аргумент некорректен.

try {
    throw IllegalArgumentException("Недопустимый аргумент")
} catch (e: IllegalArgumentException) {
    println("It is IllegalArgumentException")
}


// 5.NumberFormatException  — подкласс IllegalArgumentException
// (а тот — подкласс RuntimeException). Возникает, когда строка не может быть преобразована
// в число: содержит буквы, спецсимволы, пробелы внутри,
// пустая или имеет неверный формат для выбранного типа.

    try {
        val  number = "".toInt() // пустая строка не число и падает;
    } catch (e: NumberFormatException) {
        println("It is NumberFormatException")
    }

// 6.IllegalStateException - подкласс RuntimeException.
// Возникает, когда метод вызывается в неподходящий момент:
// объект находится в таком состоянии, что операция невозможна.

    try {
        throw IllegalStateException("Недопустимое состояние")
    } catch (e: IllegalStateException) {
        println("It is IllegalStateException")
    }


// 7.OutOfMemoryError

// Exception: Ситуации, которые программа может и должна обработать
// (неверный ввод, отсутствующий файл, деление на ноль).
//Error: Серьёзные проблемы, которые обычно не предполагают обработки.
// OutOfMemoryError относится именно к этой ветви.

// Самый надёжный способ — заставить программу бесконечно создавать объекты,
// которые не удаляются сборщиком мусора. Классический пример —
// бесконечное добавление записей в HashMap, который хранится в памяти,
// пока работает программа.
    val memoryLeakMap = HashMap<Int, String>()
    var counter = 0
try {
while (true){
    memoryLeakMap[counter] = "Large String ".repeat(1000) + counter
    counter++
}
} catch (e: OutOfMemoryError) {
    println("In is OutOfMemoryError")
}
// 8.StackOverflowError - подкласс Error (как и OutOfMemoryError), а не Exception.
// Возникает, когда стек вызовов переполняется — обычно из-за бесконечной рекурсии
// или слишком глубокой.

    // Как устроен стек:
    //
    //у каждого потока — свой стек вызовов;
    //при вызове метода — на стек кладётся новый фрейм (аргументы, локальные переменные,
// адрес возврата);
    //стек ограничен (обычно 512 КБ–1 МБ по умолчанию);
    //если фреймов больше, чем влезает — JVM бросает StackOverflowError.
    //В отличие от OutOfMemoryError (куча), здесь исчерпывается именно стек вызовов.

    fun recurse(): Int {
        return recurse() + 1
    }

        try {
            recurse()
        } catch (e: StackOverflowError) {
            println("It is StackOverflowError")
        }
    }

}