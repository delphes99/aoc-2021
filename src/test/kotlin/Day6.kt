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

    @Test
    internal fun part2() {
        Day6Part2.calculationPopulationSizeAt("3,4,3,1,2", 256) shouldBe 26984457539
    }

    @Test
    internal fun `population with birth (pt2)`() {
        Day6Part2.generation(
            mapOf(
                2 to 2L,
                3 to 1L,
                0 to 1L,
                1 to 1L
            )
        ).entries.map { it.toPair() }.shouldContainExactly(
            1 to 2L,
            2 to 1L,
            6 to 1L,
            0 to 1L,
            8 to 1L
        )
    }

    @Test
    internal fun `population with merge (pt2)`() {
        Day6Part2.generation(
            mapOf(
                2 to 2L,
                3 to 1L,
                0 to 1L,
                1 to 1L,
                7 to 3L
            )
        ).entries.map { it.toPair() }.shouldContainExactly(
            1 to 2L,
            2 to 1L,
            6 to 4L,
            0 to 1L,
            8 to 1L
        )
    }

    @Test
    internal fun `calculate generations bis`() {
        val lines = readLinesOf("day6_example_result.txt")

        Day6Part2.calculateGenerations(
            mapOf(
                3 to 2L,
                4 to 1L,
                1 to 1L,
                2 to 1L
            ), 18
        ).forEachIndexed { index, generation ->
            println(index)
            generation.shouldBe(
                lines[index]
                    .split(",")
                    .map(String::toInt)
                    .groupBy { it }
                    .mapValues { (_, fishes) -> fishes.size.toLong() }
            )
        }
    }

    @Test
    internal fun `calculate generations (pt2)`() {
        Day6Part2.calculateGenerations(
            mapOf(
                3 to 2L,
                4 to 1L,
                1 to 1L,
                2 to 1L
            ), 18
        ).last() shouldBe mapOf(
            0 to 3L,
            1 to 5L,
            2 to 3L,
            3 to 2L,
            4 to 2L,
            5 to 1L,
            6 to 5L,
            7 to 1L,
            8 to 4L
        )
    }
}