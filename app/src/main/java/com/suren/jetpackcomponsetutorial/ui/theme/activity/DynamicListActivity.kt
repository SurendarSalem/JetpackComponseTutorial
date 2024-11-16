package com.suren.jetpackcomponsetutorial.ui.theme.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class DynamicListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var names = remember { mutableStateListOf<String>("Suren") }
            val newNameState = remember { mutableStateOf<String>("") }
            Surface(color = Color.White, modifier = Modifier.fillMaxSize()) {
                DynamicListWithState(names,
                    newNameState,
                    { names.add(newNameState.value) }) { name ->
                    newNameState.value = name
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LabelPreview() {
    var names = remember { mutableStateListOf<String>("Suren") }
    val newNameState = remember { mutableStateOf<String>("") }
    Surface(color = Color.White, modifier = Modifier.fillMaxSize()) {
        DynamicListWithState(names, newNameState, { names.add(newNameState.value) }) { name ->
            newNameState.value = name
        }
    }
}

@Composable
fun DynamicList(namesList: MutableList<String>) {
    Column {
        for (name in namesList) {
            Label(name)
        }
        Button(onClick = {
            namesList.add("New Item")
        }) {
            Text("Add item")
        }
    }
}

@Composable
fun DynamicListWithState(
    names: List<String>,
    newNameState: MutableState<String>,
    buttonClick: () -> Unit,
    valueChangeListener: (name: String) -> Unit
) {
    Column {
        for (name in names) {
            Label(name)
        }
        TextField(value = newNameState.value, onValueChange = valueChangeListener)
        Button(onClick = buttonClick) {
            Text("Add item")
        }
    }
}

@Composable
fun Label(name: String) {
    Text(text = name, modifier = Modifier.padding(10.dp))
}
