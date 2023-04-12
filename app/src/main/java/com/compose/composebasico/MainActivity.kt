package com.compose.composebasico

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*


import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*
import com.compose.composebasico.model.CheckBox
import com.compose.composebasico.ui.theme.ComposeBasicoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicoTheme {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                       MyScaffold()

                    }

                }
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeBasicoTheme {

    }
}





@Composable
fun MyDropDownMenu() {
    var textSelected by remember { mutableStateOf("") }
    var openClosed by remember { mutableStateOf(false) }
    val desayuno = listOf("Café", "Cereal", "Té", "Manzana")
    OutlinedTextField(
        value = textSelected,
        onValueChange = { textSelected = it },
        enabled = false,
        readOnly = true,
        modifier = Modifier.clickable { openClosed = true }
    )
    DropdownMenu(
        expanded = openClosed,
        onDismissRequest = { openClosed = false },
        Modifier.fillMaxWidth()
    ) {
        desayuno.forEach { desayuno ->
            DropdownMenuItem(onClick = {
                openClosed = false
                textSelected = desayuno
            }) {
                Text(text = desayuno)
            }

        }
    }

}


@Composable
fun MyOutlinedTextField() {
    var text by remember { mutableStateOf("") }

    Column(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        OutlinedTextField(value = text, onValueChange = { text = it })

    }


}


@Composable
fun MyCard() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 10.dp,
        border = BorderStroke(3.dp, Color.Black),
        backgroundColor = Color.Green,
        shape = MaterialTheme.shapes.small,
        contentColor = Color.Blue
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(text = "Ejemplo")
            Text(text = "Ejemplo")
            Text(text = "Ejemplo")
        }


    }

}


@Composable
private fun getCheckbox(titles: List<String>): List<CheckBox> {
    return titles.map {
        var status by rememberSaveable { mutableStateOf(false) }
        CheckBox(
            title = it,
            selected = status,
            checkChange = { status = it }
        )
    }

}

@Composable
fun MyCheckBoxTextComplete(checkBox: CheckBox) {
    Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = checkBox.selected,
            onCheckedChange = { checkBox.checkChange(!checkBox.selected) })
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = checkBox.title)


    }
}

@Composable
fun MyCheckBoxText() {
    var state by rememberSaveable { mutableStateOf(false) }

    Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = state, onCheckedChange = { state = !state })
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "ejemplo")

    }
}


@Composable
fun myCheckbox() {
    var state by rememberSaveable { mutableStateOf(false) }
    Checkbox(
        checked = state,
        onCheckedChange = { state = !state },
        enabled = true,
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Red,
            uncheckedColor = Color.Green,
            checkmarkColor = Color.Blue
        )
    )
}


@Composable
fun MySwitch() {
    var state by rememberSaveable { mutableStateOf(false) }
    Switch(
        checked = state, onCheckedChange = { state = !state },
        enabled = false,
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color.Red,
            uncheckedThumbColor = Color.Green,
            uncheckedTrackColor = Color.Cyan,
            checkedTrackColor = Color.Magenta,
            uncheckedTrackAlpha = 0.9f,
            checkedTrackAlpha = 0.5f,
            disabledCheckedThumbColor = Color.White,
            disabledUncheckedThumbColor = Color.Black
        )
    )
}


@Composable
fun MyOutlinedButton() {
    Column(Modifier.fillMaxSize()) {
        OutlinedButton(
            onClick = { /*TODO*/ },
            border = BorderStroke(2.dp, Color.Blue),
            shape = RoundedCornerShape(10.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Star, contentDescription = null)
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "OutLinedButton")
            }
        }
    }
}

@Composable
fun MyCheckbox() {

    var state by rememberSaveable { mutableStateOf(false) }

    Checkbox(
        checked = state,
        onCheckedChange = { state = !state },
        enabled = true,
        colors = CheckboxDefaults.colors(
            checkmarkColor = Color.Red,
            uncheckedColor = Color.Green,
            checkedColor = Color.Yellow


        )
    )


}


@Composable
fun MyState() {
    var count by rememberSaveable { mutableStateOf(0) }
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { count += 1 }) {
            Text(text = "Pulsar")
        }

        Text(text = "Se ha pulsado: ${count} veces")

    }


}


@Composable
fun MyButton() {
    Column(Modifier.fillMaxSize()) {
        Button(
            onClick = { /*TODO*/ },
            Modifier.padding(20.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Magenta,
                contentColor = Color.Blue
            ),
            border = BorderStroke(2.dp, Color.Blue)
        ) {
            Text(text = "ClickHere")
        }
    }

}


@Composable
fun MyRow() {
    Row(Modifier.fillMaxSize(), Arrangement.Center) {

        Row(
            Modifier
                .width(50.dp)
                .height(60.dp)
                .horizontalScroll(rememberScrollState()), Arrangement.Center

        ) {

            Text(text = "Hola mundo OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO")


        }
    }

}


@Composable
fun MyColumn() {

    Column(Modifier.fillMaxSize(), Arrangement.Center) {
        Column(Modifier.padding(50.dp), Arrangement.Center) {
            Text(text = "Hola Mundo ")
            Text(text = "Hola 1 ")
            Text(text = "Hola 2 ")
            Text(text = "Hola 3 ")
            Text(text = "Hola 4 ")
        }
    }

}


@Composable
fun MyBox() {

    Box(Modifier.fillMaxSize(), Alignment.Center) {

        Box(
            Modifier
                .width(60.dp)
                .height(60.dp)
                .background(Color.Red)
                .verticalScroll(rememberScrollState()),
            contentAlignment = Alignment.Center,

            ) {
            Text(
                text = "Hola Mundo, bienvenidos a compose",
                color = Color.Blue,
                fontFamily = FontFamily.Cursive
            )
        }

    }


}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

