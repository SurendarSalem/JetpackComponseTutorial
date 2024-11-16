package com.suren.jetpackcomponsetutorial.ui.theme.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class SimpleTextViewActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingButton("Hello Suren")
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = name, modifier = Modifier
            .size(80.dp)
            .clickable(onClick = {})
            .padding(10.dp)
    )
}

@Composable
fun GreetingMaxSize(name: String) {
    Text(
        text = name, modifier = Modifier.fillMaxSize()
    )
}

@Composable
fun CustomText(name: String) {
    Text(
        text = name,
        modifier = Modifier
            .width(160.dp)
            .height(60.dp)
            .padding(10.dp),
        style = TextStyle(color = Color.Red, background = Color.White)
    )
}

@Composable
fun GreetingButton(name: String) {
    Button(onClick = {}) {
        Text(
            text = name, modifier = Modifier.fillMaxWidth()
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreviews() {
    CustomText("Hello Suren")
}