package com.iti.kotlin_curso.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val DarkOrange = Color(0xFFE14A01)
val LightOrange = Color(0xFFff8f02)
val Orange = Color(0xFFff6a03)
val Grey = Color(0xFF575757)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)
val NewPrimaryDark = Color(0xFFE14A01)  // Azul Grisáceo Oscuro
val NewPrimaryLight = Color(0xFFff8f02) // Azul Grisáceo Claro
val NewSecondary = Color(0xFFff8f02)    // Naranja Claro

// Actualizar esquemas de color
val DarkColorScheme = darkColorScheme(
    primary = NewPrimaryDark,
    secondary = NewSecondary,
    onPrimary = NewPrimaryDark,
    // Otros colores a modificar si es necesario
)

val LightColorScheme = lightColorScheme(
    primary = NewPrimaryLight,
    secondary = NewSecondary,
    onPrimary = NewPrimaryLight,
    // Otros colores a modificar si es necesario
)