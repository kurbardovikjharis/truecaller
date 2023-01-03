package com.haris.truecaller.repositories

import com.haris.truecaller.data.RequestType
import com.haris.truecaller.utils.toEveryTenChar
import com.haris.truecaller.utils.toTenChar
import com.haris.truecaller.utils.wordCounter
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