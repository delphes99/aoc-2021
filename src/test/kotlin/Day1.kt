import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class Day1 {
    @Test
    internal fun part1() {
        val lines = readLinesOf("day1_example.txt")

        day1part1(lines) shouldBe 7
    }
    @Test
    internal fun part2() {
        val lines = readLinesOf("day1_example.txt")

        day1part2(lines) shouldBe 5
    }
}