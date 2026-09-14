package org.example.lessons.lesson04.homework

//// Для каждой переменной добавь тип через двоеточие.
//// Если в строке обнаружишь ошибку в синтаксисе - закомментируй эту строку и над ней напиши что с ней не так.

// ЧИСЛОВЫЕ ТИПЫ
// val myShort: Short = 3200 (целые числа но ограничены от -32768 до 32767)
// val myByte: Byte = 120 (целочисленное число минимального значения от -128 до 127 используют в поточном хранении данных, когда нужно преобразовывать строки в наборы символов)
// val myDouble: Double = (чисо с плавающей запятой, двойная точность в отличии от Float, и количесто символов после запятой может быть много)
// Float используется для хранения десятичных значений дробных небольших величин, еси нужны точные вычиления то его не используем
// Long цлые чсла, но диаозон которых больше чем у Int
// ЛОГИЧЕСКИЙ ТИП
// val myBoolean: Boolean = true или false
// СИМВОЛЬНЫЙ ТИП
// Char - хранит один символ (буква, символ, специальный знак) в одиночных ковычках! (если захочу хранить ковычку одинарную то использую знак экранирования \,
// то будет выглядеть > '\'' - здесь учитывается только '

val v1: Int = 42
val v2: Long = 98765432123456789L
val v3: Float = 23.45f
val v4: Double = 0.123456789
val v5: String = "Kotlin & Java"
// написано в верхнемрегистре, а должно быть в нижнем
// val v6: Boolean = FALSE
val v7: Char = 'c'
val v8: Int = 500
val v9: Long = 4294967296L
val v10: Float = 18.0f
val v11: Double = -0.001
val v12: String = "OpenAI"
val v13: String = "true"
val v14: List<Int> = listOf(3, 14)
val v15: Char = '9'
val v16: Short = 2048
val v17: Long = 10000000000L
val v18: Set<String> = setOf("OpenAI", "Quantum Computing")
val v19: Float = 5.75f
// в одинрных ковычках но к Сhar не подходит т.к в нем указывается олько один символ
// val v20:  = `1.414`
val v21: String = "Artificial Intelligence"
val v22: Array<Any> = arrayOf('x', "A")
val v23: String = "Android Studio"
val v24: Char = '@'
val v25: Int = 1024
val v26: Long = 1234567890123L
val v27: Float = 10.01f
val v28: Double = -273.15
val v29: String = "SpaceX"
// написано в верхнемрегистре, а должно быть в нижнем
// val v30: Boolean = FALSE
val v30: Boolean = false
val v31: Double = 0.007
// val v32: String = “🤯” должен был поместитья в String
val v33: Map<String,Any> = mapOf("true" to 2, "false" to 34)
// Для Char должен быть один символ, в данном случае их много
//val v34 = ‘65535’
val v35: Long = 72057594037927935L
val v36: Float = 2.71828f
val v37: Double = 101.0101
val v38: String = "Quantum Computing"
val v39: Map<Any,String> = mapOf(2 to "true", 34 to "false")
val v40: Char = 'x'
val v41: Int = 314
val v42: Long = 123456789123456789L
val v43: Float = 6.626f
// для Boolean должно быть наисано в нижнем регистре
// val v44 = TRUE

/// Подбери подходящий тип который будет:

// 1.Хранить букву, на которую указывает палец медиума во время спиритического сеанса.
val medium: Char = 'x'

// 2.Хранить количество ложек сахара, которые я кладу в одну чашку чая
val teaSpoons: Int = 0

// 3.Хранить список расходов на доставку еды, чтобы ещё раз убедиться, что готовить было дешевле.
val planFoodDelivery: Int = 1000

// 4.Хранить длину очереди в столовой до миллиардной доли сантиметра.
val canteenQueueLengthCm: Float = 0.123456786f

// 5.Хранить факт, закрыт ли баг после того, как его просто переименовали в фичу.
var isClosedAsFeatur: Boolean = true

// 6.Хранить количество свистков чайника за день.
var whistlesPerDay: Int = 0

// 7.Хранить количество нажатий котом на клавиатуру ноутбука за всё время твоей работы.
var totalCatKeyPresses: Long = 10000000L

// 8.Хранить количество попыток пересчитать звёзды на небе за всю историю человечества.
var totalStarCountingAttempts: Long = 19919998L

// 9.Хранить массу воздуха в спускающем матрасе после нападения кота в долях грамма.
var currentAirMassGrams: Double = 176.007

// 10.Хранить словарь «название стартапа → сумму потерь инвесторов».
var investorLossesByStartup: Map<String,Any> = mapOf("nameStartup1" to 1324, "nameStartup2" to 1324)

// 11.Хранить строку «починилось само», чтобы закрывать тикеты без лишних слов.
var closingComment: String = "починилось само"

// 12.Хранить список тем для митингов, которые на самом деле никому не нужны.

var MeetingTopics: List<String> = listOf("MeetingTopics1", "MeetingTopics2", "MeetingTopics3")