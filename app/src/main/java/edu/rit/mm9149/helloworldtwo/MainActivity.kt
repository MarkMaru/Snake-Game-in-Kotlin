package edu.rit.mm9149.helloworldtwo

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        Text(text = "Hello ${msg.author}")
        Text(text = msg.body)
    }
}

@Composable
fun CounterMessage() {
//    var countState by remember {
//        mutableStateOf(0)
//    }

    var countState by rememberSaveable {
        mutableStateOf(0)
    }

    val context = LocalContext.current

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(all = 30.dp)
            .fillMaxWidth()
    ) {
        Surface(shape = MaterialTheme.shapes.medium, elevation = 10.dp) {
            Text(text = "$countState",
                color = MaterialTheme.colors.secondary,
                style = MaterialTheme.typography.h1,
                modifier = Modifier
                    .then(if (countState > 5) Modifier.background(Color.Red) else Modifier)
                    .then(if (countState > 15) Modifier.background(Color.Green) else Modifier)
                    .padding(all = 20.dp),
                fontSize = 72.sp)
        }
        
        Spacer(modifier = Modifier.padding(all = 8.dp))

        ButtonRow(count = countState,
            updateCount = {
            newCount -> countState = newCount
        })
    }
}

@Composable
fun CountButton(count: Int, updateCount: (Int) -> Unit) {

    Button(onClick = {
        updateCount(count + 1)
    }) {
        Text(text = "Count")
    }

}

@Composable
fun ToastButton(count: Int) {

    val context = LocalContext.current

    Button(onClick = {
        Toast.makeText(context, " The count is $count", Toast.LENGTH_LONG).show()
    }) {
        Text("Toast")
    }

}

@Composable
fun ButtonRow(count: Int, updateCount: (Int) -> Unit) {

    Row(modifier = Modifier.padding(all = 8.dp)) {

        ToastButton(count = count)
        Spacer(modifier = Modifier.padding(all = 8.dp))
        CountButton(count = count, updateCount = updateCount)
    }

}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    HelloWorldTwoTheme {
//        CounterMessage()
//    }
//}
@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PreviewCounterMessage() {
    HelloWorldTwoTheme {
        CounterMessage()
    }
}