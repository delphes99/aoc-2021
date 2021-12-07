private object ReadFile

fun readLinesOf(file: String): List<String> {
    return ReadFile.javaClass.classLoader.getResourceAsStream(file).bufferedReader().use { it.readLines() }
}