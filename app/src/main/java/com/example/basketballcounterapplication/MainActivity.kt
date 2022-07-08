package com.example.basketballcounterapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.basketballcounterapplication.ui.theme.BasketballCounterApplicationTheme

class MainActivity : ComponentActivity() {
    private val MyViewModel by viewModels<MyViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                    MainScreen(MyViewModel = MyViewModel)
        }
    }
}
@Composable
fun MainScreen(MyViewModel: MyViewModel) {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "TEAM A",
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier.padding(top = 50.dp)
                )
                Text(
                    text = MyViewModel.countA.toString(),
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier.padding(20.dp)
                )
                Button(onClick = { MyViewModel.inc(0,1) }, modifier = Modifier.padding(20.dp)) {
                    Text(text = "+1 Point", style = MaterialTheme.typography.h5)
                }
                Button(onClick = {MyViewModel.inc(0,2)}, modifier = Modifier.padding(20.dp)) {
                    Text(text = "+2 Point", style = MaterialTheme.typography.h5)
                }
                Button(onClick = {MyViewModel.inc(0,3)}, modifier = Modifier.padding(20.dp)) {
                    Text(text = "+3 Point", style = MaterialTheme.typography.h5)
                }
            }
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "TEAM B",
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier.padding(top = 50.dp)
                )
                Text(
                    text = MyViewModel.countB.toString(),
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier.padding(20.dp)
                )
                Button(onClick = { MyViewModel.inc(1,1) }, modifier = Modifier.padding(20.dp)) {
                    Text(text = "+1 Point", style = MaterialTheme.typography.h5)
                }
                Button(onClick = {MyViewModel.inc(1,2)}, modifier = Modifier.padding(20.dp)) {
                    Text(text = "+2 Point", style = MaterialTheme.typography.h5)
                }
                Button(onClick = {MyViewModel.inc(1,3)}, modifier = Modifier.padding(20.dp)) {
                    Text(text = "+3 Point", style = MaterialTheme.typography.h5)
                }
            }

        }
        OutlinedButton(onClick = { MyViewModel.countA = 0
            MyViewModel.countB = 0
        }) {
            Text(text = "RESET",style = MaterialTheme.typography.h5)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BasketballCounterApplicationTheme {
        MainScreen(MyViewModel = MyViewModel())
    }
}
