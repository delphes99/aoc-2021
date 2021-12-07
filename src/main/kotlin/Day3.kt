fun main() {
    println("part 1 :")
    println(Day3Part1.calculate(readLinesOf("day3.txt")))

    println("part 2 :")
    println(Day3Part2.calculate(readLinesOf("day3.txt")))
}

class Day3Part1 {
    companion object {
        fun calculate(lines: List<String>): Int {
            return calculateEpsilon(lines) * calculateGamma(lines)
        }

        fun calculateEpsilon(lines: List<String>): Int {
            return numberOfEachByteByColumn(lines)
                .map { if (it.numberOf0 < it.numberOf1) 0 else 1 }
                .joinToString("").toInt(2)
        }

        fun calculateGamma(lines: List<String>): Int {
            return numberOfEachByteByColumn(lines)
                .map { if (it.numberOf0 > it.numberOf1) 0 else 1 }
                .joinToString("").toInt(2)
        }

        private fun numberOfEachByteByColumn(lines: List<String>) = lines.flatMap { line ->
            line.toCharArray().mapIndexed { index, char ->
                Pair(
                    index, when (char) {
                        '0' -> 0
                        '1' -> 1
                        else -> error("bad input char")
                    }
                )
            }
        }.fold(Result()) { acc, columnValue ->
            acc.add(columnValue.second, columnValue.first)
        }.columns
            .toSortedMap()
            .values
    }

    data class Result(
        val columns: MutableMap<ColumnIndex, Column> = mutableMapOf()
    ) {
        fun add(value: Int, column: ColumnIndex): Result {
            columns.getOrPut(column) {
                Column()
            }.apply {
                if (value == 0) {
                    numberOf0++
                } else {
                    numberOf1++
                }
            }
            return this
        }
    }

    data class Column(
        var numberOf0: Int = 0,
        var numberOf1: Int = 0
    )
}

class Day3Part2 {
    companion object {
        fun calculate(lines: List<String>): Int {
            return oxygenGeneratorRating(lines) * co2ScrubberRating(lines)
        }

        private fun numberOfEachByteByColumn(lines: List<String>): List<Column> = lines.flatMap { line ->
            line.toCharArray().mapIndexed { index, char ->
                Pair(
                    index, when (char) {
                        '0' -> 0
                        '1' -> 1
                        else -> error("bad input char")
                    }
                )
            }
        }.fold(Result()) { acc, columnValue ->
            acc.add(columnValue.second, columnValue.first)
        }.columns
            .toSortedMap()
            .values.toList()

        fun oxygenGeneratorRating(lines: List<String>): Int {
            return findHiddenRating(lines) {
                it.mostCommonBit
            }
        }

        fun co2ScrubberRating(lines: List<String>): Int {
            return findHiddenRating(lines) {
                it.leastCommonBit
            }
        }

        private fun findHiddenRating(lines: List<String>, bitCriteriaOf: (Column) -> Int): Int {
            var survivingNumbers = lines
            var cpt = 0
            while (survivingNumbers.size > 1) {
                val bitCriteria = bitCriteriaOf(numberOfEachByteByColumn(survivingNumbers)[cpt])
                survivingNumbers = survivingNumbers.filter { it.substring(cpt, cpt + 1) == bitCriteria.toString() }
                cpt++
            }

            return survivingNumbers[0].toInt(2)
        }
    }

    data class Result(
        val columns: MutableMap<ColumnIndex, Column> = mutableMapOf()
    ) {
        fun add(value: Int, column: ColumnIndex): Result {
            columns.getOrPut(column) {
                Column()
            }.apply {
                if (value == 0) {
                    numberOf0++
                } else {
                    numberOf1++
                }
            }
            return this
        }
    }

    data class Column(
        var numberOf0: Int = 0,
        var numberOf1: Int = 0
    ) {
        val mostCommonBit get() = if (numberOf0 > numberOf1) 0 else 1
        val leastCommonBit get() = if (numberOf0 <= numberOf1) 0 else 1
    }
}

private typealias ColumnIndex = Int
