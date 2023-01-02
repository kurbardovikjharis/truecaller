package com.haris.truecaller

import com.haris.truecaller.repositories.toEveryTenChar
import org.junit.Assert.assertEquals
import org.junit.Test

class EveryTenCharUnitTest {
    @Test
    fun empty_isCorrect() {
        assertEquals(emptyList<String>().toString(), TestData.empty.toEveryTenChar().toString())
    }

    @Test
    fun less10_isCorrect() {
        assertEquals(emptyList<String>().toString(), TestData.less10.toEveryTenChar().toString())
    }

    @Test
    fun more10_isCorrect() {
        assertEquals(listOf("10").toString(), TestData.more10.toEveryTenChar().toString())
    }

    @Test
    fun more20_isCorrect() {
        assertEquals(listOf("10", "20").toString(), TestData.more20.toEveryTenChar().toString())
    }
}