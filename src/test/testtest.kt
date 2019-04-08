package test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import com.xenomachina.argparser.ArgParser
import grep.Grep

fun mainTest(args: Array<String>): List<String> {
    return ArgParser(args).parseInto(::Grep).findStrings()
}

class Testtest {
    @Test
    fun main() {
        assertEquals(listOf("sss"), mainTest(arrayOf("sss", "input/test.txt")))
        assertEquals(listOf("sss", "sSs"), mainTest(arrayOf("-i","sss", "input/test.txt")))
        assertEquals(listOf("авпв"), mainTest(arrayOf("-r", "[а-я]", "input/test.txt")))
        assertEquals(listOf("748jhh"), mainTest(arrayOf("-r", """\d""", "input/test.txt")))
    }

}  