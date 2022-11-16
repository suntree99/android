package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var garutIsShowing = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun garutOnClick(view: View) {
        Log.i("info", "garut telah di klik")

        var garut = garutImageView
        var nanas = nanasImageView

        if(garutIsShowing) {
            garut.animate().alpha(0f).setDuration(2000)
            nanas.animate().alpha(1f).setDuration(2000)
            garutIsShowing = false
        } else {
            garut.animate().alpha(1f).setDuration(2000)
            nanas.animate().alpha(0f).setDuration(2000)
            garutIsShowing = true
        }
    }
}

