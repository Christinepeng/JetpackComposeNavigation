package com.example.jetpackcomposenavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposenavigation.ui.theme.JetpackComposeNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeNavigationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        Greeting()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController)
        }
        composable("detail/{message}") { navBackStackEntry ->  
            val message = navBackStackEntry.arguments?.getString("message")?: ""
            DetailScreen(navController, message)
        }
    }
}

@Composable
fun HomeScreen(navController: NavController) {
    Button(onClick = {
        navController.navigate("detail/Hello from HomeScreen")
    }) {
        Text(text = "Go to Detail Screen")
    }
}

@Composable
fun DetailScreen(navController: NavController, message: String) {
    Text(text = "Message from HomeScreen: $message")
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeNavigationTheme {
        Greeting()
    }
}