package ClassAndObject

open class kendaraan () {

    // set properties
    var nama: String? = null
    var roda: Int? = null
    var tenaga: String? = null
    var sayap: Int? = null
    var warna: String? = null

    // membuat constructor dengan 4 parameter
    constructor(nama: String, roda: Int, tenaga: String, sayap: Int, warna: String):this(){
        this.nama = nama
        this.roda = roda
        this.tenaga = tenaga
        this.sayap = sayap
        this.warna = warna

        println("Object : "+ this.nama)
        println("Object : "+ this.roda)
        println("Object : "+ this.tenaga)
        println("Object : "+ this.sayap)
        println("Object : "+ this.warna)
    }

    // membuat constructor dengan 4 parameter
    constructor(nama: String, roda:Int, tenaga: String, warna: String):this() {
        this.nama = nama
        this.roda = roda
        this.tenaga = tenaga
        this.warna = warna

        println("Object : "+ this.nama)
        println("Object : "+ this.roda)
        println("Object : "+ this.tenaga)
        println("Object : "+ this.warna)
    }

    // membuat constructor dengan 3 parameter
    constructor(nama: String, roda:Int, warna: String):this() {
        this.nama = nama
        this.roda = roda
        this.warna = warna

        println("Object : "+ this.nama)
        println("Object : "+ this.roda)
        println("Object : "+ this.warna)
    }

    // membuat constructor dengan 2 parameter
    constructor(nama:String, warna:String):this() {
        this.nama = nama
        this.warna = warna

        println("Object : "+ this.nama)
        println("Object : "+ this.warna)
    }
}

fun main() {
    var pesawat = kendaraan("pesawat", 6, "avtur", 2, "putih")
    var becak = kendaraan("becak", "hitam")
}