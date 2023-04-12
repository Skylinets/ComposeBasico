package com.compose.composebasico

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyScaffold1() {

    Scaffold(Modifier.fillMaxSize().padding(12.dp)) {
        Box(modifier = Modifier.padding(it)){

        }
    }

}


   