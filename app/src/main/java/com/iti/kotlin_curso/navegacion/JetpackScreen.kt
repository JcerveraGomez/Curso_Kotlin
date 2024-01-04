package com.iti.kotlin_curso.navegacion

import android.app.Activity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.iti.kotlin_curso.components.customTopBar
import com.iti.kotlin_curso.iniciacion_kotlin.FundamentosKotlin
import com.iti.kotlin_curso.iniciacion_kotlin.POOkotlin
import com.iti.kotlin_curso.iniciacion_kotlin.Rutinas
import com.iti.kotlin_curso.jetpack.EstadosComponentes
import com.iti.kotlin_curso.jetpack.Scaffolding
import com.iti.kotlin_curso.jetpack.Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JetpackScreen(navController: NavController, activity: Activity, parteCurso : String? ){
    Scaffold(
        topBar = {
            customTopBar(navController = navController)
        }

    ) { innerPadding ->
        Box(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()) {
            if(parteCurso =="Scaffolding"){
                Scaffolding()
            }else if (parteCurso == "Estados"){
                EstadosComponentes()
            }
            else if (parteCurso == "Rutinas"){
                Rutinas()
            }else if (parteCurso == "Theme"){
                Theme()
            }

        }

    }
}