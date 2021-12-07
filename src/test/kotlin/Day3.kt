import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day3 {
    @Test
    internal fun part1_epsilon() {
        val lines = readLinesOf("day3_example.txt")

        Day3Part1.calculateEpsilon(lines) shouldBe 9
    }

    @Test
    internal fun part1_gamma() {
        val lines = readLinesOf("day3_example.txt")

        Day3Part1.calculateGamma(lines) shouldBe 22
    }

    @Test
    internal fun part1() {
        val lines = readLinesOf("day3_example.txt")

        Day3Part1.calculate(lines) shouldBe 198
    }

    @Test
    internal fun part2_oxygen_generator_rating() {
        val lines = readLinesOf("day3_example.txt")

        Day3Part2.oxygenGeneratorRating(lines) shouldBe 23
    }

    @Test
    internal fun part2_co2_scrubber_rating() {
        val lines = readLinesOf("day3_example.txt")

        Day3Part2.co2ScrubberRating(lines) shouldBe 10
    }

    @Test
    internal fun part2() {
        val lines = readLinesOf("day3_example.txt")

        Day3Part2.calculate(lines) shouldBe 230
    }
}