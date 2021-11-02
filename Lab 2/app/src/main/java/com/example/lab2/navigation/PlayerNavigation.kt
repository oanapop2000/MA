package com.example.lab2.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import com.example.lab2.details.PlayerDetailsScreen
import com.example.lab2.players.AddScreen
import com.example.lab2.players.PlayersScreen


@Composable
fun PlayerNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Players.route) {
        composable(
            route = Screen.Players.route
        ) {
            PlayersScreen(
                onPlayerClick = { selectedPlayer ->
                    navController.navigate("${Screen.PlayerDetails.route}/$selectedPlayer")
                },
                onAddPlayerClick = {
                    navController.navigate(Screen.AddPlayer.route)
                }
            )
        }
        composable(
            route = "${Screen.PlayerDetails.route}/{selectedPlayer}",
            arguments = listOf(navArgument("selectedPlayer") { type = NavType.StringType })
        ) { navBackStackEntry ->
            navBackStackEntry.arguments?.getString("selectedPlayer")?.let { player ->
                PlayerDetailsScreen(selectedPlayer = player, onModifyClick = {
                    navController.navigate(route = Screen.Players.route)
                },onDeleteClick = {
                    navController.navigate(route = Screen.Players.route)
                })
            }
        }
        composable(
            route = Screen.AddPlayer.route
        ){
            AddScreen(
                onAddClick = {
                    navController.navigate(route = Screen.Players.route)
                }
            )
        }

    }
}