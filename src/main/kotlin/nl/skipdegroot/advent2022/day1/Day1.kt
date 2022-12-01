package nl.skipdegroot.advent2022.day1

import nl.skipdegroot.advent2022.common.Assignment
import nl.skipdegroot.advent2022.common.AssignmentDataSource
import nl.skipdegroot.advent2022.common.DataType

val example = """
1000
2000
3000

4000

5000
6000

7000
8000
9000

10000
""".trimIndent()

class Day1 : Assignment(1,  example){
    override fun calculatePartOne(input: AssignmentDataSource, datatype: DataType): String {
        val result = input.readText()
            .split("\n\n")
            .maxOfOrNull { it.split("\n").filter { it.isNotBlank() }.sumOf { it.toInt() } }
        return result.toString()
    }

    override fun exampleAnswerPartOne(): String {
        return "24000"
    }

    override fun calculatePartTwo(input: AssignmentDataSource, datatype: DataType): String {
        val result = input.readText()
            .split("\n\n")
            .map{ it.split("\n").filter { it.isNotBlank() }.sumOf { it.toInt() } }
            .sortedDescending()
            .take(3).sum()
        return result.toString()
    }

    override fun exampleAnswerPartTwo(): String {
        return "45000"
    }
}

fun main() {
    Day1().execute();
}
