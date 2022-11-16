package IOKotlin

import java.io.FileReader
import java.io.FileWriter
import java.lang.Exception

fun main() {
    menu()
}

fun menu() {
    println("Enter :")
    println("1 - Write")
    println("2 - Read")
    println("3 - Exit \n")

    var choise: Int = readLine()!!.toInt()
    var message: String?

    when(choise) {
        1 -> {
            println("Enter message")
            message = readLine().toString()
            writeToFile(message)
        }

        2 -> {
            println("Reading...")
            readFromFile()
        }

        3 -> println("Exiting...")

    }

}

fun writeToFile(message: String) {
    try {
        val writer = FileWriter("appreader.txt", true)
        writer.write(message + "\n")
        writer.close()
    } catch (ex: Exception) {
        println("Exception $ex")
    }
}

fun readFromFile() {
    val reader = FileReader("appreader.txt")
    var char: Int?

    try {
        do {
            char = reader.read()
            print(char.toChar())
        } while (char != -1)
    } catch (ex: Exception) {
        print(ex.message)
    }
}