package com.example.DisneyCodeChallenge_Omar.presentation

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.DisneyCodeChallenge_Omar.navigation.Screen

@Composable
fun ConflictScreen(navController: NavController) {
    Button(onClick = { navController.navigate(Screen.ConfirmationScreen.route)}) {

    }
    Text(text = "Conflict Screen", fontSize = 25.sp, textAlign = TextAlign.Center)
}
