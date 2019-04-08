package grep
import java.io.File
import com.xenomachina.argparser.ArgParser

class Grep(parser: ArgParser) {
    private val v by parser.flagging("-v", help = "флаг инверсии")
    private val i by parser.flagging("-i", help = "флаг игнорирования регистра слов")
    private val r by parser.flagging("-r", help = "флаг регулярного выражения")
    private val word by parser.positional("слово, по которому нужно искать")
    private val file by parser.positional( "файл для поиска")

    fun findStrings(): List<String> {
        val lines = File(file).readLines()
        val result = mutableListOf<String>()
        for (line in lines) {
            var newWord = word
            var newLine = line
            if (i) {
                newWord = newWord.toLowerCase()
                newLine = line.toLowerCase()
            }
            if (!r) {
                if (!v) {
                    if (newLine.contains(newWord)) result.add(line)
                } else if (!newLine.contains(newWord)) result.add(line)
            } else {
                if (!v) {
                    if (newLine.contains(Regex(newWord))) result.add(line)
                } else if (!newLine.contains(Regex(newWord))) result.add(line)
            }
        }
        return result
    }

    fun write() {
        val list = findStrings()
        println("Cтроки :")
        for (line in list){
            println(line)
        }
    }
}