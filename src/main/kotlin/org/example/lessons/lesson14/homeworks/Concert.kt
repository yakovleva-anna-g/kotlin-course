package org.example.lessons.lesson14.homeworks
//Мероприятие: концерт. Создайте класс, который будет представлять концерт.
// У него должны быть свойства “группа”, “место проведения”, “стоимость”, “вместимость зала”.
// Также приватное поле “проданные билеты”. Добавьте метод, который выводит информацию о концерте и
// метод “купить билет”, который увеличивает количество проданных билетов на один.

class Concert(val group: String, val venue: String, val cost: Int, val hallCapacity: Int) {
    private var ticketSold = 0
    fun buyTicket() {
if (ticketSold<hallCapacity) {
    println(ticketSold++)
}
    }

}