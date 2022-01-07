import kotlin.math.absoluteValue

fun main() {
    println("part 1 :")
    println(Day7Part1.calculate(readLinesOf("day7.txt").first()))
}

class Day7Part1 {
    companion object {
        fun calculate(horizontalPositionsStr: String): Int {
            val horizontalPositions = horizontalPositionsStr.split(",").map { it.toInt() }

            val targetPosition = calculateHorizontalPosition(horizontalPositions)
            return cost(targetPosition, horizontalPositions)
        }

        fun calculateHorizontalPosition(horizontalPositions: List<Int>): Int {
            val allValues = horizontalPositions.distinct().sorted()

            val costsByPosition = allValues.associateWith { cost(it, horizontalPositions) }
            val minCost = costsByPosition.values.minOrNull()

            return costsByPosition.filterValues { it == minCost }.keys.first()
        }

        fun cost(target: Int, horizontalPositions: List<Int>): Int {
            return horizontalPositions.sumOf { (it - target).absoluteValue }
        }
    }
}
