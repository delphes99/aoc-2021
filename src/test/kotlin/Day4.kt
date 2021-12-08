import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day4 {
    @Test
    internal fun board() {
        val lines = """
            14 21 17 24 4
            8  2  23 4  24        
            21 9  14 16 7        
            6  10 3  18 5        
            1  12 20 15 19        
        """.trimIndent().lines()

        Day4Part1.Board.of(lines).columnOrLine.shouldContainAll(
            Day4Part1.Row(listOf(14, 21, 17, 24, 4)),
            Day4Part1.Row(listOf(8, 2, 23, 4, 24)),
            Day4Part1.Row(listOf(21, 9, 14, 16, 7)),
            Day4Part1.Row(listOf(6, 10, 3, 18, 5)),
            Day4Part1.Row(listOf(1, 12, 20, 15, 19)),
            Day4Part1.Row(listOf(14, 8, 21, 6, 1)),
            Day4Part1.Row(listOf(21, 2, 9, 10, 12)),
            Day4Part1.Row(listOf(17, 23, 14, 3, 20)),
            Day4Part1.Row(listOf(24, 4, 16, 18, 15)),
            Day4Part1.Row(listOf(4, 24, 7, 5, 19)),
        )
    }

    @Test
    internal fun winning() {
        val lines = """
            14 21 17 24 4
            10 16 15 9  19
            18 8  23 26 20
            22 11 13 6  5
            2  0  12 3  7   
        """.trimIndent().lines()

        Day4Part1.Board.of(lines).isWinning(listOf(14, 21, 17, 24, 4)).shouldBeTrue()
    }

    @Test
    internal fun score() {
        val lines = """
            14 21 17 24 4
            10 16 15 9  19
            18 8  23 26 20
            22 11 13 6  5
            2  0  12 3  7
        """.trimIndent().lines()

        Day4Part1.Board.of(lines).scoreFor(listOf(7, 4, 9, 5, 11, 17, 23, 2, 0, 14, 21, 24)) shouldBe 4512
    }

    @Test
    internal fun part1() {
        val lines = readLinesOf("day4_example.txt")

        Day4Part1.calculate(lines)
    }
}