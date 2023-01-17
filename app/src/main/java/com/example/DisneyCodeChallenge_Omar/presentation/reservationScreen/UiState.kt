package com.example.DisneyCodeChallenge_Omar.presentation.reservationScreen

data class UiState(
    var bookingState: Boolean = false,
    var reservedCount: Int = 0,
    var notReservedCount: Int = 0,
    val reservationCheck: Boolean = false,
    val hasReservation: Boolean = false,

    )
