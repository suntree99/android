// Konversi Tipe Data

fun main() {

    val angka1 : Int = 10
    println(angka1)
    println(angka1.toString())
    println(angka1.toFloat())
    println(angka1.toDouble())

    val angka2 : Float = 20f
    var angka3 : Int = 30

    angka3 = angka2.toInt() // konversi berlaku untuk nilai, tidak berlaku untuk konversi variabel
    println(angka3)

}