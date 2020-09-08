fun main() {
    val seconds = 3200
    var text = ""
    var minutes = seconds / 60
    val lastCharacterOfMinutes = minutes % 10
    var hours = minutes / 60
    val lastCharacter = hours % 10
    val myLong = Long.MAX_VALUE
    when (seconds) {
        in 0..60 -> text = "Был(а) в сети только что"
        in 61..3600 -> when (lastCharacterOfMinutes) {
            1 -> if (minutes != 11) text = "Был(а) в сети $minutes минуту назад" else text =
                "Был(а) в сети $minutes минут назад"
            in 2..4 -> text = "Был(а) в сети $minutes минуты назад"
            in 5..9 -> text = "Был(а) в сети $minutes минут назад"
            0 -> text = "Был(а) в сети $minutes минут назад"
        }
        in 3601..86400 -> when (lastCharacter) {
            0 -> text = "Был(а) в сети $hours часов назад"
            1 -> text = "Был(а) в сети $hours час назад"
            in 2..4 -> text = "Был(а) в сети $hours часа назад"
            in 5..9 -> text = "Был(а) в сети $hours часов назад"
        }
        in 86401..172800 -> text = "Был(а) в сети сегодня"
        in 172801..259200 -> text = "Был(а) в сети вчера"
        in 259201..myLong -> text = "Был(а) в сети давно"
    }
    println(text)


    val TYPE_MASTERCARD_OR_MAESTRO = "Mastercard or Maestro"
    val TYPE_VISA_OR_MIR = "Visa or Mir"
    val TYPE_DEFAULT = "VK Pay"
    val typeOfCard = TYPE_DEFAULT
    val pastPaymentsOfMonth = 5000
    val payments = 10000
    var commission = 0
    var paymentsWithPast = payments + pastPaymentsOfMonth

    when (typeOfCard) {
        TYPE_MASTERCARD_OR_MAESTRO -> if (paymentsWithPast < 75000) commission = 0 else commission =
            (payments / 100 * 0.6 + 20).toInt()

        TYPE_VISA_OR_MIR -> commission = (payments / 100 * 0.75).toInt()

        TYPE_DEFAULT -> commission = 0
    }

    when (typeOfCard) {
        TYPE_MASTERCARD_OR_MAESTRO -> if (payments > 150_000 || paymentsWithPast > 600_000) {
            println("Превышен лимит. Перевод невозможен.")
        } else {
            var result = payments - commission
            println("Отправлено: $payments . Получено: $result .")
        }

        TYPE_VISA_OR_MIR -> if (payments > 150_000 || paymentsWithPast > 600_000) {
            println("Превышен лимит. Перевод невозможен.")
        } else {
            if(commission > 35) commission else commission =35
            var result = payments - commission
            println("Отправлено: $payments . Получено: $result .")
        }

        TYPE_DEFAULT -> if(payments > 15000 || paymentsWithPast > 40000){
            println("Превышен лимит. Перевод невозможен.")
        } else {
            var result = payments - commission
            println("Отправлено: $payments . Получено: $result .")
        }

    }

}