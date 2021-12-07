import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day2 {
    @Test
    internal fun part1() {
        val lines = readLinesOf("day2_example.txt")

        day2part1(lines) shouldBe 150
    }
}