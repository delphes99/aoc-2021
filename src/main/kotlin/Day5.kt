import java.lang.Integer.min
import java.lang.Integer.max

fun main() {
    println("part 1 :")
    println(Day5Part1.calculate(readLinesOf("day5.txt")))
}

class Day5Part1 {
    companion object {
        fun toPoints(lines: List<String>): List<Point> {
            return lines.flatMap { line ->
                val (origin, destination) = line.split(" -> ")
                    .map { it.split(",") }
                    .map { it.map(String::toInt) }
                    .map { Point(it[0], it[1]) }

                if(origin.x == destination.x) {
                    (min(origin.y, destination.y) .. max(origin.y, destination.y)).map { Point(origin.x, it) }
                } else if(origin.y == destination.y) {
                    (min(origin.x, destination.x) .. max(origin.x, destination.x)).map { Point(it, origin.y) }
                } else {
                    emptyList()
                }
            }
        }

        fun calculate(lines: List<String>): Int {
            return toPoints(lines).groupBy { it }.filterValues { it.size > 1 }.keys.size
        }
    }

    data class Point(
        val x: Int,
        val y: Int,
    )
}