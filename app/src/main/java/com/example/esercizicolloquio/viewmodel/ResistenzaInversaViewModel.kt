package com.example.esercizicolloquio.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ResistenzaInversaViewModel : ViewModel() {
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
    fun findNumberWithResistance(targetResistance: Int): Int {
        var number = 10
        while (getResistenza(number) < targetResistance) {
            number++
        }
        return number
    }
    fun calculateResistenzaInversa() {
        val targetResistance = inputNumber.toIntOrNull()
        result = if (targetResistance != null) {
            "Numero trovato: ${findNumberWithResistance(targetResistance)}"
        } else {
            "Inserisci un valore valido."
        }
    }
}