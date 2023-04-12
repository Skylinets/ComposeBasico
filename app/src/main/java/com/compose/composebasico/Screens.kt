package com.compose.composebasico

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun Home(){
    Column(Modifier.background(color = Color.Blue)) {
        Text(text = "Estas en Home")
    }
}
@Composable
fun Person(){
    Column(Modifier.background(color = Color.Green)) {
        Text(text = "Estas en Person")
    }
}
@Composable
fun Favorite(){
    Column(Modifier.background(color = Color.Yellow)) {
        Text(text = "Estas en Favorite")
    }
}