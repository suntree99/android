// Fungsi dan Parameter

fun main() {
    tambah(1,2)
    luasSegitiga(5,2)
}

fun tambah (angka1 : Int, angka2 : Int) {
    val sum = angka1 + angka2
    println("Jumlah = $sum")
}

fun luasSegitiga (alas : Int, tinggi : Int) {
    val hitungLuas = alas * tinggi / 2
    println("Luas Segitiga = $hitungLuas")
}