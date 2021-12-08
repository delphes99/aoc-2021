fun main() {
    println("part 1 :")
    println(Day4Part1.calculate(readLinesOf("day4.txt")))
}

class Day4Part1 {
    companion object {
        fun calculate(entry: List<String>): Int {
            val sanitizeEntry = entry.filter(String::isNotEmpty)
            val numberToCall = sanitizeEntry[0].split(",").map(String::toInt).iterator()

            val boards = sanitizeEntry.subList(1, sanitizeEntry.size).windowed(5, 5, true).map(Board.Companion::of)

            val calledNumber = mutableListOf<Int>()
            while (boards.none { it.isWinning(calledNumber) }) {
                val element = numberToCall.next()
                calledNumber.add(element)
            }

            val winningBoards = boards.filter { it.isWinning(calledNumber) }

            return winningBoards.first().scoreFor(calledNumber)
        }
    }

    class Board(val columnOrLine: List<Row>) {
        fun isWinning(calledNumbers: List<Int>): Boolean = columnOrLine.any { calledNumbers.containsAll(it.numbers) }

        fun scoreFor(calledNumbers: List<Int>): Int {
            val numbersNotCalled = allNumbers.filterNot { calledNumbers.contains(it) }
            return calledNumbers.last() * numbersNotCalled.sum()
        }

        private val allNumbers = columnOrLine.flatMap { it.numbers }.distinct()

        companion object {
            fun of(entry: List<String>): Board {
                return Board(mapLine(entry) + mapColumn(entry))
            }

            private fun mapColumn(entry: List<String>): List<Row> {
                val intBoard = entry.toIntBoard()
                return (0..4).map { column ->
                    Row(intBoard.map { row -> row[column] })
                }
            }

            private fun mapLine(entry: List<String>) = entry.toIntBoard().map { Row(it) }

            private fun List<String>.toIntBoard() = map(String::trimIndent).filter(String::isNotEmpty).map {
                it.split(" ").filter(String::isNotEmpty).map(String::toInt)
            }
        }
    }

    data class Row(val numbers: List<Int>)
}