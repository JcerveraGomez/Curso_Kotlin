package com.iti.kotlin_curso.jetpack

import android.app.Activity
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iti.kotlin_curso.ui.theme.DarkOrange
import com.iti.kotlin_curso.ui.theme.LightOrange
import com.iti.kotlin_curso.ui.theme.Orange
import kotlinx.coroutines.delay

@Composable
fun EstadosComponentes() {
    var count by remember { mutableStateOf(0) }



    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {

            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = LightOrange.copy(alpha = 0.2f),
                ),
            ) {
                Row(modifier = Modifier.padding(horizontal = 10.dp, 5.dp)) {
                    Text(
                        text = "Contador Simple",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    )

                }
                Row(modifier = Modifier.padding(horizontal = 10.dp, 5.dp)) {
                    Text(
                        text = "Has hecho clic $count veces",
                        fontWeight = FontWeight.Normal,
                        fontSize = 18.sp
                    )

                }
                Row(modifier = Modifier.padding(horizontal = 10.dp, 5.dp)) {
                    Button(
                        onClick = { count++ }, colors = ButtonDefaults.buttonColors(
                            Orange
                        )
                    ) {
                        Text("Count++", color = Color.White)
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
                        text = "Renderizado anidado",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    )

                }
                Row(modifier = Modifier.padding(horizontal = 10.dp, 5.dp)) {
                    ComposableHijo("Mensaje desde el hijo")

                }


            }
            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = DarkOrange.copy(alpha = 0.4f),
                ),
            ) {
                Row(modifier = Modifier.padding(horizontal = 10.dp, 5.dp)) {
                    Text(
                        text = "LaunchEffect",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    )

                }
                LaunchedEffectExample()


            }
            SideEffectExample()

        }
    }

}

@Composable
fun ComposableHijo(message: String) {
    Text(message)
}

@Composable
fun LaunchedEffectExample() {
    var countDown by remember { mutableStateOf(9) }
    var resetVariable by remember { mutableStateOf(false) }
    var isFirstRender by remember { mutableStateOf(true) }

// UNIT se ejecuta cunado se crea el componente

    LaunchedEffect(Unit) {
        repeat(9) {
            delay(1000)
            countDown--
        }
    }

    LaunchedEffect(resetVariable) {
        // Evitar ejecución en la creación inicial
        if (isFirstRender) {
            isFirstRender = false
            return@LaunchedEffect
        }

        // Ejecución posterior a la inicial
        countDown = 9
        repeat(9) {
            delay(1000)
            countDown--
        }
    }
    Row(modifier = Modifier.padding(horizontal = 10.dp, 5.dp)) {
        Text("Cuenta regresiva: $countDown")

    }
    Row(modifier = Modifier.padding(horizontal = 10.dp, 5.dp)) {
        Button(
            onClick = { resetVariable = !resetVariable }, colors = ButtonDefaults.buttonColors(
                Orange
            )
        ) {
            Text("Reset Contador", color = Color.White)
        }
    }


}
@Composable
fun SideEffectExample() {
    var count by remember { mutableStateOf(0) }
    val context = LocalContext.current

// En cada recomposición exitosa lo actualiza   ±useEffect(() => {});
// Son acciones que no estan directamente relacionadas con la actualización de la interfaz
    // Cualquiero cambio como estos comentario ejecutan el SideEffect
    // Cuando se actualiza la UI apesar de que hay recomposición no hay ejecución de sideEffect porq solo recompone el estado como en react

    SideEffect {
        // Asignar el título de la actividad
        (context as? ComponentActivity)?.title = "Actualizado Titulo"
        Log.i("Lifecycle",(context as? ComponentActivity)?.title.toString())
    }
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = LightOrange.copy(alpha = 0.2f),
        ),
    ) {
        Row(modifier = Modifier.padding(horizontal = 10.dp, 5.dp)) {
            Text(
                text = "SideEffect",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )

        }
        Row(modifier = Modifier.padding(horizontal = 10.dp, 5.dp)) {
           Text(text =  (context as? ComponentActivity)?.title.toString())

        }
        Row(modifier = Modifier.padding(horizontal = 10.dp, 5.dp)) {
            Text(text = "Contador: $count")

        }
        Row(modifier = Modifier.padding(horizontal = 10.dp, 5.dp)) {
            Button(onClick = { count++ }, colors = ButtonDefaults.buttonColors(
                Orange
            )) {
                Text("Incrementar contador", color = Color.White)
            }

        }



    }

}