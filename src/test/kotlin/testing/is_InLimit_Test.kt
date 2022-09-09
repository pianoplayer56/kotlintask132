package testing

import org.junit.Test

import org.junit.Assert.*

class is_InLimit_Test {

    @Test
    fun isInLimitVkPayTrue() {
        val cardVk = "Vk Pay"
        val lastTransfersVk = 10_000_01
        val currentTransferVk = 14_999_99

        val resultVk = isInLimit(
            card = cardVk,
            lastTransfers = lastTransfersVk,
            currentTransfer = currentTransferVk
        )

        assertEquals(true, resultVk)
    }

    @Test
    fun isInLimitVkPayCurrentTransferFalse() {
        val cardVk = "Vk Pay"
        val lastTransfersVk = 10_000_01
        val currentTransferVk = 15_000_01

        val resultVk = isInLimit(
            card = cardVk,
            lastTransfers = lastTransfersVk,
            currentTransfer = currentTransferVk
        )

        assertEquals(false, resultVk)
    }

    @Test
    fun isInLimitVkPayFalse() {
        val cardVk = "Vk Pay"
        val lastTransfersVk = 40_000_01
        val currentTransferVk = 15_000_01

        val resultVk = isInLimit(
            card = cardVk,
            lastTransfers = lastTransfersVk,
            currentTransfer = currentTransferVk
        )

        assertEquals(false, resultVk)
    }

    @Test
    fun isInLimitVkPayLastTransferFalse() {
        val cardVk = "Vk Pay"
        val lastTransfersVk = 40_000_01
        val currentTransferVk = 14_000_01

        val resultVk = isInLimit(
            card = cardVk,
            lastTransfers = lastTransfersVk,
            currentTransfer = currentTransferVk
        )

        assertEquals(false, resultVk)
    }

    @Test
    fun isInLimitVisaTrue() {
        val cardVisa = "Visa"
        val lastTransfersVisa = 1_000_01
        val currentTransferVisa = 149_999_99

        val resultVisa = isInLimit(
            card = cardVisa,
            lastTransfers = lastTransfersVisa,
            currentTransfer = currentTransferVisa
        )

        assertEquals(true, resultVisa)
    }

    @Test
    fun isInLimitVisaFalse() {
        val cardVisa = "Visa"
        val lastTransfersVisa = 450_000_00
        val currentTransferVisa = 150_000_01

        val resultVisa = isInLimit(
            card = cardVisa,
            lastTransfers = lastTransfersVisa,
            currentTransfer = currentTransferVisa
        )

        assertEquals(false, resultVisa)
    }

    @Test
    fun isInLimitVisaCurrentTransferFalse() {
        val cardVisa = "Visa"
        val lastTransfersVisa = 1_000_01
        val currentTransferVisa = 150_000_01

        val resultVisa = isInLimit(
            card = cardVisa,
            lastTransfers = lastTransfersVisa,
            currentTransfer = currentTransferVisa
        )

        assertEquals(false, resultVisa)
    }

    @Test
    fun isInLimitVisaLastTransferFalse() {
        val cardVisa = "Visa"
        val lastTransfersVisa = 600_000_01
        val currentTransferVisa = 149_999_99

        val resultVisa = isInLimit(
            card = cardVisa,
            lastTransfers = lastTransfersVisa,
            currentTransfer = currentTransferVisa
        )

        assertEquals(false, resultVisa)
    }

}