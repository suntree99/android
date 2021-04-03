// Variabel
// Val : Imutable variable (variabel tetap atau konstanta)
// Var : Mutable variable (variabel yang dapat diubah nilainya)

fun main() {

    val myName = "Budi Darmawan" // nilai val tidak dapat diganti

    var myAge = 25
    myAge = 30 // nilai var dapat diganti

    println("my name is $myName and my age is $myAge") // pemanggilan variabel dalam string
    println("nama saya adalah "+myName+" dan umur saya adalah "+myAge) // pemanggilan variabel di luar string

}