package com.haris.truecaller

object TestData {

    val empty = emptyList<String>()
    val less10 = listOf("1")
    val more10 = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11")
    val more20 = listOf(
        "1",
        "2",
        "3",
        "4",
        "5",
        "6",
        "7",
        "8",
        "9",
        "10",
        "11",
        "12",
        "13",
        "14",
        "15",
        "16",
        "17",
        "18",
        "19",
        "20",
        "21"
    )
    val duplicates = listOf("1", "1", "2", "2", "3", "4", "5", "3", "4", "5")
    val caseSensitive = listOf("a", "b", "c", "A", "B", "C", "a", "B", "c")
}