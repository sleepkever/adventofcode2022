package nl.skipdegroot.advent2022.common

import kotlin.system.measureTimeMillis

abstract class Assignment(day: Int, exampleInput: String) {
    private val challengeData = FileDataSource("day$day.txt")
    private val exampleData = StringDataSource(exampleInput)

    abstract fun calculatePartOne(input: AssignmentDataSource, datatype: DataType): String
    abstract fun exampleAnswerPartOne(): String
    abstract fun calculatePartTwo(input: AssignmentDataSource, datatype: DataType): String
    abstract fun exampleAnswerPartTwo(): String

    fun execute() {
        val part1ExampleExpected = exampleAnswerPartOne()
        val part1ExampleResult = try {
            calculatePartOne(exampleData, DataType.EXAMPLE)
        } catch (e: Throwable) {
            e.printStackTrace()
            "Error"
        }

        val part1Answer: String
        val part1TimeInMillis = measureTimeMillis {
            part1Answer = try {
                calculatePartOne(challengeData, DataType.REAL)
            } catch (e: Throwable) {
                e.printStackTrace()
                "Error"
            }
        }
        println("Part 1 answer: $part1Answer")

        val part2ExampleExpected = exampleAnswerPartTwo()
        val part2ExampleResult = try {
            calculatePartTwo(exampleData, DataType.EXAMPLE)
        } catch (e: Throwable) {
            e.printStackTrace()
            "Error"
        }
        if (part2ExampleResult != part2ExampleExpected) {
            println("FAILED")
        }
        val part2Answer: String
        val part2TimeInMillis = measureTimeMillis {
            part2Answer = try {
                calculatePartTwo(challengeData, DataType.REAL)
            } catch (e: Throwable) {
                e.printStackTrace()
                "Error"
            }
        }
        val example1Correct = if (part1ExampleExpected != part1ExampleResult) "INCORRECT" else "Correct"
        val example2Correct = if (part2ExampleExpected != part2ExampleResult) "INCORRECT" else "Correct"

        println("Part 2 answer: $part2Answer")
        println("------------------------------Part 1------------------------------")
        println("Example expected:  $part1ExampleExpected")
        println("Example actual:    $part1ExampleResult $example1Correct")
        println("Calculated answer: $part1Answer")
        println("Runtime:           $part1TimeInMillis ms")
        println("------------------------------Part 2------------------------------")
        println("Example expected:  $part2ExampleExpected")
        println("Example actual:    $part2ExampleResult $example2Correct")
        println("Calculated answer: $part2Answer")
        println("Runtime:           $part2TimeInMillis ms")
        println("------------------------------------------------------------------")


    }
}

enum class DataType {
    EXAMPLE, REAL
}
