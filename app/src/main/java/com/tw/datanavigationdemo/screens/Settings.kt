package com.tw.datanavigationdemo.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


//Settings Composable which receives counter as parameter passed down as arguments from home screen
@Composable
fun Setting(data: String?) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White), contentAlignment = Alignment.Center
    ) {
        Column {

            Text(text = "Navigation with arguments", Modifier.padding(10.dp), color = Color.Black)

            //Display the counter
            Text(
                text = "Settings Screen, with passed data is $data",
                Modifier.padding(10.dp),
                color = Color.Black
            )

        }
    }
}