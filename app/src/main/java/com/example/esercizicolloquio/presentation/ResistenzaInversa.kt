package com.example.esercizicolloquio.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.esercizicolloquio.viewmodel.ResistenzaInversaViewModel

@Composable
fun ResistenzaInversa(
    viewModel: ResistenzaInversaViewModel
    ) {
    Column(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = viewModel.inputNumber,
            onValueChange = { viewModel.inputNumber = it },
            label = { Text("Inserisci una resistenza target") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { viewModel.calculateResistenzaInversa() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Trova Numero")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = viewModel.result,
            style = MaterialTheme.typography.headlineMedium
        )
    }
}
