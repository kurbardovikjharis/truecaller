package com.haris.truecaller.viewmodels

import javax.annotation.concurrent.Immutable

@Immutable
data class MainViewState(
    val first: String = "",
    val second: String = "",
    val third: String = "",
    val isLoading: Boolean = false
) {

    companion object {
        val Empty = MainViewState()
    }
}