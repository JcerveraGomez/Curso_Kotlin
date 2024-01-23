package com.iti.kotlin_curso.iniciacion_kotlin

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.iti.kotlin_curso.ui.theme.Orange
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

@Composable
fun Rutinas(){
    var text by remember { mutableStateOf("Inicia la corutina") }

    //Al poner "rembember" entonces tiene en cuenta cada recomposicion del composable es decir se adhiere al ciclo de vida del composable
    val coroutineScope = rememberCoroutineScope()
    var counter by remember { mutableStateOf(0) }

    // Se utiliza para referenciar la ejecucion de la corutina
    var job: Job? by remember { mutableStateOf(null) }
    val lifecycleOwner = LocalLifecycleOwner.current
    val lifecycleStatus = remember { mutableStateOf("Inicio del ciclo de vida") }
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_CREATE -> Log.i("LifecycleEvent", "ON_CREATE")
                Lifecycle.Event.ON_START -> Log.i("LifecycleEvent", "ON_START")
                Lifecycle.Event.ON_RESUME -> Log.i("LifecycleEvent", "ON_RESUME")
                Lifecycle.Event.ON_PAUSE -> Log.i("LifecycleEvent", "ON_PAUSE")
                Lifecycle.Event.ON_STOP -> Log.i("LifecycleEvent", "ON_STOP")
                Lifecycle.Event.ON_DESTROY -> Log.i("LifecycleEvent", "ON_DESTROY")
                else -> Log.i("LifecycleEvent", "Unknown State")
            }
        }

        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Orange.copy(alpha = 0.2f),
                ),
            ) {
                Row(modifier = Modifier.padding(horizontal = 10.dp, 5.dp)) {
                    Text(
                        text = "Rutinas",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Row(modifier = Modifier.padding(horizontal = 10.dp, 5.dp)) {
                    Text(text = "Contador: $counter")
                }
                Row(modifier = Modifier.padding(horizontal = 10.dp, 5.dp)) {
                    Button(onClick = {
                        job = coroutineScope.launch {
                            while (isActive) {
                                counter++
                                delay(1000) // Incrementa el contador cada segundo
                            }
                        }
                    }) {
                        Text("Iniciar", color = Color.White)
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Button(onClick = {
                        job?.cancel()
                    }) {
                        Text("Detener", color = Color.White)
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Button(onClick = {
                        job = coroutineScope.launch {
                            while (isActive) {
                                counter++
                                delay(1000) // Incrementa el contador cada segundo
                            }
                        }
                    }) {
                        Text("Reanudar", color = Color.White)
                    }


                }
                Row (modifier = Modifier.padding(horizontal = 10.dp, 5.dp)){
                    Button(onClick = {
                        counter = 0
                    }) {
                        Text("Resetear", color = Color.White)
                    }
                }
            }


            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Orange.copy(alpha = 0.2f),
                ),
            ) {
                Row(modifier = Modifier.padding(horizontal = 10.dp, 5.dp)) {
                    Text(
                        text = "Rutinas",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    )

                }
                Row(modifier = Modifier.padding(horizontal = 10.dp, 5.dp)) {
                    Text(
                        text = lifecycleStatus.value,

                    )

                }



            }
        }
    }




}