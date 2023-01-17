package com.example.DisneyCodeChallenge_Omar.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.DisneyCodeChallenge_Omar.presentation.ConfirmationScreen
import com.example.DisneyCodeChallenge_Omar.presentation.ConflictScreen
import com.example.DisneyCodeChallenge_Omar.presentation.reservationScreen.ReservationScreen
import com.example.DisneyCodeChallenge_Omar.presentation.reservationScreen.ReservationViewModel

/**
 * Created by OMK on 16/01/2023.
 */

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.GuestReservationScreen.route) {
        composable(Screen.GuestReservationScreen.route) {
            ReservationScreen(viewModel = ReservationViewModel(), navController = navController)
        }
        composable(Screen.ConfirmationScreen.route) {
            ConfirmationScreen()
        }
        composable(Screen.ConflictScreen.route) {
            ConflictScreen(navController = navController)
        }
    }
}