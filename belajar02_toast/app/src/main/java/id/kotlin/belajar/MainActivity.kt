package id.kotlin.belajar

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.btn_click)
        button.setOnClickListener { Toast.makeText( this, "Hello Toast", Toast.LENGTH_SHORT).show() }

    }
}