package com.example.DisneyCodeChallenge_Omar.presentation.reservationScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReservationScreen(
    viewModel: ReservationViewModel,
    navController: NavController
) {
    Scaffold(
        topBar = {
            ReservationAppBar()
        },

        content = {

            Column(modifier = Modifier.padding(it)) {
                GuestSelection(viewModel)

            }
        },
        bottomBar = {
            ReservationContents(viewModel,navController )
            ReservationNeeded(viewModel)
        }
    )
}

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun GuestSelection(viewModel: ReservationViewModel) {

    val counterReserved = viewModel.uiState.value.reservedCount
    val counterNotReserved = viewModel.uiState.value.notReservedCount
    
    Column {
        Spacer(modifier = Modifier.height(20.dp))
        CatHeader(text = "These Guests Have Reservations", viewModel = viewModel)
        Spacer(modifier = Modifier.height(5.dp))
        LazyColumnReserved(0.45f, viewModel)
        Spacer(modifier = Modifier.height(18.dp))
        CatHeader(text = "These Guests Need Reservations", viewModel = viewModel)
        Spacer(modifier = Modifier.height(5.dp))
        LazyColumnNotReserved(1f, viewModel)

        Spacer(modifier = Modifier.height(8.dp))

    }

}


@Composable
fun CatHeader(text: String, viewModel: ReservationViewModel) {
    Text(text = text,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .semantics { heading() }
            .clearAndSetSemantics {
                contentDescription =
                    "List of guests who have a reservation"
            })
}

@Composable
fun LazyColumnReserved(size: Float, viewmodel: ReservationViewModel) {

    val list = listOf(
        "Harry Story",
        "Daniela Parker",
        "Salim Uddin",
        "Aida Bugg",
        "Maureen Biologist",
        "Teri Dactyl",
        "Peg Legge",
        "Allie Grater"
    )
    LazyColumn(modifier = Modifier.fillMaxHeight(size)) {
        items(items = list, itemContent = { item ->
            val checkedState = remember { mutableStateOf(false) }
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .semantics(mergeDescendants = true) {}
                    .clearAndSetSemantics {
                        contentDescription =
                            "$item, checkbox is set to, ${checkedState.value}; double tap to toggle"
                    }
                    .toggleable(value = checkedState.value, onValueChange = {
                        checkedState.value = it
                        if (it) {
                            viewmodel.addToRes()
                        } else {
                            viewmodel.removeFromRes()
                        }
                    })
            ) {

                Checkbox(
                    checked = checkedState.value,
                    onCheckedChange = {
                        checkedState.value = it
                        if (it) {
                            viewmodel.addToRes()
                        } else {
                            viewmodel.removeFromRes()
                        }
                    },

                    )
                Text(
                    text = item,
                    maxLines = 2,
                )
            }
        })
    }
}

@Composable
fun LazyColumnNotReserved(size: Float, viewmodel: ReservationViewModel) {
    val list = listOf(
        "Harry Story",
        "Daniela Parker",
        "Salim Uddin",
        "Aida Bugg",
        "Maureen Biologist",
        "Teri Dactyl",
        "Peg Legge",
        "Allie Grater"
    )
    LazyColumn(modifier = Modifier.fillMaxHeight(size)) {
        items(items = list, itemContent = { item ->
            val checkedState = remember { mutableStateOf(false) }
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .semantics(mergeDescendants = true) {}
                    .clearAndSetSemantics {
                        contentDescription =
                            "$item, checkbox is set to, ${checkedState.value}; double tap to toggle"
                    }
                    .toggleable(value = checkedState.value, onValueChange = {
                        checkedState.value = it
                        if (it) {
                            viewmodel.addToNotRes()
                        } else {
                            viewmodel.removeFromNotRes()
                        }
                    })
            ) {
                Checkbox(checked = checkedState.value, onCheckedChange = {
                    checkedState.value = it
                    if (it) {
                        viewmodel.addToNotRes()
                    } else {
                        viewmodel.removeFromNotRes()
                    }
                })
                Text(
                    text = item, maxLines = 2
                )
            }
        })
    }
}
