package com.tw.datanavigationdemo.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.tw.datanavigationdemo.Routes



@Composable
fun Home(navController: NavHostController) {

    //Create a basic counter to display on screen
    var data by remember {
        mutableStateOf("Binny's World")
    }

    //Box composable to center Items
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White), contentAlignment = Alignment.Center
    ) {

        //A Column composable
        Column {

            //A Text Composable to show counter on Screen
            Text(text = "Home, Data is $data", color = Color.Black)


            Spacer(modifier = Modifier.height(20.dp))
            //A button composable to navigate to Profile Screen
            Button(onClick = {

                navController.navigate(Routes.Profile.route)
            }) {
                Text(text = "Navigate to Profile", color = Color.White)
            }

            Spacer(modifier = Modifier.height(20.dp))
            //A Button Composable to navigate to Settings Screen when clicked
            Button(onClick = {

                navController.navigate(Routes.Settings.route + "/$data")

            }) {
                Text(text = "Navigate to Settings", color = Color.White)
            }

        }

    }
}