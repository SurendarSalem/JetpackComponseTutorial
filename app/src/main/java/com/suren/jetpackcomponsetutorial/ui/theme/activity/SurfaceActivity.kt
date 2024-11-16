package com.suren.jetpackcomponsetutorial.ui.theme.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class SurfaceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreenColumn()
        }
    }
}

@Composable
fun MainScreenRow() {
    Surface(
        color = Color.Yellow,
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .background(Color.Gray)
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            HorizontalBar(Color.Red)
            HorizontalBar(Color.Yellow)
            HorizontalBar(Color.Green)
            HorizontalBar(Color.Blue)
            HorizontalBar(Color.Cyan)
        }
    }
}

@Composable
fun MainScreenColumn() {
    Surface(
        color = Color.Yellow,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .background(Color.Gray)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            VerticalBar(Color.Red)
            VerticalBar(Color.Yellow)
            VerticalBar(Color.Green)
            VerticalBar(Color.Blue)
            VerticalBar(Color.Cyan)
            VerticalBar(Color.Red)
        }
    }
}

@Preview
@Composable
fun RowAndColumn() {
    Surface(
        color = Color.Yellow,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .background(Color.Gray)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier
                    .background(Color.Gray)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Square(Color.Red)
                Square(Color.Yellow)
            }

            Square(Color.Green)
            Square(Color.Blue)
            Square(Color.Cyan)
            Square(Color.Red)
        }
    }
}


@Composable
fun HorizontalBar(color: Color) {
    Surface(
        color = color, modifier = Modifier
            .width(60.dp)
            .height(300.dp)
    ) {

    }
}

@Composable
fun VerticalBar(color: Color) {
    Surface(
        color = color, modifier = Modifier
            .width(300.dp)
            .height(60.dp)
    ) {

    }
}

@Composable
fun Square(color: Color) {
    Surface(
        color = color, modifier = Modifier
            .width(100.dp)
            .height(100.dp)
    ) {}
}