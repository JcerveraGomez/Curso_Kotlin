package com.iti.kotlin_curso.iniciacion_kotlin

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iti.kotlin_curso.ui.theme.LightOrange
import com.iti.kotlin_curso.ui.theme.Orange
import kotlinx.coroutines.delay


class Animal(val name: String) {
    open fun makeSound(): String {
        return "$name hace un sonido"
    }
}
//HERENCIA
//Kotlin permite que una clase herede métodos y propiedades de otra.
// Superclase
open class Figura {
    open fun area(): Double {
        return 0.0
    }
}

// Subclase Circulo
class Circulo(val radio: Double) : Figura() {
    override fun area(): Double {
        return Math.PI * radio * radio
    }
}

// Subclase Rectangulo

//POLIMORFISMO
//El polimorfismo permite tratar a un objeto de una subclase como si fuera de su superclase.
fun imprimirArea(figura: Figura):String{
    return "El área de la figura es ${figura.area()}"
}
//En este ejemplo, imprimirArea() puede aceptar cualquier objeto que sea una subclase de Figura.
// Cuando se llama a area(), se ejecuta la versión del método que corresponde a la subclase real del objeto, no la versión en Figura.

// Encapsulamiento es el principio de ocultar el estado interno de un objeto
// y exigir que toda interacción se realice a través de métodos.
class BankAccount(private var balance: Int) {
    fun deposit(amount: Int) {
        if (amount > 0) balance += amount
    }

    fun withdraw(amount: Int): Boolean {
        if (amount <= balance) {
            balance -= amount
            return true
        }
        return false
    }

    fun getBalance() = balance
}
@Composable
fun POOkotlin() {

    val Perro: Animal = Animal("Perro")
    val circulo = Circulo(5.0)
    //Encapsulamiento


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
                        text = "Classe Animal",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    )

                }
                Row(modifier = Modifier.padding(horizontal = 10.dp, 5.dp)) {
                    Text(
                        text = "${Perro.makeSound()}",
                        fontWeight = FontWeight.Normal,
                        fontSize = 18.sp
                    )
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
                        text = "Classe Figura Herencia",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    )

                }
                Row(modifier = Modifier.padding(horizontal = 10.dp, 5.dp)) {
                    Text(
                        text = "Area: ${circulo.area()}",
                        fontWeight = FontWeight.Normal,
                        fontSize = 18.sp
                    )
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
                        text = "Classe Figura Polimorfismo",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    )

                }
                Row(modifier = Modifier.padding(horizontal = 10.dp, 5.dp)) {
                    Text(
                        text = "${ imprimirArea(circulo)}",
                        fontWeight = FontWeight.Normal,
                        fontSize = 18.sp
                    )
                }


            }

            val account = BankAccount(1000)
            account.deposit(500)
            var stateBalance by remember { mutableStateOf(0) }
            account.withdraw(200)
            stateBalance=account.getBalance()
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
                        text = "Classe Banco Encapsulamiento",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    )

                }
                Row(modifier = Modifier.padding(horizontal = 10.dp, 5.dp)) {
                    Text(
                        text = "$stateBalance",
                        fontWeight = FontWeight.Normal,
                        fontSize = 18.sp
                    )
                }


            }
        }
    }

}