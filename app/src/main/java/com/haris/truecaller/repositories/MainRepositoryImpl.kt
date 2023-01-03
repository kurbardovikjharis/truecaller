package com.haris.truecaller.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor() : MainRepository {

    private val url =
        "https://www.truecaller.com/blog/life-at-truecaller/life-as-an-android-engineer"

    override suspend fun fetch(type: RequestType): String {
        return when (type) {
            RequestType.TenChar -> tenChar()
            RequestType.EveryTenChar -> everyTenChar()
            RequestType.WordCounter -> wordCounter()
        }
    }

    private suspend fun tenChar(): String =
        withContext(Dispatchers.IO) {
            val doc: Document = Jsoup.connect(url).get()

            val body = doc.body().text()

            body.toTenChar()
        }

    private suspend fun everyTenChar(): String =
        withContext(Dispatchers.IO) {
            val doc: Document = Jsoup.connect(url).get()

            val body = doc.body().text()

            body.toEveryTenChar().toString()
        }

    private suspend fun wordCounter(): String =
        withContext(Dispatchers.IO) {
            val doc: Document = Jsoup.connect(url).get()

            val body = doc.body().text()
            val words = body.split("[,.!?\\s]+".toRegex())

            words.wordCounter().toString()
        }
}

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

enum class RequestType {
    TenChar,
    EveryTenChar,
    WordCounter
}