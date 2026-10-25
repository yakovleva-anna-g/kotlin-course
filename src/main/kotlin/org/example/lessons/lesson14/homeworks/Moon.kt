package org.example.lessons.lesson14.homeworks

object Moon {
    val isVisible: Boolean = true
    val phase: String = "Full Moon"
    fun showPhase () {
        if (isVisible) {
            println("The moon is visible, and it's currently a $phase")
        } //ветка true
        else {
            println("The moon is not visible right now")} // ветка false
        }
    }
