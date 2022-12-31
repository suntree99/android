package com.darma1budi.skyobject

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.MediaController
import android.widget.VideoView
import androidx.annotation.RequiresApi

class SplashScreen : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val vvSplash: VideoView = findViewById(R.id.vv_splash)
        val filePlace = "android.resource://$packageName/raw/${R.raw.splash_video}"

        vvSplash.setVideoURI(Uri.parse(filePlace))
        vvSplash.setMediaController(MediaController( this))
        vvSplash.setOnPreparedListener { mp -> mp.playbackParams = mp.playbackParams.setSpeed(8F);}
        vvSplash.start()

        Handler().postDelayed(Runnable { // Setelah splash video selesai maka akan langsung berpindah ke Main activity
            val main = Intent(this@SplashScreen, MainActivity::class.java)
            startActivity(main)
            finish()
        }, 4100)
    }
}