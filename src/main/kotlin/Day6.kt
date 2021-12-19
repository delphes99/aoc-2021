fun main() {
    println("part 1 :")
    println(Day6Part1.calculationPopulationSizeAt(readLinesOf("day6.txt").first(), 80))

    println("part 2 :")
    println(Day6Part2.calculationPopulationSizeAt(readLinesOf("day6.txt").first(), 256))
}

class Day6Part1 {
    companion object {
        fun calculationPopulationSizeAt(initialPopulationStr: String, generation: Int): Int {
            val initialPopulation = initialPopulationStr.split(",").map(String::toInt)
            return calculateGenerations(initialPopulation, generation).last().size
        }

        fun calculateGenerations(initialPopulationStr: Population, numberOfGeneration: Int): List<Population> {
            val generations = mutableListOf(initialPopulationStr)
            for (i in 1..numberOfGeneration) {
                generations.add(generation(generations.last()))
            }
            return generations.drop(1)
        }

        fun generation(population: Population): Population {
            var newBirth = 0
            return population.map { age ->
                (age - 1).takeIf { it >= 0 } ?: (6.also { newBirth++ })
            }.plus((0 until newBirth).map { 8 })
        }
    }
}

class Day6Part2 {
    companion object {
        fun calculationPopulationSizeAt(initialPopulationStr: String, generation: Int): Long {
            val initialPopulation = initialPopulationStr.split(",").map(String::toInt).groupBy { it }
                .mapValues { (_, population) -> population.size.toLong() }
            return calculateGenerations(initialPopulation, generation).last().values.sum()
        }

        fun calculateGenerations(
            initialPopulationStr: Population2,
            numberOfGeneration: Int
        ): List<Population2> {
            val generations = mutableListOf(initialPopulationStr)
            for (i in 1..numberOfGeneration) {
                generations.add(generation(generations.last()))
            }
            return generations.drop(1)
        }

        fun generation(population: Population2): Population2 {
            val fishGivingBirth = population[0] ?: 0

            val oldFish = population.map { (age, numberOfFish) ->
                if (age == 0) {
                    6
                } else {
                    age - 1
                } to numberOfFish
            }


            return if (fishGivingBirth > 0) {
                oldFish.plus(8 to fishGivingBirth)
            } else {
                oldFish
            }
                .groupBy { (age, _) -> age }
                .mapValues { (_, populations) -> populations.map(Pair<Int, Long>::second).sum() }
        }
    }
}

typealias FishAge = Int
typealias Population = List<FishAge>
typealias Population2 = Map<FishAge, Long>