fun main() {
    println("part 1 :")
    println(Day2Part1.calculate(readLinesOf("day2.txt")))
    println("part 2 :")
    println(Day2Part2.calculate(readLinesOf("day2.txt")))
}

class Day2Part1 {
    companion object {
        fun calculate(lines: List<String>): Int {
            return lines
                .map(Order.Companion::parse)
                .fold(SubmarinePosition()) { currentPosition, order ->
                    when (order.type) {
                        OrderType.forward -> currentPosition.addPosition(order.value)
                        OrderType.down -> currentPosition.increaseDepth(order.value)
                        OrderType.up -> currentPosition.decreaseDepth(order.value)
                    }
                }.let {
                    it.depth * it.position
                }
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
}

class Day2Part2 {
    companion object {
        fun calculate(lines: List<String>): Int {
            return lines
                .map(Order.Companion::parse)
                .fold(SubmarinePosition()) { currentPosition, order ->
                    currentPosition.execute(order)
                }.let {
                    it.depth * it.position
                }
        }
    }

    data class SubmarinePosition(
        val position: Int = 0,
        val depth: Int = 0,
        val aim: Int = 0
    ) {
        fun execute(order: Order): SubmarinePosition {
            val x = order.value

            return when (order.type) {
                OrderType.forward -> copy(position = position + x, depth = depth + aim * x)
                OrderType.down -> copy(aim = aim + x)
                OrderType.up -> copy(aim = aim - x)
            }
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
}