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
            garut.animate().rotation(360f).scaleX(0.5f).scaleY(0.5f).alpha(1f).setDuration(2000)
            garutIsShowing = false
        } else {
            garut.animate().rotation(-360f).scaleX(1f).scaleY(1f).alpha(0f).setDuration(2000)
            garutIsShowing = true
        }
    }
}

