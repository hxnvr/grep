package grep

fun main(line: Array<String>) {
    val inputLine = readLine()!!.toString()
    val testGrep = Grep(inputLine)
    val strings = testGrep.findStrings()
    for (string in strings){
        println(string)
    }
}