import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day5 {
    @Test
    internal fun `convert input to points (part 1)`() {
        Day5Part1.toPoints(
            listOf(
                "1,1 -> 1,3",
                "9,7 -> 7,7",
                "8,0 -> 0,8",
            )
        ).shouldContainExactlyInAnyOrder(
            Day5Part1.Point(1, 1),
            Day5Part1.Point(1, 2),
            Day5Part1.Point(1, 3),
            Day5Part1.Point(9, 7),
            Day5Part1.Point(8, 7),
            Day5Part1.Point(7, 7),
        )
    }

    @Test
    internal fun part1() {
        Day5Part1.calculate(readLinesOf("day5_example.txt")) shouldBe 5
    }

    @Test
    internal fun `convert input to points (part 2)`() {
        Day5Part2.toPoints(
            listOf(
                "1,1 -> 1,3",
                "9,7 -> 7,7",
                "1,0 -> 4,3",
            )
        ).shouldContainExactlyInAnyOrder(
            Day5Part2.Point(1, 1),
            Day5Part2.Point(1, 2),
            Day5Part2.Point(1, 3),
            Day5Part2.Point(9, 7),
            Day5Part2.Point(8, 7),
            Day5Part2.Point(7, 7),
            Day5Part2.Point(1, 0),
            Day5Part2.Point(2, 1),
            Day5Part2.Point(3, 2),
            Day5Part2.Point(4, 3),
        )
    }

    @Test
    internal fun part2() {
        Day5Part2.calculate(readLinesOf("day5_example.txt")) shouldBe 12
    }
}