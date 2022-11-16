package id.kotlin.belajar

import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.btn_click)
        button.setOnClickListener { Toast.makeText( this, "Hallo", Toast.LENGTH_SHORT).show() }

        val rootLayout = findViewById<LinearLayout>(R.id.root_layout)
        val buttonSnack = findViewById<Button>(R.id.btn_click_snack)
        buttonSnack.setOnClickListener { Snackbar.make(rootLayout, "Hallo Snack", Snackbar.LENGTH_SHORT).show() }

        supportFragmentManager.beginTransaction().replace(R.id.fl_main, MainFragment()).commit()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}