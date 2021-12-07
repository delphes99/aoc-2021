import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day2 {
    @Test
    internal fun part1() {
        val lines = readLinesOf("day2_example.txt")

        Day2Part1.calculate(lines) shouldBe 150
    }

    @Test
    internal fun part2() {
        val lines = readLinesOf("day2_example.txt")

        Day2Part2.calculate(lines) shouldBe 900
    }
}