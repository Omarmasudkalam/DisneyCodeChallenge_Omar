package com.example.DisneyCodeChallenge_Omar.presentation.reservationScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.DisneyCodeChallenge_Omar.navigation.Screen

@Composable
fun ReservationContents(viewModel: ReservationViewModel, navController: NavController) {
    BottomAppBar(
            modifier = Modifier
                .background(Color.White)
                .height(130.dp)
        ) {

            val uiState by viewModel.uiState.collectAsState()

            Column {
                val context = LocalContext.current
                RequirementMessage()
                Button(
                    onClick = {
                        if (uiState.reservedCount != 0 && uiState.notReservedCount != 0) {
                            navController.navigate(Screen.ConflictScreen.route)
                            viewModel.resetValues()
                        } else if (uiState.reservedCount != 0) {
                            navController.navigate(Screen.ConfirmationScreen.route)
                            viewModel.resetValues()
                        } else if (uiState.reservedCount == 0) {
                            viewModel.snackAppear()
                        }

                    },
                    shape = RoundedCornerShape(25.dp),
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .fillMaxWidth(),
                    enabled = ((uiState.notReservedCount > 0) || (uiState.reservedCount > 0))
                ) {
                    Text(text = "Continue", fontSize = 16.sp)
                }
            }

        }
    }

    @Composable
    fun RequirementMessage() {
        Row {
            Icon(
                Icons.Default.Info,
                contentDescription = "Close, reservation needed, pop up",
                modifier = Modifier.padding(horizontal = 10.dp)
            )
            Text(
                text = "At least one guest must have a reservation. Guests without reservations must remain in the same.",
                fontSize = 14.sp
            )
        }
    }
