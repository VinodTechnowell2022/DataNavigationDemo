package com.tw.datanavigationdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tw.datanavigationdemo.screens.Home
import com.tw.datanavigationdemo.screens.Profile
import com.tw.datanavigationdemo.screens.Setting
import com.tw.datanavigationdemo.ui.theme.DataNavigationDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface(color = MaterialTheme.colorScheme.background) {
                ScreenMain()
            }
        }
    }
}

@Composable
fun ScreenMain() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.Home.route) {

        //First route : Home
        composable(Routes.Home.route) {

            //Lay down the Home Composable and pass the navController
            Home(navController = navController)
        }

        //Another Route : Profile
        composable(Routes.Profile.route) {
            //Profile Screen
            Profile()
        }

        //Settings Route, Notice the "/{id}" in last, its the argument passed down from homeScreen
        composable(Routes.Settings.route + "/{data}") { navBackStack ->

            //Extracting the argument
            val counter = navBackStack.arguments?.getString("data")

            //Setting screen, Pass the extracted Counter
            Setting(data = counter)

        }
    }
}