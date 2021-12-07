fun main() {
    println("part 1 :")
    println(day2part1(readLinesOf("day2.txt")))
}

fun day2part1(lines: List<String>): Int {
    return lines
        .map(Order.Companion::parse)
        .fold(SubmarinePosition()) { currentPosition, order ->
            when(order.type) {
                OrderType.forward -> currentPosition.addPosition(order.value)
                OrderType.down -> currentPosition.increaseDepth(order.value)
                OrderType.up -> currentPosition.decreaseDepth(order.value)
            }
        }.let {
            it.depth * it.position
        }
}

data class SubmarinePosition(
    val position: Int = 0,
    val depth: Int = 0
) {
    fun addPosition(value: Int): SubmarinePosition {
        return this.copy(position = position + value)
    }

    fun increaseDepth(value: Int): SubmarinePosition {
        return this.copy(depth = depth + value)
    }

    fun decreaseDepth(value: Int): SubmarinePosition {
        return this.copy(depth = depth - value)
    }
}

data class Order(
    val type: OrderType,
    val value: Int
) {
    companion object {
        fun parse(str: String): Order {
            val (order, value) = str.split(" ")
            return Order(OrderType.valueOf(order), value.toInt())
        }
    }
}

enum class OrderType {
    forward,
    down,
    up,
}