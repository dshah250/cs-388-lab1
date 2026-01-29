package com.example.simplecounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplecounter.ui.theme.SimpleCounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleCounterTheme {
                CounterApp()
            }
        }
    }
}

@Composable
fun CounterApp() {
    var count by remember { mutableStateOf(0) }
    var upgradeToOneHundred by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            if (count >= 100 && !upgradeToOneHundred) {
                Button(
                    onClick = { upgradeToOneHundred = true },
                    shape = RectangleShape,
                    modifier = Modifier.align(Alignment.TopCenter)
                ) {
                    Text("UPGRADE TO ADD 2")
                }
            }

            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = count.toString(), fontSize = 36.sp)
                Spacer(modifier = Modifier.height(16.dp))
                IconButton(onClick = {
                    if (upgradeToOneHundred) {
                        count += 2
                    } else {
                        count++
                    }
                }) {
                    Icon(
                        Icons.Default.Pets,
                        contentDescription = "Add 1",
                        modifier = Modifier.size(48.dp)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    painter = painterResource(id = R.drawable.dog_cartoon),
                    contentDescription = "Cartoon dog"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CounterAppPreview() {
    SimpleCounterTheme {
        CounterApp()
    }
}
