package edu.rit.mm9149.helloworldtwo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.rit.mm9149.helloworldtwo.ui.theme.HelloWorldTwoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                CounterMessage()
        }
    }
}

data class Message(val author: String, val body: String)

@Composable
fun MessageCard(msg: Message) {
    Column {
        Text(text = (msg.author))
        Text(text = (msg.body))
    }
}

@Composable
fun CounterMessage() {
    var counter = 0
    val context = LocalContext.current

    Column {
        horizontalAlignment = Alignment.CenterHorizontally
        modifier = Modifier.padding(all = 30.dp)
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HelloWorldTwoTheme {
        MessageCard(msg = Message("Mark", "Hello Mark"))
    }
}