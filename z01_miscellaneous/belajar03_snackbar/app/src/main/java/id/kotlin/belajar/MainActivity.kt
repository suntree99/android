package id.kotlin.belajar

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.btn_click)
        button.setOnClickListener { Toast.makeText( this, "Hello Toast", Toast.LENGTH_SHORT).show() }

        val rootLayout = findViewById<LinearLayout>(R.id.root_layout)
        val buttonSnack = findViewById<Button>(R.id.btn_click_snack)
        buttonSnack.setOnClickListener { Snackbar.make(rootLayout, "Hello Snack", Snackbar.LENGTH_SHORT).show() }
    }
}