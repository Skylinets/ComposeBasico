package com.compose.composebasico

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.compose.composebasico.model.Pantalla1
import com.compose.composebasico.model.Pantalla2
import com.compose.composebasico.model.Pantalla3


@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(navController =navController, startDestination = Pantalla1.route){
        composable(Pantalla1.route){
            Home()
        }
        composable(Pantalla2.route){
            Person()
        }
        composable(Pantalla3.route){
            Favorite()
        }
    }
}