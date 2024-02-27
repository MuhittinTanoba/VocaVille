package com.example.vocaville

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.VocaVilleTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VocaVilleTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}


@Composable
fun HomeScreen(modifier: Modifier){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 80.dp),
        horizontalArrangement = Arrangement.Center
    ){
        Column(modifier) {
            Header(modifier = modifier)

            Column(modifier = modifier
                .padding(top = 100.dp)
                .align(
                    Alignment.CenterHorizontally
                )
            ) {
                StartButton(
                    onClick = { /*TODO*/ },
                    modifier = modifier.align(Alignment.CenterHorizontally)
                )
                SettingButton(onClick = { /*TODO*/ })
            }
        }
    }
}

@Composable
fun Header(modifier: Modifier) {
    Text(
        fontSize = 40.sp,
        text = "VocaVille"
    )
}

@Composable
fun StartButton(onClick: () -> Unit, modifier: Modifier){
    Button(onClick = { onClick() }, modifier = modifier){
        Text(text = "Start")
    }
}

@Composable
fun SettingButton(onClick: () -> Unit) {
    Button(onClick = { onClick() }) {
        Text(text = "Setting")
    }
}

