package com.example.esercizicolloquio.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ResistenzaViewModel : ViewModel() {
    var inputNumber by mutableStateOf("")
    var result by mutableStateOf("")

    fun getResistenza(numero: Int): Int {
        var count = 0
        var current = numero

        while (current >= 10) {
            current = current.toString().map { it.digitToInt() }.reduce { acc, digit -> acc * digit }
            count++
        }

        return count
    }
    fun calculateResistenza() {
        val number = inputNumber.toIntOrNull()
        result = if (number != null) {
            "Resistenza: ${getResistenza(number)}"
        } else {
            "Inserisci un numero valido."
        }
    }
}