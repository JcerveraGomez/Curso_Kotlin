package com.iti.kotlin_curso.jetpack

import androidx.activity.ComponentActivity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iti.kotlin_curso.ui.theme.Kotlin_CursoTheme
import com.iti.kotlin_curso.ui.theme.LightOrange
import com.iti.kotlin_curso.ui.theme.Orange
import com.iti.kotlin_curso.ui.theme.Typography

@Composable
fun Theme() {
    var isDarkTheme by remember { mutableStateOf(false) }

    Kotlin_CursoTheme(isDarkTheme) {
        Card(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary.copy(0.2f),
            ),
        ) {
            Row(modifier = Modifier.padding(horizontal = 10.dp, 5.dp)) {
                Text("Demo de Tema", style = Typography.bodyLarge, color = Color.Black)


            }
            Row(modifier = Modifier.padding(horizontal = 10.dp, 5.dp)) {
                Text("Este es un texto con el cuerpo del tema", style = Typography.bodySmall, color = Color.White)


            }

            Row(modifier = Modifier.padding(horizontal = 10.dp, 5.dp)) {
                Button(onClick = { isDarkTheme = !isDarkTheme }){
                    Text("Cambiar a ${if (isDarkTheme) "tema claro" else "tema oscuro"}", color = Color.White)
                }

            }



        }






    }
}