// Variable Scope

var nama : String? = null // variabel global yang berada di luar fungsi
// usia = 35 // variabel lokal tidak dapat dipangging di global

fun main() {
    var usia = 32 // variabel lokal yang berada di dalam fungsi
    myName() // memanggil fungsi myName
}

fun myName() {
    nama = "Budi Darmawan" // memanggil variabel global
    println(nama)
}
