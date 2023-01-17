package com.example.DisneyCodeChallenge_Omar.presentation.reservationScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ReservationNeeded(viewModel: ReservationViewModel) {
    Column(verticalArrangement = Arrangement.Bottom) {

        val uiState by viewModel.uiState.collectAsState()

        if (uiState.bookingState) {
            Snackbar(
                action = {
                    IconButton(onClick = {
                        viewModel.snackDisappear()
                    }) {
                        Icon(
                            Icons.Filled.Done, contentDescription = "Close popup"
                        )
                    }
                }, modifier = Modifier.padding(8.dp)
            ) {
                Column {
                    Text(text = "Reservation Needed!", fontWeight = FontWeight.Bold)
                    Text(text = "Select at least one Guest that has a reservation to continue.")
                }
            }
        }
    }
}