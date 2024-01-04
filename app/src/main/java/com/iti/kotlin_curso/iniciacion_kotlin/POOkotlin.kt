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
open class AnimalHerencia(val name: String) {
    open fun makeSoundHerencia(): String {
        return "$name hace un sonido"
    }
}

class Perro(name: String) : AnimalHerencia(name) {
    override fun makeSoundHerencia(): String {
        return "$name ladra"
    }
}
//POLIMORFISMO
//El polimorfismo permite tratar a un objeto de una subclase como si fuera de su superclase.
open class AnimalPolimorfismo {
    open fun makeSoundPolimorfismo():String {
        return "El animal hace sonido"

    }
}

class PerroPolimorfismo : AnimalPolimorfismo() {
    override fun makeSoundPolimorfismo():String {
        return "El perro ladra"
    }
}
// Encapsulamiento
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
    val PerroHerencia: Perro = Perro("PerroHerencia")
    val PerroPolimorfismo:PerroPolimorfismo=PerroPolimorfismo()
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
                        text = "Classe Animal Herencia",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    )

                }
                Row(modifier = Modifier.padding(horizontal = 10.dp, 5.dp)) {
                    Text(
                        text = "${PerroHerencia.makeSoundHerencia()}",
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
                        text = "Classe Animal Polimorfismo",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    )

                }
                Row(modifier = Modifier.padding(horizontal = 10.dp, 5.dp)) {
                    Text(
                        text = "${PerroPolimorfismo.makeSoundPolimorfismo()}",
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