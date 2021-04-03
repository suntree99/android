package ClassAndObject

class Rumah (var tipe : String, val harga : Double, val tahun : Int, val pemilik : String) {

    init {
        this.tipe
        this.harga
        this.tahun
        this.pemilik
    }

    /**
     * setters dan getters adalah sebuah optional pada kotlin, tidak seperti java
     * membuat setter dan getters adalah bad programming pada kotlin
     * kotlin menginginkan kita untuk selalu menggunakan properies untuk menggunakan dan set class
    */

}

fun main() {
    val rumah = Rumah ("mewah", 2000000000.0, 2017, "Budi")

    // mencetak
    println("Rumah ${rumah.pemilik}, tahun pembangunan ${rumah.tahun}, dengan harga ${rumah.harga}, tipe ${rumah.tipe}")
}