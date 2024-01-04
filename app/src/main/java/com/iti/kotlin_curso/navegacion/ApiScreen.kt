package com.iti.kotlin_curso.navegacion

import android.app.Activity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.iti.kotlin_curso.Routes
import com.iti.kotlin_curso.components.customTopBar
import com.iti.kotlin_curso.ui.theme.LightOrange

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ApiScreen(navController: NavController) {

    Scaffold(
        topBar = {
            customTopBar(navController = navController)
        }

    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Column(
                modifier = Modifier
                    .fillMaxSize(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text ="Kotlin")
                Row(modifier = Modifier.padding(10.dp), horizontalArrangement = Arrangement.Center) {
                    Box(modifier = Modifier.padding(horizontal = 10.dp)) {
                        ElevatedButton(
                            shape = RoundedCornerShape(20),
                            colors = ButtonDefaults.elevatedButtonColors(containerColor = LightOrange),
                            onClick = { navController.navigate("RoomCrud")}) {
                            Text(text = "Fundamentos", color = Color.Black)
                        }
                    }



                    Box(modifier = Modifier.padding(horizontal = 10.dp)) {
                        ElevatedButton(
                            shape = RoundedCornerShape(20),
                            colors = ButtonDefaults.elevatedButtonColors(containerColor = LightOrange),
                            onClick = { navController.navigate(Routes.Kotlin.createRoute("POO")) }) {
                            Text(text = "POO", color = Color.Black)

                        }
                    }
                    Box(modifier = Modifier.padding(horizontal = 10.dp)) {
                        ElevatedButton(
                            shape = RoundedCornerShape(20),
                            colors = ButtonDefaults.elevatedButtonColors(containerColor = LightOrange),
                            onClick = { navController.navigate(Routes.Kotlin.createRoute("Rutinas")) }) {
                            Text(text = "Rutinas", color = Color.Black)

                        }
                    }

                }
                Text(text ="UI")
                Row(modifier = Modifier.padding(10.dp)) {
                    Box(modifier = Modifier.padding(horizontal = 10.dp)) {
                        ElevatedButton(
                            shape = RoundedCornerShape(20),
                            colors = ButtonDefaults.elevatedButtonColors(containerColor = LightOrange),
                            onClick = { navController.navigate(Routes.Jetpack.createRoute("Scaffolding")) }) {
                            Text(text = "Scaffolding", color = Color.Black)
                        }
                    }



                    Box(modifier = Modifier.padding(horizontal = 10.dp)) {
                        ElevatedButton(
                            shape = RoundedCornerShape(20),
                            colors = ButtonDefaults.elevatedButtonColors(containerColor = LightOrange),
                            onClick = {  navController.navigate(Routes.Jetpack.createRoute("Estados")) }) {
                            Text(text = "Estados", color = Color.Black)

                        }
                    }
                    Box(modifier = Modifier.padding(horizontal = 10.dp)) {
                        ElevatedButton(
                            shape = RoundedCornerShape(20),
                            colors = ButtonDefaults.elevatedButtonColors(containerColor = LightOrange),
                            onClick = {  navController.navigate(Routes.Jetpack.createRoute("Theme")) }) {
                            Text(text = "Theme", color = Color.Black)

                        }
                    }

                }





            }
        }
    }


}