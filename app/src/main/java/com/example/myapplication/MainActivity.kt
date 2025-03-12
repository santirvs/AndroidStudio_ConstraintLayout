package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
                    MyConstraintLayout(modifier = Modifier.padding(padding))
                }

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hola $name!",
        modifier = modifier
    )
}

@Composable
fun MyConstraintLayout(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier.fillMaxSize()) {
        val (boxRed, boxYellow, boxGreen, boxCyan, boxMagenta) = createRefs()

        Box(modifier = Modifier.size(120.dp).background(Color.Red).constrainAs(boxRed){
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })
        Box(modifier = Modifier.size(120.dp).background(Color.Yellow).constrainAs(boxYellow){
            bottom.linkTo(boxRed.top)
            start.linkTo(boxRed.start)
        })
        Box(modifier = Modifier.size(120.dp).background(Color.Green).constrainAs(boxGreen){
            top.linkTo(boxRed.bottom)
            start.linkTo(boxRed.start)
        })
        Box(modifier = Modifier.size(120.dp).background(Color.Cyan).constrainAs(boxCyan){
            bottom.linkTo(boxRed.bottom)
            end.linkTo(boxRed.start)
        })
        Box(modifier = Modifier.size(120.dp).background(Color.Magenta).constrainAs(boxMagenta){
            bottom.linkTo(boxRed.bottom)
            start.linkTo(boxRed.end)
        })

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        MyConstraintLayout()
    }
}