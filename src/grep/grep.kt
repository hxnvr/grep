package grep

import java.io.File

class grep(line: String){
    var v = false // инвертирует условие фильтрации
    var i = false // игнорировать регистр слов
    var r = false // вместо слова задаёт регулярное выражение для поиска
    private val lineSplit = line.split(" ")
    private val indexOfWord = lineSplit.lastIndex - 1
    private val indexOfFile = lineSplit.lastIndex
    private val word = lineSplit[indexOfWord]
    private val file = lineSplit[indexOfFile]

    private fun flugs(){
        if (lineSplit.contains("-i")) i = true
        if (lineSplit.contains("-v")) v = true
        if (lineSplit.contains("-r")) r = true
    }

    private fun wordGrep(lines: List<String>): List<String> {
        val res = listOf<String>()
        for (line in lines) {
            var newWord = word
            var newLine = line
            if (i) {
                newWord = word.toLowerCase()
                newLine = line.toLowerCase()
            }
            if (!v) {
                if (newLine.contains(newWord)) res.plus(line)
            } else if (!newLine.contains(newWord)) res.plus(line)
        }
        return res
    }

    private fun regexGrep(lines: List<String>): List<String> {
        val res = listOf<String>()
        for (line in lines) {
            var newWord = word
            var newLine = line
            if (i) {
                newWord = word.toLowerCase()
                newLine = line.toLowerCase()
            }
            if (!v) {
                if (Regex(newWord).matches(newLine.split(" ")[indexOfWord])) res.plus(line)
            } else if (!Regex(newWord).matches(newLine.split(" ")[indexOfWord])) res.plus(line)
        }
        return res
    }

    fun grepGrep(): List<String> {
        flugs()
        val lines = File(file).readLines()
        return if (r) regexGrep(lines) else wordGrep(lines)
    }

}