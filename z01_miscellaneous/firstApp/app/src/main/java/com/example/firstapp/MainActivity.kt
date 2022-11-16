package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.MediaController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var garutIsShowing = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var contoller = MediaController(this)
        var video = pemutarVideo
        contoller.setAnchorView(video)
        video.setMediaController(contoller)
        video.setVideoPath("android.resource://"+ packageName +"/"+ R.raw.aqua)
        video.start()
    }
}

