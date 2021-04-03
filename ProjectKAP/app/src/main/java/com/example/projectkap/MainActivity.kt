package com.example.projectkap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    var nama = "Budi"
//    var umur = 20

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Toast.makeText(this, "nama saya $nama usia saya $umur tahun", Toast.LENGTH_LONG).show()

        tombol.setOnClickListener(){
            val jumlah = edit_jumlah.text

            if (jumlah.isNullOrBlank()){
                edit_jumlah.error = "jumlah tidak boleh kosong"
                edit_jumlah.requestFocus()
            } else {
                tmapilkanJumlah(jumlah.toString().toInt())
            }
        }
    }

    fun tmapilkanJumlah(jumlah: Int) {
        val total = jumlah
        tampilkan.text = total.toString()
    }
}
