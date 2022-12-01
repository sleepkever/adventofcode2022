package nl.skipdegroot.advent2022.common

import java.io.File
import java.nio.charset.Charset


interface AssignmentDataSource {
    fun readText(): String
    fun readLines(): List<String>
}


class FileDataSource(private val filename: String) : AssignmentDataSource {

    override fun readLines(): List<String> =
        getFile().readLines(Charset.defaultCharset())

    override fun readText() =
        getFile().readText()

    private fun getFile() = File(this.javaClass.classLoader.getResource(filename).toURI())
}

class StringDataSource(private val input: String) : AssignmentDataSource {

    override fun readLines(): List<String> =
        input.split("\n")

    override fun readText() =
        input

}

