package com.example.esercizicolloquio.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class FrequenzaViewModel : ViewModel() {
    var inputNumber by mutableStateOf("")
    var inputK by mutableStateOf("")
    var numbers = mutableStateListOf<Int>()

    private val _result = MutableStateFlow("")
    val result: StateFlow<String> get() = _result

    fun getMaxFrequenti(array: IntArray, k: Int): List<Int> {
        return array.toList().groupingBy { it }.eachCount()
            .toList()
            .sortedWith(compareByDescending<Pair<Int, Int>> { it.second }.thenBy { it.first })
            .take(k)
            .map { it.first }
    }

    fun addNumber() {
        val number = inputNumber.toIntOrNull()
        if (number != null) {
            numbers.add(number)
            inputNumber = ""
        }
    }
    fun getMaxFrequente(array: IntArray): Int {
        return array.toList().groupingBy { it }.eachCount()
            .toList()
            .sortedWith(compareByDescending<Pair<Int, Int>> { it.second }.thenBy { it.first })
            .first().first
    }
    fun calculateFrequenze() {
        val k = inputK.toIntOrNull()
        _result.value = when {
            k == null || k <= 0 -> "Inserisci un valore valido per k."
            numbers.isEmpty() -> "Inserisci almeno un numero nell'array."
            else -> {
                val frequenti = getMaxFrequenti(numbers.toIntArray(), k)
                "Numeri più frequenti: ${frequenti.joinToString(", ")}"
            }
        }
    }
}
