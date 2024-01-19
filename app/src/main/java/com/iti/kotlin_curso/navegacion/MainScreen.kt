package com.iti.kotlin_curso.navegacion

import PantallaPedido
import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.iti.kotlin_curso.Routes
import com.iti.kotlin_curso.Routes.Home
import com.iti.kotlin_curso.databases.RoomCrud
import com.iti.kotlin_curso.databases.pokeApi.PokemonListScreen
import com.iti.kotlin_curso.ejercicios.PantallaNoticias


@Composable
fun MainScreen(activity: Activity){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.Home.route) {

        composable(Routes.Home.route) {
            HomeScreen(navController = navController,activity)
        }
        composable(Routes.Login.route) {
            LoginScreen(navController = navController,activity)
        }
        composable(Routes.EjercicioPoo.route) {
            PantallaPedido(navController = navController)
        }
        composable(Routes.EjercicioRutinas.route) {
            PantallaNoticias(navController = navController)
        }
        composable(Routes.PokeApi.route) {
            PokemonListScreen()
        }
        composable(Routes.RoomCrud.route) {
            RoomCrud(navController = navController)
        }
        composable(Routes.ApiScreen.route) {
            ApiScreen(navController = navController)
        }
        composable(Routes.Kotlin.route,arguments = listOf(navArgument("parteCurso") { type = NavType.StringType })
        ) {backStackEntry ->
            KotlinScreen(navController = navController,activity, parteCurso = backStackEntry.arguments?.getString("parteCurso"))
        }
        composable(Routes.Jetpack.route,arguments = listOf(navArgument("parteCurso") { type = NavType.StringType })
        ) {backStackEntry ->
            JetpackScreen(navController = navController,activity, parteCurso = backStackEntry.arguments?.getString("parteCurso"))
        }
        composable(Routes.Jetpack.route,arguments = listOf(navArgument("parteCurso") { type = NavType.StringType })
        ) {backStackEntry ->
            JetpackScreen(navController = navController,activity, parteCurso = backStackEntry.arguments?.getString("parteCurso"))
        }

    }
}

