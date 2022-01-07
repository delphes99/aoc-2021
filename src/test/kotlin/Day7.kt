import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class Day7 {
    @Test
    internal fun part1() {
        Day7Part1.calculate("16,1,2,0,4,2,7,1,2,14") shouldBe 37
    }

    @Test
    internal fun `horizontal position part1`() {
        Day7Part1.calculateHorizontalPosition(listOf(16, 1, 2, 0, 4, 2, 7, 1, 2, 14)) shouldBe 2
    }

    @Test
    internal fun part2() {
        Day7Part2.calculate("16,1,2,0,4,2,7,1,2,14") shouldBe 168
    }

    @Test
    internal fun `cost part2`() {
        Day7Part2.cost(5, listOf(16, 1, 2, 0, 4, 2, 7, 1, 2, 14)) shouldBe 168
    }

    @Test
    internal fun `horizontal position part2`() {
        Day7Part2.calculateHorizontalPosition(listOf(16, 1, 2, 0, 4, 2, 7, 1, 2, 14)) shouldBe 5
    }
}