package com.haris.truecaller

import com.haris.truecaller.utils.toTenChar
import org.junit.Assert.assertEquals
import org.junit.Test

class TenCharUnitTest {
    @Test
    fun empty_isCorrect() {
        assertEquals("", TestData.emptyString.toTenChar())
    }

    @Test
    fun less10_isCorrect() {
        assertEquals("", TestData.less10String.toTenChar())
    }

    @Test
    fun more10_isCorrect() {
        assertEquals("X", TestData.more10String.toTenChar())
    }

    @Test
    fun more20_isCorrect() {
        assertEquals("X", "X", TestData.more20String.toTenChar())
    }
}