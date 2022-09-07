fun countTax(card: String = "Vk Pay", lastTransfers: Int = 0, currentTransfer: Int): Double? =
    when (card) {
        "Vk Pay" ->  0.0

        "Master Card", "Maestro" -> if (currentTransfer < 75_000_00) 0.0
        else currentTransfer * 0.006 + 20_00

        "Visa", "Мир" -> if (currentTransfer * 0.0075 < 35_00) 35_00.0
        else currentTransfer * 0.0075

        else -> null
    }

fun isInLimit(card: String, lastTransfers: Int, currentTransfer: Int): Boolean =
    if (card == "Vk Pay") (lastTransfers + currentTransfer < 40_000_00
            && currentTransfer < 15_000_00)
    else lastTransfers + currentTransfer < 600_000_00 && currentTransfer < 150_000_00

fun main() {
    println("Выберите тип платежной системы")
    val card = readln()
    println("Введите сумму операций за текущий месяц")
    val lastTransfers = readln().toInt() * 100
    println("Введите сумму перевода")
    val currentTransfer = readln().toInt() * 100
    if (isInLimit(card, lastTransfers, currentTransfer)) {
        println(
            "Размер комиссии : ${
                countTax(card, lastTransfers, currentTransfer)?.div(100)
                    ?: "перевод средств невозможен"
            } "
        )
    } else {
        println("Невозможно произвести операцию.")
    }
}
