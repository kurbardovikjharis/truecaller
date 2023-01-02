package com.haris.truecaller.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.haris.truecaller.repositories.MainRepository
import com.haris.truecaller.repositories.RequestType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    private val isLoading = MutableStateFlow(false)

    private val first = MutableStateFlow("")
    private val second = MutableStateFlow("")
    private val third = MutableStateFlow("")

    val state: StateFlow<MainViewState> =
        combine(first, second, third, isLoading) { first, second, third, isLoading ->
            MainViewState(
                first = first,
                second = second,
                third = third,
                isLoading = isLoading
            )
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = MainViewState.Empty
        )

    fun fetch() {
        isLoading.value = true
        viewModelScope.launch {
            first.value = mainRepository.fetch(RequestType.TenChar)
            isLoading.value = false // not loading once one request is done
        }
        viewModelScope.launch {
            second.value = mainRepository.fetch(RequestType.EveryTenChar)
            isLoading.value = false // not loading once one request is done
        }
        viewModelScope.launch {
            third.value = mainRepository.fetch(RequestType.WordCounter)
            isLoading.value = false // not loading once one request is done
        }
    }
}