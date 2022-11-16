package ClassAndObject

open class hewan () {

    // deklarasi variabel
    var jenis : String? = null
    var warna : String? = null
    var kaki : Int? = null

    // membuat constructor
    constructor(jenis : String, warna : String, kaki : Int) : this() {
        this.jenis = jenis
        this.warna = warna
        this.kaki = kaki

    // hanya print object saja
        println("Object : " + this.jenis)
        println("Object : " + this.warna)
        println("Object : " + this.kaki)
    }
}

class kucing() : hewan(){

}

fun main() {
    var hewan1 = hewan("ayam", "orange", 2)
    var kucing1 = kucing()
    kucing1.kaki = 4
    print("${kucing1.kaki}")
}