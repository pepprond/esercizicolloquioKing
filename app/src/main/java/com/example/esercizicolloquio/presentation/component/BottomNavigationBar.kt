package com.example.esercizicolloquio.presentation.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.esercizicolloquio.navigation.EserciziColloquioScreen

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        EserciziColloquioScreen.CercaResistenzaScreen,
        EserciziColloquioScreen.CercaResistenzaInversaScreen,
        EserciziColloquioScreen.CercaNumeriArrayScreen
    )

    NavigationBar {
        items.forEach { screen ->
            NavigationBarItem(
                icon = { Icon(Icons.Filled.Search, contentDescription = screen.route) },
                label = { Text(screen.route) },
                selected = navController.currentDestination?.route == screen.route,
                onClick = {
                    if (navController.currentDestination?.route != screen.route) {
                        navController.navigate(screen.route) {
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                }
            )
        }
    }
}