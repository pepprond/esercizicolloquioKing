package com.example.esercizicolloquio.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.esercizicolloquio.viewmodel.FrequenzaViewModel

@Composable
fun FrequenzaScreen(viewModel: FrequenzaViewModel) {
    val result by viewModel.result.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TextField(
            value = viewModel.inputNumber,
            onValueChange = { viewModel.inputNumber = it },
            label = { Text("Inserisci un numero per l'array") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = { viewModel.addNumber() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Aggiungi Numero")
        }

        Text(
            text = "Array corrente: ${viewModel.numbers.joinToString(", ")}",
            style = MaterialTheme.typography.bodyMedium
        )

        TextField(
            value = viewModel.inputK,
            onValueChange = { viewModel.inputK = it },
            label = { Text("Inserisci k (quanti numeri più frequenti)") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = { viewModel.calculateFrequenze() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calcola Frequenze")
        }

        Text(
            text = result,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

