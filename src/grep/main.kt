package grep

fun main(line: Array<String>) {
    val inputLine = readLine()!!.toString()
    val grepp = grep(inputLine)
    val strings = grepp.grepGrep()
    for (string in strings){
        println(string)
    }
}