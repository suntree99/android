package com.example.hellokoding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.activity_main.*
import com.example.hellokoding.databinding.ActivityMainBindingImpl

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBindingImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

//        val button : Button = findViewById(R.id.btn1)

        btn1.setOnClickListener {
//            Toast.makeText(this@MainActivity, "tombol berhasil diklik", Toast.LENGTH_SHORT).show()

            val name = nameText.text.toString()
            textBase.setText(name)

            if (name == null || name.trim() == "")
                Toast.makeText(this@MainActivity, "nama tidak boleh kosong", Toast.LENGTH_SHORT).show()
            else {
                textBase.setText(name)

                //change image
                val imgRes = resources.getIdentifier(name, "drawable", packageName)
                img1.setImageResource(imgRes)
            }
        }
    }
}
