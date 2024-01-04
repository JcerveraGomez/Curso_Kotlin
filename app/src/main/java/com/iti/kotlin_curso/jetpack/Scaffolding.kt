package com.iti.kotlin_curso.jetpack

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.iti.kotlin_curso.ui.theme.Orange

@Composable
fun Scaffolding() {
    var boxAlignment by remember { mutableStateOf(Alignment.Center) }
    var columnArrangement by remember { mutableStateOf(Arrangement.Center) }
    var rowArrangement by remember { mutableStateOf(Arrangement.Start) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = columnArrangement,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(horizontalArrangement = rowArrangement) {
            Button(
                onClick = { boxAlignment = Alignment.TopStart },
                colors = ButtonDefaults.buttonColors(
                    Orange
                )
            ) {
                Text("Top Start", color = Color.White)
            }
            Button(
                onClick = {
                    boxAlignment = Alignment.TopCenter
                }, colors = ButtonDefaults.buttonColors(
                    Orange
                )
            ) {
                Text("Top Center", color = Color.White)
            }
            Button(
                onClick = {
                    boxAlignment = Alignment.TopEnd
                }, colors = ButtonDefaults.buttonColors(
                    Orange
                )
            ) {
                Text("Top End", color = Color.White)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            contentAlignment = boxAlignment,
            modifier = Modifier
                .size(150.dp)
                .background(Color.LightGray)
        ) {
            Text("Box Content", color = Color.White)
        }
        Spacer(modifier = Modifier.height(16.dp))

        Row(horizontalArrangement = rowArrangement) {
            Button(
                onClick = { boxAlignment = Alignment.BottomStart },
                colors = ButtonDefaults.buttonColors(
                    Orange
                )
            ) {
                Text("Bottom Start", color = Color.White)
            }
            Button(
                onClick = {
                    boxAlignment = Alignment.BottomCenter
                }, colors = ButtonDefaults.buttonColors(
                    Orange
                )
            ) {
                Text("B. Center", color = Color.White)
            }
            Button(
                onClick = {
                    boxAlignment = Alignment.BottomEnd
                }, colors = ButtonDefaults.buttonColors(
                    Orange
                )
            ) {
                Text("Bottom End", color = Color.White)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = rowArrangement
            ) {
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .background(Color.Red)
                )
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .background(Color.Green)
                )
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .background(Color.Blue)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row {
                Button(
                    onClick = { rowArrangement = Arrangement.SpaceBetween },
                    colors = ButtonDefaults.buttonColors(
                        Orange
                    )
                ) {
                    Text("Space Between", color = Color.White)
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Row {
                Button(
                    onClick = { rowArrangement = Arrangement.SpaceAround },
                    colors = ButtonDefaults.buttonColors(
                        Orange
                    )
                ) {
                    Text("Space Around", color = Color.White)
                }
            }
            Spacer(modifier = Modifier.width(8.dp))

            Row {
                Button(
                    onClick = { rowArrangement = Arrangement.SpaceEvenly },
                    colors = ButtonDefaults.buttonColors(
                        Orange
                    )
                ) {
                    Text("Space Evenly", color = Color.White)
                }
            }
            Row {
                Button(
                    onClick = { rowArrangement = Arrangement.Start },
                    colors = ButtonDefaults.buttonColors(
                        Orange
                    )
                ) {
                    Text("Reset", color = Color.White)
                }
            }


        }
    }
}