package test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import com.xenomachina.argparser.ArgParser
import grep.main.Grep
import java.io.FileNotFoundException
import java.lang.IllegalArgumentException

fun mainTest(args: Array<String>): List<String> {
    return ArgParser(args).parseInto(::Grep).findStrings()
}

class Testtest {
    @Test
    fun main() {
        assertEquals(listOf("sss"), mainTest(arrayOf("sss", "input/test.txt")))
        assertEquals(listOf("sss", "sSs"), mainTest(arrayOf("-i", "sss", "input/test.txt")))
        assertEquals(listOf("авпв"), mainTest(arrayOf("-r", "[а-я]", "input/test.txt")))
        assertEquals(listOf("748jhh"), mainTest(arrayOf("-r", """\d""", "input/test.txt")))
        assertEquals(listOf("sss", "sSs", "ddddd ss", "748jhh", "авпв"), mainTest(arrayOf("-v", "gfdga", "input/test.txt")))
        assertEquals(listOf("gfdga", "ddddd ss", "748jhh", "авпв"), mainTest(arrayOf("-i", "-v", "sSs", "input/test.txt")))
        assertThrows(FileNotFoundException::class.java) { mainTest(arrayOf("sss", "gfd"))}
        assertThrows(IllegalArgumentException::class.java) { mainTest(arrayOf("sss", "input/test2"))}
    }

}  