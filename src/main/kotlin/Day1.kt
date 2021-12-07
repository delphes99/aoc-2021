fun main() {
    println("part 1 :")
    println(day1part1(readLinesOf("day1.txt")))

    println("part 2 :")
    println(day1part2(readLinesOf("day1.txt")))
}

fun day1part1(lines: List<String>): Int {
    return lines
        .map(String::toInt)
        .windowed(2, 1, false)
        .count { it[0] < it[1] }
}

fun day1part2(lines: List<String>): Int {
    return lines
        .asSequence()
        .map(String::toInt)
        .windowed(3, 1, false)
        .map { it.sum() }
        .windowed(2, 1, false)
        .count { it[0] < it[1] }
}