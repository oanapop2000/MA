package com.example.lab2.navigation

sealed class Screen(val route: String) {
    object Players : Screen(route = "players")
    object PlayerDetails : Screen(route = "details")
    object AddPlayer: Screen(route = "add")
}