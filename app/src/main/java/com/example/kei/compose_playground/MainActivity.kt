package com.example.kei.compose_playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.kei.compose_playground.repository.DemoContentsRepository
import com.example.kei.compose_playground.ui.HeaderContents
import com.example.kei.compose_playground.ui.MainHeader
import com.example.kei.compose_playground.ui.theme.Compose_playgroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fetchHeaderContents = DemoContentsRepository().fetchHeaderContents()
        setContent {
            Compose_playgroundTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
//                    Column {
//                        MainHeader(contentsList = fetchHeaderContents)
                        HeaderContents(content = fetchHeaderContents[0])
//                    }
//                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Compose_playgroundTheme {
        Greeting("Android")
    }
}