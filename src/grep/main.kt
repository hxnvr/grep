package grep

fun main(line: Array<String>) {
    val grepp = grep("grep sss input/test.txt")
    val strings = grepp.grepGrep()
    for (string in strings){
        println(string)
    }
}