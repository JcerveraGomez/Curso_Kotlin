package com.iti.kotlin_curso.iniciacion_kotlin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iti.kotlin_curso.ui.theme.DarkOrange
import com.iti.kotlin_curso.ui.theme.LightOrange
import com.iti.kotlin_curso.ui.theme.Orange

@Composable
fun FundamentosKotlin(){



    Box(modifier = Modifier.fillMaxSize()){
        Column(modifier = Modifier.fillMaxSize()) {
            HelloWorldComposable()
            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Orange.copy(alpha = 0.2f),
                ),
            ) {
                Row(modifier = Modifier.padding(horizontal = 10.dp,5.dp)) {
                    Text(
                        text = "Composable Dinámico",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    )

                }
                Row(modifier = Modifier.padding(horizontal = 10.dp,5.dp)){
                    Text(text = "${HelloWorldDynamic()}", fontWeight = FontWeight.Normal, fontSize = 18.sp)
                }


            }
            HelloWordNulos()
            HelloWordNulos("Personalizado")
            HelloWorldFromJava()

        }


      
    }

}

@Composable
fun HelloWorldComposable(){
    Card (modifier= Modifier
        .padding(10.dp)
        .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = LightOrange.copy(alpha = 0.2f),
        ),) {
        Row (modifier = Modifier.padding(5.dp)){
            Text(text = "Composable Anidado", fontSize = 25.sp, fontWeight = FontWeight.Bold)

        }
        Row (modifier = Modifier.padding(5.dp)) {
            Text(text = "Hola Mundo!", fontWeight = FontWeight.Normal, fontSize = 18.sp)
        }


    }}
@Composable
fun HelloWorldFromJava(){
    Card (modifier= Modifier
        .padding(10.dp)
        .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = LightOrange.copy(alpha = 0.2f),
        ),) {
        Row (modifier = Modifier.padding(5.dp)){
            Text(text = "Composable con info desde Java", fontSize = 25.sp, fontWeight = FontWeight.Bold)

        }
        Row (modifier = Modifier.padding(5.dp)) {
            Text(text = "${ExampleJavaClass.getJavaMessage()}", fontWeight = FontWeight.Normal, fontSize = 18.sp)
        }


    }}
@Composable
fun HelloWordNulos(message: String? = "Por Defecto") {

    Card (modifier= Modifier
        .padding(10.dp)
        .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = DarkOrange.copy(alpha = 0.4f),
        ),) {
        Row (modifier = Modifier.padding(5.dp)){
            Text(text = "Composable Nulos", fontSize = 25.sp, fontWeight = FontWeight.Bold)

        }
        Row (modifier = Modifier.padding(5.dp)) {
            Text(text = "$message")
        }


    }}
fun HelloWorldDynamic():String{
   return "Hello World"
}