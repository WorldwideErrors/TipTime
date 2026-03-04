package com.example.tiptime

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotSame
import org.junit.Test
import java.text.NumberFormat

class TipCalculatorTests {

    @Test
    fun calculateTip_20PercentNoRoundup() {
        val amount = 10.00
        val tipPercent = 20.00
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        val actualTip = calculateTip(amount = amount, tipPercent = tipPercent, false)
        assertEquals(expectedTip, actualTip)
    }

    @Test
    fun calculateTip_33PercentRoundup() {
        val amount = 10.00
        val tipPercent = 33.00
        val expectedTip = NumberFormat.getCurrencyInstance().format(4)
        val actualTip = calculateTip(amount = amount, tipPercent = tipPercent, true)
        assertEquals(expectedTip, actualTip)
    }

    @Test
    fun calculateTip_33PercentRoundupNotSame() {
        val amount = 10.00
        val tipPercent = 33.00
        val expectedTip = NumberFormat.getCurrencyInstance().format(3.3)
        val actualTip = calculateTip(amount = amount, tipPercent = tipPercent, true)
        assertNotSame(expectedTip, actualTip)
    }
}