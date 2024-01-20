package com.iti.kotlin_curso.navegacion

import android.app.Activity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.unit.sp
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
                Text(text ="API")
                Row(modifier = Modifier.padding(10.dp), horizontalArrangement = Arrangement.Center) {
                    Box(modifier = Modifier.padding(horizontal = 10.dp)) {
                        ElevatedButton(
                            modifier=Modifier.width(100.dp),
                            shape = RoundedCornerShape(20),
                            colors = ButtonDefaults.elevatedButtonColors(containerColor = LightOrange),
                            onClick = { navController.navigate("RoomCrud")}) {
                            Text(text = "Crud", color = Color.Black)
                        }
                    }



                    Box(modifier = Modifier.padding(horizontal = 10.dp)) {
                        ElevatedButton(
                            modifier=Modifier.width(100.dp),

                            shape = RoundedCornerShape(20),
                            colors = ButtonDefaults.elevatedButtonColors(containerColor = LightOrange),
                            onClick = { navController.navigate("PokeApi")}) {
                            Text(text = "PokeApi", color = Color.Black)

                        }
                    }


                }
                Row(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(), // Asegura que el Row ocupe todo el ancho
                    horizontalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 10.dp), contentAlignment = Alignment.Center
                           // Alinea el Box (y por lo tanto, el botón) al centro horizontalmente
                    ) {
                        ElevatedButton(
                            shape = RoundedCornerShape(20),
                            colors = ButtonDefaults.elevatedButtonColors(containerColor = LightOrange),
                            onClick = { navController.navigate("SharedPreferences")}
                        ) {
                            Text(text = "Shared Preferences", color = Color.Black)
                        }
                    }
                }
                Text(text ="UI")
                Row(modifier = Modifier.padding(10.dp)) {




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