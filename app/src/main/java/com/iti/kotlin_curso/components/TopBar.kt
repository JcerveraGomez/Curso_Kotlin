package com.iti.kotlin_curso.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.iti.kotlin_curso.ui.theme.DarkOrange
import com.iti.kotlin_curso.ui.theme.Grey
import com.iti.kotlin_curso.ui.theme.LightOrange
import com.iti.kotlin_curso.ui.theme.Orange

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun customTopBar (navController:NavController){
    TopAppBar(
        title = {
            Text(text = "TopBar", color = Grey)
        },
        actions = {
            Row  {


                IconButton(modifier = Modifier.background(Orange), onClick = { navController.navigate("Home")} ) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Advertencia",
                        modifier = Modifier.padding(start = 3.dp),
                        tint = Color.White
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))

                IconButton(modifier = Modifier.background(DarkOrange), onClick = { navController.navigate("ApiScreen")} ) {
                    Icon(
                        imageVector = Icons.Default.Build,
                        contentDescription = "Advertencia",
                        modifier = Modifier.padding(start = 3.dp),
                        tint = Color.White
                    )
                }
            }


        },

        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.White)

    )
}