package com.haris.truecaller.utils

fun String.toTenChar(): String = if (length >= 10) this[9].toString() else ""

fun String.toEveryTenChar(): List<Char> {
    val list = mutableListOf<Char>()
    for (i in 9..length step 10) {
        if (i >= length) break
        list.add(this[i])
    }

    return list
}

fun List<String>.wordCounter(): Int {
    val set = hashSetOf<String>()
    forEach {
        set.add(it)
    }

    return set.size
}