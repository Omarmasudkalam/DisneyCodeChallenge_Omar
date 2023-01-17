package com.example.DisneyCodeChallenge_Omar.navigation

sealed class Screen (val route: String) {
    object ConfirmationScreen : Screen("confirmation_screen")
    object GuestReservationScreen : Screen("guest_screen")// first screen
    object ConflictScreen : Screen("conflict_screen")
}
