package org.example.lessons.lesson15.homeworks

//Для каждого задания опиши в коде базовый класс с базовыми свойствами и если применимо - методами.
//
//Для производных классов также добавь специфичные для класса свойства.
// Детально описывать не нужно, упражнение на то, чтобы усвоить иерархию наследования и
// развитие функциональности у наследников.
//
//1.Геометрические Фигуры
//


// 1.Базовый класс: Геометрическая Фигура abstract (нет конкретной фигуры) но общее, что объединяет площадь и
// есть у каждой фигуры имя)
abstract class GeometricFigure (val name: String // свойство
){
    abstract fun area(): Double // площадь без тела потому что не знаем конкретно
}

//       1.Производные классы: Многоугольник (abstract сторон бывает разное количество изначально не определенно),
//         Круг (понятная фигура open)

abstract class Polygon (name: String, // параметр
                        sideCount: Int // параметр
): GeometricFigure (name) // наследование вызов базового класса с передачей name

open class Circle (val radius: Double): GeometricFigure ("круг") {
    fun area(): Double = 3.14 * radius * radius
}

//          1.Дополнительное разветвление для Многоугольник: Треугольник, Четырехугольник (количество углов,
//          сторон)
class Triangle (
    val sideA: Double,
    val sideB: Double,
    val sideC: Double
) : Polygon ("треугольник", 3) {
    fun area (): Double {
        // вычисляем площадь
    }
}

class Quadrilateral(
    val sideA: Double,
    val sideB: Double,
    val sideC: Double,
    val sideD: Double
) : Polygon("четырехугольник", 4){
    fun area (): Double {
        // вычисляем площадь
    }
}

//  2.Учебные Заведения
//    2. Базовый класс: Учебное Заведение (название, количество учащихся

//           2.Дополнительное разветвление для …: …

abstract class EducationalInstitution (
    val name: String,
    val studentCount: Int
) {
    abstract fun getType(): String
}

//.       2.Производные классы: Школа (наследование название, количество учащихся, название классов 1-4, 5-11)
//                             Универ (наследование название, количество учащихся, список факультетов)


open class School (
    name: String,
    studentCount: Int,
    val gradeRange: String
) : EducationalInstitution(name, studentCount) {
    fun getType(): String = "Школа"
}

class ElementarySchool (
    name: String,
    studentCount: Int
) : School(name, studentCount, "1-4") {
    fun getType(): String = "Начальная школа"
}

class University (
    name: String,
    studentCount: Int,
    val faculties: List<String>
): EducationalInstitution(name, studentCount) {
    fun getType(): String = "Университет"
}

//3.Иерархия Мебели
//.   3.Базовый класс: Мебель (название, материал, вес, высота, ширина, глубин
//      3.Производные классы: … для отдыха (кровати, диваны) для хранения (шкафы, комоды) для работы(письменные столы, стулья)
//          3.Дополнительное разветвление для …: …

abstract class Furniture (
    val name: String,
    val material: String,
    val weightKg: Double,
    val heightCm: Int,
    val widthCm: Int
)
open class LeisureFurniture ( // мебель для отдыха
    name: String,
    material: String,
    weightKg: Double, // вес
    heightCm: Int, //высота
    widthCm: Int, // ширина
   val  lengthCm: Double, // длина
val capacity: Int
) : Furniture(name, material, weightKg, heightCm, widthCm){
    fun gettype(): String = "Мебель для отдыха"
}
class Bed (
    name: String,
    material: String,
    weightKg: Double,
    heightCm: Int,
    widthCm: Int,
    lengthCm: Double,
    capacity: Int,
    val hasHeadboard: Boolean
) : LeisureFurniture(name, material, weightKg, heightCm, widthCm,lengthCm, capacity) {
    fun  getType(): String = "кровать"
}

open class StorageFurniture(
    name: String,
    material: String,
    weightKg: Double,
    heightCm: Int,
    widthCm: Int,
    val depthCm: Int // глубина
) : Furniture (name, material, weightKg, heightCm, widthCm) {
    fun getType(): String = "мебель для хранения"
}
class Cupboard(
    name: String,
    material: String,
    weightKg: Double,
    heightCm: Int,
    widthCm: Int,
    depthCm: Int,
    val numberOfShelves: Int // количество полок
) : StorageFurniture (name, material, weightKg, heightCm, widthCm, depthCm) {
    fun getType(): String = "Шкаф"
}