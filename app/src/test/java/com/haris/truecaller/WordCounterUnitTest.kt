package com.haris.truecaller

import com.haris.truecaller.utils.wordCounter
import org.junit.Assert.assertEquals
import org.junit.Test

class WordCounterUnitTest {
    @Test
    fun empty_isCorrect() {
        assertEquals(0, TestData.empty.wordCounter())
    }

    @Test
    fun less10_isCorrect() {
        assertEquals(1, TestData.less10.wordCounter())
    }

    @Test
    fun more10_isCorrect() {
        assertEquals(11, TestData.more10.wordCounter())
    }

    @Test
    fun more20_isCorrect() {
        assertEquals(21, TestData.more20.wordCounter())
    }

    @Test
    fun duplicates_isCorrect() {
        assertEquals(5, TestData.duplicates.wordCounter())
    }

    @Test
    fun caseSensitive_isCorrect() {
        assertEquals(3, TestData.caseSensitive.wordCounter())
    }
}