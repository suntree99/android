// Operator Aritmatika

fun main() {

    val tujuh = 7
    val sepuluh = 10
    val dua = 2
    val lima = 5
    val delapan = 8

    println("10 tambah 7 = ${sepuluh + tujuh}")
    println("10 kurang 7 = ${sepuluh - tujuh}")
    println("10 kali 2 = ${sepuluh * dua}")
    println("10 bagi 2 = ${sepuluh / dua}")
    println("Sisa bagi 8 dengan 2 = ${delapan % dua}, maka 8 adalah genap")
    println("Sisa bagi 7 dengan 2 = ${tujuh % dua}, maka 7 adalah ganjil")
    println("Sisa bagi 2 dengan 10 = ${dua % sepuluh}")
    println()
    println("Jika 2 (Int) dibagi 5 (Int) maka hasilnya adalah ${dua / lima} (Int) - Dibulatkan ke bawah")
    println("Jika 2 (Float) dibagi 5 (Int) maka hasilnya adalah ${dua.toFloat() / lima} (Float)")

}