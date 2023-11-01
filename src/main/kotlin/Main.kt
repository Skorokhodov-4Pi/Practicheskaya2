/*
val sec = 3601
val min = sec / 60
val hours = min / 60

fun main(args: Array<String>) {
    println(agoToText(sec))
}
fun agoToText(sec: Int) = when {
    sec > 86400 && sec < 172800 -> "был(а) вчера"
    sec > 172800 && sec < 259200 -> "был(а) позавчера"
    sec > 259200 -> "был(а) давно"
    sec < 3600 -> "был(а) в сети $min минут${min_tm(min)} назад"
    sec > 3600 && sec < 86400 -> "был(а) в сети $hours часов${hour_tm(hours)} назад"
    else -> ""
}
fun min_tm (min: Int) = when{
    min % 10 == 1 -> "у"
    min % 10 in 2..4 && min % 100 !in 12..14 -> "ы"
    else -> ""
}
fun hour_tm (hours: Int) = when{
    hours == 1 || hours % 100 == 21 -> ""
    hours in 2..4 || hours % 100 > 21 -> "а"
    else -> "ов"
}
 */

val type_card = readln()
val sum_mounth = 74000 //сумма за месяц
val sum = 160000 //сумма за раз
var com_MM = (0.6/100)*sum_mounth
var end_1 = sum_mounth + com_MM
var com_VM = (0.75/100)* sum
var end_2 = sum + com_VM

fun main(args: Array<String>) {
    println(commission(type_card))
}
fun commission (type_card: String) = when {
    sum > 150000 && type_card == "Visa" || type_card == "Мир" -> "Превысили лимит!"
    sum_mounth > 600000 && type_card == "Maestro" || type_card == "MasterCard" -> "Превысили лимит!"
    sum_mounth > 40000 && sum > 15000 && type_card == "VK Pay" -> "Превысили лимит!"
    type_card == "Maestro" || type_card == "MasterCard" && sum_mounth < 75000 -> "Сумма: $sum_mounth"
    type_card == "Maestro" || type_card == "MasterCard" && sum_mounth > 75000 -> "Сумма: ${end_1 + 20}"
    type_card == "Visa" || type_card == "Мир"  && com_VM < 35 -> "Сумма: ${sum + 35}"
    type_card == "Visa" || type_card == "Мир" && com_VM > 35 -> "Сумма: $end_2"
    type_card == "VK Pay" -> "Сумма: $sum"
    else -> "-"
}