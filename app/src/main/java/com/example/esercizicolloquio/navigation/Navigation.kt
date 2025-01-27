package com.example.esercizicolloquio.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.esercizicolloquio.presentation.CercaResistenza
import com.example.esercizicolloquio.presentation.FrequenzaScreen
import com.example.esercizicolloquio.presentation.ResistenzaInversa
import com.example.esercizicolloquio.presentation.component.BottomNavigationBar
import com.example.esercizicolloquio.viewmodel.FrequenzaViewModel
import com.example.esercizicolloquio.viewmodel.ResistenzaInversaViewModel
import com.example.esercizicolloquio.viewmodel.ResistenzaViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = EserciziColloquioScreen.CercaResistenzaScreen.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(EserciziColloquioScreen.CercaResistenzaScreen.route) {
                val viewModel = viewModel<ResistenzaViewModel>()
                CercaResistenza(viewModel)
            }

            composable(EserciziColloquioScreen.CercaResistenzaInversaScreen.route) {
                val viewModel = viewModel<ResistenzaInversaViewModel>()
                ResistenzaInversa(viewModel)
            }
            composable(EserciziColloquioScreen.CercaNumeriArrayScreen.route) {
                val viewModel = viewModel<FrequenzaViewModel>()
                FrequenzaScreen(viewModel)
            }
        }
    }
}
