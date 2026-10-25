package org.example.lessons.lesson14.homeworks

class Party (val location: String, var attendees: Int) {
    fun details() {
    println("Место: $location количество гостей $attendees")}
}

fun main() {
    val party = Party("Red Bar", 12)
    party.details()
}