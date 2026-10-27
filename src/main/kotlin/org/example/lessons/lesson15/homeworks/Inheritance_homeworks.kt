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

//Это класс контейнера. Он абстрактный, это означает, что нельзя создавать экземлпяр этого
// класса, он нужен только для того, чтобы быть основой для подклассов.
//
//Создай подклассы этого контейнера, которые будут добавлять строку material
// (или коллекции или словари строк) в какое-то определённое место (места).
//
//Первый класс должен вставлять строку на дно контейнера (должно появиться
// под индексом 0)

abstract class Materials {
    private val materials = mutableListOf<String>() // изменяемый список стартует пустой
    // private - инкапсуляция (скрытое хранилище)
    fun addMaterial(material: String) { // функция-метод добавляет строку в конец списка
        materials.add(material) // роль метода - строительный блок: наследники вызывают его,
    // чтобы собрать нужное поведение
    }
    fun extractMaterials(): List<String> {
        val extracted = materials.toList() // toList() - создает новый список - копию текущего
        // новая переменная val extracted - отдельный список
        materials.clear() // очищает внутренний список - контейнер пустеет
        return extracted
    }
    fun printContainer() {
        materials.forEachIndexed { index, layer -> // forEachIndexed - проходит по списку дает и индекс и значение
           // layer - элемент на этой позиции (название переменной на мой выбор)
            println("[$index]: $layer")
        }
    }
}
class InsertFirstMaterial : Materials() { // класс без переменных наследник  Materials()

    fun insert(item: String // метод принимает строку
    ) {
        val materials = extractMaterials() // сохранить содержимое и очистить контейнер
        addMaterial(item) // добавить новый элемент
        materials.forEach { // вернуть старые — циклом по сохранённому списку (forEach + addMaterial)
           // forEach - сохраняет исходный порядок
            addMaterial(it)
        }
    }
}


// Второй класс должен получать список строк и вставлять их в начало контейнера
// но поочерёдно с теми данными, которые уже есть. То-есть, наш список должен появиться
// в контейнере по индексам 0, 2, 4 и так далее.
// нужно вызывать addMaterial в такой последовательности:
// items[0], materials[0], items[1], materials[1], items[2], materials[2],

class InsertOneByOneMaterials : Materials() {

    fun insert(items: List<String>) { // метод принимает список строк
        val materials = extractMaterials() // забирает старое содержимое и контейнер пуст становится
        val maxIndex = max(items.lastIndex, materials.lastIndex) // определяет длину цикла - максимум из двух lastIndex
        for (i in 0..maxIndex) { // перебор в цикле от 0 до maxIndex включительно
            if (i < items.size) { // условие проверяет существует ли элемент items[i]
                // если индекс меньше размера — существует, можно добавлять.
                // Иначе — список закончился, обращаться нельзя.
                addMaterial(items[i]) // добавляет новый элемент
            }
            if (i < materials.size) { // добавляет старый элемент
                addMaterial(materials[i])
            }
        }
    }
}

//Третий класс при добавлении строки должен отсортировать весь список материалов в
// алфавитном порядке включая добавляемый материал.

class InsertSortedMaterials : Materials() {

    fun insert(item: String) { // метод принимает строку
        val materials = (extractMaterials() + item).sorted()
        // extractMaterials() - очистить
        // затем + item) добавить новый к списку
        // затем .sorted() создает еще один - отсортированный целиком
        materials.forEach { // вернуть в нужном порядке
            addMaterial(it)
        }
    }
}

//Четвёртый класс должен принимать словарь (ключи и значения строки).
// Каждая пара ключа и значения должна попадать в контейнер следующим образом -
// ключ в начало, значение в конец. Таким образом в начале должны быть ключи в
// обратном порядке, потом существующие материалы, потом все значения.

class InsertMapMaterials : Materials() {

    fun insert(items: Map<String, String>) {
        val materials = items.keys.reversed() + extractMaterials() + items.values
        materials.forEach {
            addMaterial(it)
        }
    }
}