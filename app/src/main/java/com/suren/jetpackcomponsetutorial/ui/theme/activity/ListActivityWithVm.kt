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
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.suren.jetpackcomponsetutorial.ui.theme.MainViewModel


class ListActivityWithVm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MainScreen(mainViewModel: MainViewModel = MainViewModel()) {
    val newNameState = mainViewModel.nameState.observeAsState("")
    Surface(color = Color.White, modifier = Modifier.fillMaxSize()) {
        Column {
            TextField(value = newNameState.value,
                onValueChange = { newName -> mainViewModel.onTextChanged(newName) })
            Button(onClick = {}) {
                Text(text = newNameState.value)
            }
        }
    }
}
