package testing

import countTax
import org.junit.Test

import org.junit.Assert.*

class countTaxTest {

    @Test
    fun countVkPayDefaultTaxTest() {
        val testCurrentTransfer = 5_000_00

        val result = countTax(
            currentTransfer = testCurrentTransfer
        )

        assertEquals(0.0, result)
    }

    @Test
    fun countVkPayTaxTest() {
        val testCard = "Vk Pay"
        val testLastTransfers = 20_000_00
        val testCurrentTransfer = 5_000_00

        val result = countTax(
            card = testCard,
            lastTransfers = testLastTransfers,
            currentTransfer = testCurrentTransfer
        )

        assertEquals(0.0, result)
    }

    @Test
    fun countVisaMore35_00TaxTest() {
        val testCard = "Visa"
        val testLastTransfers = 5_000_00
        val testCurrentTransfer = 5_000_00

        val result = countTax(
            card = testCard,
            lastTransfers = testLastTransfers,
            currentTransfer = testCurrentTransfer
        )

        assertEquals(testCurrentTransfer * 0.0075, result)
    }

    @Test
    fun countVisaLess35_00TaxTest() {
        val testCard = "Visa"
        val testLastTransfers = 5_000_00
        val testCurrentTransfer = 1_000_00

        val result = countTax(
            card = testCard,
            lastTransfers = testLastTransfers,
            currentTransfer = testCurrentTransfer
        )

        assertEquals(3500.0, result)
    }

    @Test
    fun countMirTaxTest() {
        val testCard = "Мир"
        val testLastTransfers = 5_000_00
        val testCurrentTransfer = 5_000_00

        val result = countTax(
            card = testCard,
            lastTransfers = testLastTransfers,
            currentTransfer = testCurrentTransfer
        )

        assertEquals(testCurrentTransfer * 0.0075, result)
    }

    @Test
    fun countIncorrectCardTaxTest() {
        val testCard = "Мирок"
        val testLastTransfers = 5_000_00
        val testCurrentTransfer = 5_000_00

        val result = countTax(
            card = testCard,
            lastTransfers = testLastTransfers,
            currentTransfer = testCurrentTransfer
        )

        assertEquals(null, result)
    }

    @Test
    fun countMaestroLess75_000TaxTest() {
        val testCard = "Maestro"
        val testLastTransfers = 5_000_00
        val testCurrentTransfer = 5_000_00

        val result = countTax(
            card = testCard,
            lastTransfers = testLastTransfers,
            currentTransfer = testCurrentTransfer
        )

        assertEquals(0.0, result)
    }

    @Test
    fun countMasterCardLess75_000TaxTest() {
        val testCard = "Master Card"
        val testLastTransfers = 5_000_00
        val testCurrentTransfer = 5_000_00

        val result = countTax(
            card = testCard,
            lastTransfers = testLastTransfers,
            currentTransfer = testCurrentTransfer
        )

        assertEquals(0.0, result)
    }

    @Test
    fun countMaestroMore75_000TaxTest() {
        val testCard = "Maestro"
        val testLastTransfers = 5_000_00
        val testCurrentTransfer = 75_000_01

        val result = countTax(
            card = testCard,
            lastTransfers = testLastTransfers,
            currentTransfer = testCurrentTransfer
        )

        assertEquals(testCurrentTransfer * 0.006 + 20_00, result)
    }

    @Test
    fun countMasterCardMore75_000TaxTest() {
        val testCard = "Master Card"
        val testLastTransfers = 5_000_00
        val testCurrentTransfer = 76_000_00

        val result = countTax(
            card = testCard,
            lastTransfers = testLastTransfers,
            currentTransfer = testCurrentTransfer
        )

        assertEquals(testCurrentTransfer * 0.006 + 20_00, result)
    }
}

