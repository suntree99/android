// Method
// Fungsi yang mengembalikan nilai (return)

fun main() {

    println(perkalian(3,4))
    langsung(5)
    println(nama())
    helloWorld()

}

// fungsi dengan parameter dan pengembalian nilai
fun perkalian (angka1 : Int, angka2 : Int): Int {
    val hasil = angka1 * angka2
    return hasil
}

// fungsi dengan parameter tanpa pengembalian nilai
fun langsung (angkaLangsung : Int) {
    println(angkaLangsung)
}

// fungsi tanpa parameter dengan pengambalian nilai
fun nama() : String {
    print("Tuliskan nama anda : ")
    val nama = readLine()
    return nama.toString()
}

// fungsi tanpa parameter dan tanpa pengembalian nilai
fun helloWorld() : Unit {
    println("Hai... Hello World")
}