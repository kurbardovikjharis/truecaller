package com.haris.truecaller

import com.haris.truecaller.repositories.toEveryTenChar
import org.junit.Assert.assertEquals
import org.junit.Test

class EveryTenCharUnitTest {
    @Test
    fun empty_isCorrect() {
        assertEquals(
            emptyList<String>().toString(),
            TestData.emptyString.toEveryTenChar().toString()
        )
    }

    @Test
    fun less10_isCorrect() {
        assertEquals(
            emptyList<String>().toString(),
            TestData.less10String.toEveryTenChar().toString()
        )
    }

    @Test
    fun more10_isCorrect() {
        assertEquals(listOf("X").toString(), TestData.more10String.toEveryTenChar().toString())
    }

    @Test
    fun more20_isCorrect() {
        assertEquals(
            listOf("X", "X").toString(),
            TestData.more20String.toEveryTenChar().toString()
        )
    }
}