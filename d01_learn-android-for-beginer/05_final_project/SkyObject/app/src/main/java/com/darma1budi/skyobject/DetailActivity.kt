package com.darma1budi.skyobject

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailActivity : AppCompatActivity(){
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvName: TextView = findViewById(R.id.tv_name)
        val tvDescription: TextView = findViewById(R.id.tv_description)
        val ivPlanet: ImageView = findViewById(R.id.iv_planet)
        val vvPlanet: VideoView = findViewById(R.id.vv_planet)
        val tvRadius: TextView = findViewById(R.id.tv_radius)
        val tvMass: TextView = findViewById(R.id.tv_mass)
        val tvArea: TextView = findViewById(R.id.tv_area)
        val tvGravity: TextView = findViewById(R.id.tv_gravity)
        val tvDistance: TextView = findViewById(R.id.tv_distance)
        val tvRotation: TextView = findViewById(R.id.tv_rotation)
        val tvMoon: TextView = findViewById(R.id.tv_moon)

        val btnActionShare: Button = findViewById(R.id.action_share)

        val name = intent.getStringExtra("EXTRA_NAME")
        val description = intent.getStringExtra("EXTRA_DESCRIPTION")
        val image = intent.getIntExtra("EXTRA_PICTURE",0)
        val video = intent.getIntExtra("EXTRA_VIDEO",0)
        val radius = intent.getDoubleExtra("EXTRA_RADIUS",0.0)
        val mass = intent.getDoubleExtra("EXTRA_MASS",0.0)
        val area = intent.getDoubleExtra("EXTRA_AREA",0.0)
        val gravity = intent.getDoubleExtra("EXTRA_GRAVITY",0.0)
        val distance = intent.getDoubleExtra("EXTRA_DISTANCE",0.0)
        val rotation = intent.getStringExtra("EXTRA_ROTATION")
        val moon = intent.getStringExtra("EXTRA_MOON")

        val filePlace = "android.resource://$packageName/raw/$video"

        tvName.text = name
        tvDescription.text = description

        Glide.with(ivPlanet)
            .load(image)
            .apply(RequestOptions().override(75, 75))
            .into(ivPlanet)

        vvPlanet.setVideoURI(Uri.parse(filePlace))
        vvPlanet.setMediaController(MediaController( this))
        vvPlanet.start()
        vvPlanet.setOnPreparedListener { mp -> mp.isLooping = true }

        tvRadius.text = "$radius km"
        tvMass.text = "$mass kg"
        tvArea.text = "$area km2"
        tvGravity.text = "$gravity m/s2"
        tvDistance.text = "$distance km"
        tvRotation.text = rotation
        tvMoon.text = moon

        btnActionShare.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT,
                    name!!.uppercase() + "\n\n" +
                            "Radius Rata-rata : " + radius + " km\n" +
                            "Massa : " + mass + " kg\n" +
                            "Area Permukaan : " + area + " km2\n" +
                            "Gravitasi : " + gravity + " m/s2\n" +
                            "Jarak dari Matarari : " + distance + " km\n" +
                            "Waktu Rotasi : " + rotation + "\n" +
                            "Bulan : " + moon
                )
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }

        supportActionBar?.title = "Detail $name"
    }

}
