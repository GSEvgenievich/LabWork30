package com.example.labwork30

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.labwork30.ui.theme.LabWork30Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabWork30Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }
    Column(modifier = modifier) {
        Text(
            text = text
        )
        Button(onClick = { text = "${5} / ${0} = ${Divide(5.0, 0.0)}" }) {
            Text(
                text = "Делить"
            )
        }
    }
}

fun Divide(a: Double, b: Double, logger: Logger = AndroidLogger): Double {
    logger.v("LabWork30", "Вызов divide с аргументами a=$a, b=$b")

    if (b == 0.0) {
        logger.e("LabWork30", "Ошибка: деление на ноль")
        throw IllegalArgumentException("Деление на ноль невозможно")
    }

    logger.d("LabWork30", "Выполняется деление")
    val result = a / b
    logger.i("LabWork30", "Результат деления: $result")
    logger.w("LabWork30", "Проверка выполнения функции divide")
    return result
}

interface Logger {
    fun v(tag: String, msg: String)
    fun e(tag: String, msg: String)
    fun d(tag: String, msg: String)
    fun i(tag: String, msg: String)
    fun w(tag: String, msg: String)
}

object AndroidLogger : Logger {
    override fun v(tag: String, msg: String){
        Log.v(tag, msg)
    }
    override fun e(tag: String, msg: String) {
        Log.e(tag, msg)
    }
    override fun d(tag: String, msg: String) {
        Log.d(tag, msg)
    }
    override fun i(tag: String, msg: String) {
        Log.i(tag, msg)
    }
    override fun w(tag: String, msg: String) {
        Log.w(tag, msg)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
}