fun main() {
    println("part 1 :")
    println(Day6Part1.calculationPopulationSizeAt(readLinesOf("day6.txt").first(), 80))
}

class Day6Part1 {
    companion object {
        fun calculationPopulationSizeAt(initialPopulationStr: String, generation: Int) : Int {
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

typealias FishAge = Int
typealias Population = List<FishAge>