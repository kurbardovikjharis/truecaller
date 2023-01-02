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
            val words = body.split("[,.!?\\s]+".toRegex())

            words[9]
        }

    private suspend fun everyTenChar(): String =
        withContext(Dispatchers.IO) {
            val doc: Document = Jsoup.connect(url).get()

            val body = doc.body().text()
            val words = body.split("[,.!?\\s]+".toRegex())

            words.toEveryTenChar().toString()
        }

    private suspend fun wordCounter(): String =
        withContext(Dispatchers.IO) {
            val doc: Document = Jsoup.connect(url).get()

            val body = doc.body().text()
            val words = body.split("[,.!?\\s]+".toRegex())

            words.wordCounter().toString()
        }
}

fun List<String>.toEveryTenChar(): List<String> {
    val list = mutableListOf<String>()
    forEachIndexed { index, item ->
        if ((index + 1) % 10 == 0) {
            list.add(item)
        }
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