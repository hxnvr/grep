package grep

fun main(line: Array<String>) {
    println("Введите запрос в формате 'grep [-i][-r][-v] слово файл' ")
    val inputLine = readLine()!!.toString()
    val testGrep = Grep(inputLine)
    val strings = testGrep.findStrings()
    println("Строки :")
    for (string in strings){
        println(string)
    }
}