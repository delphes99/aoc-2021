import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class Day7 {
    @Test
    internal fun part1() {
        Day7Part1.calculate("16,1,2,0,4,2,7,1,2,14") shouldBe 37
    }

    @Test
    internal fun `horizontal position`() {
        Day7Part1.calculateHorizontalPosition(listOf(16, 1, 2, 0, 4, 2, 7, 1, 2, 14)) shouldBe 2
    }
}