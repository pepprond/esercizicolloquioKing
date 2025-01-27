package com.example.esercizicolloquio.navigation

sealed class EserciziColloquioScreen(val route: String) {
    data object CercaResistenzaScreen : EserciziColloquioScreen("cerca_resistenza")
    data object CercaResistenzaInversaScreen : EserciziColloquioScreen("cerca_resistenza_inversa")
    data object CercaNumeriArrayScreen : EserciziColloquioScreen("cerca_numeri_array")

}