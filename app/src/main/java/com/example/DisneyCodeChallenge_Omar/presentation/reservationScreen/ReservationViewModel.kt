package com.example.DisneyCodeChallenge_Omar.presentation.reservationScreen

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ReservationViewModel @Inject constructor() : ViewModel() {
        private val _uiState = MutableStateFlow(UiState())
        val uiState: StateFlow<UiState> = _uiState.asStateFlow()

        fun addToNotRes() {
            uiState.value.notReservedCount++
            if (uiState.value.notReservedCount > 0) {
                _uiState.update { it.copy(notReservedCount = uiState.value.notReservedCount++) }
            }
        }

        fun removeFromNotRes() {

            uiState.value.notReservedCount--
            if (uiState.value.notReservedCount == 0) {
                _uiState.update { it.copy(notReservedCount = uiState.value.notReservedCount--) }
            }

        }

        fun addToRes() {
            uiState.value.reservedCount++
            if (uiState.value.reservedCount > 0) {
                _uiState.update { it.copy(reservedCount = uiState.value.reservedCount++) }
            }
        }

        fun removeFromRes() {

            uiState.value.reservedCount--
            if (uiState.value.reservedCount == 0) {
                _uiState.update { it.copy(reservedCount = uiState.value.reservedCount--) }
            }

        }

        fun snackAppear() {

            if (!uiState.value.bookingState) {
                _uiState.update { it.copy(bookingState = true) }
            }

        }

        fun snackDisappear() {

            if (uiState.value.bookingState) {
                _uiState.update { it.copy(bookingState = false) }
            }

        }

        fun resetValues() {
            uiState.value.reservedCount = 0
            uiState.value.notReservedCount = 0

            if (uiState.value.notReservedCount > 0) {
                _uiState.update {
                    it.copy(notReservedCount = 0)
                    it.copy(reservedCount = 0)
                }
            }
        }
    }
