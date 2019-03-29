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
    private val inputFile = lineSplit[indexOfFile]

    private fun wordGrep(lines: List<String>): List<String> {
        val res = mutableListOf<String>()
        for (line in lines) {
            var newWord = word
            var newLine = line
            if (i) {
                newWord = word.toLowerCase()
                newLine = line.toLowerCase()
            }
            if (!v) {
                if (newLine.contains(newWord)) res.add(line)
            } else if (!newLine.contains(newWord)) res.add(line)
        }
        return res
    }

    private fun regexGrep(lines: List<String>): List<String> {
        val res = mutableListOf<String>()
        for (line in lines) {
            var newWord = word
            var newLine = line
            if (i) {
                newWord = word.toLowerCase()
                newLine = line.toLowerCase()
            }
            if (!v) {
                if (newLine.contains(Regex(newWord))) res.add(line)
            } else if (!Regex(newWord).matches(newLine.split(" ")[indexOfWord])) res.add(line)
        }
        return res
    }

    fun grepGrep(): List<String> {
        if (lineSplit.contains("-i")) i = true
        if (lineSplit.contains("-v")) v = true
        if (lineSplit.contains("-r")) r = true
        val lines = File(inputFile).readLines()
        return if (r) regexGrep(lines) else wordGrep(lines)
    }

}