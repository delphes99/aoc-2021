import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class Day6 {
    @Test
    internal fun part1() {
        Day6Part1.calculationPopulationSizeAt("3,4,3,1,2", 80) shouldBe 5934
    }

    @Test
    internal fun `calculate generations`() {
        val lines = readLinesOf("day6_example_result.txt")

        Day6Part1.calculateGenerations(listOf(3, 4, 3, 1, 2), 18) shouldBe lines
            .map {
                it.split(",").map(String::toInt)
            }
    }

    @Test
    internal fun `population without birth`() {
        Day6Part1.generation(listOf(3, 4, 3, 1, 2)).shouldContainExactly(2, 3, 2, 0, 1)
    }

    @Test
    internal fun `population with birth`() {
        Day6Part1.generation(listOf(2, 3, 2, 0, 1)).shouldContainExactly(1, 2, 1, 6, 0, 8)
    }
}