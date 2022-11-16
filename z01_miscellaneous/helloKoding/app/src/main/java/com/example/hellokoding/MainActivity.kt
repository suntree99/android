package com.example.hellokoding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val button = findViewById(R.id.btn1) as Button
//        val button : Button = findViewById(R.id.btn1)

//        button.setOnClickListener {
//            Toast.makeText(this@MainActivity, "Tombol berhasil diklik", Toast.LENGTH_SHORT).show()

        btn1.setOnClickListener {

            val name = asupanText.text.toString()
            tampilanText.setText(name)

            if (name.trim() == "")
                Toast.makeText(this@MainActivity, "Jenis dodol tidak boleh kosong", Toast.LENGTH_SHORT).show()
            else {
                tampilanText.setText(name)

                //Change Image
                val imgRes = resources.getIdentifier(name, "drawable", packageName)
                img1.setImageResource(imgRes)
            }
        }
    }
}
