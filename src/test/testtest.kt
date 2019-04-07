package test
import main2
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
class Testtest {
    @Test
    fun main() {
        assertEquals(listOf("sss"), main2(arrayOf("sss", "input/test.txt")))
        assertEquals(listOf("sss", "sSs"), main2(arrayOf("-i","sss", "input/test.txt")))
        assertEquals(listOf("авпв"), main2(arrayOf("-r", "[а-я]", "input/test.txt")))
        assertEquals(listOf("748jhh"), main2(arrayOf("-r", "\\d", "input/test.txt")))
    }

}  