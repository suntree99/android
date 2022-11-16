package com.example.block8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Menjalankan fungsi onCreate -> membuat tam

        setContentView(R.layout.activity_first); // Men-set isi tampilan dengan layout dari file xml (activity_first)
    }

    public void enter(View v) { // Function (onClick) enter dideklarasikan di file xml

        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar); // Membuat variabel (RatingBar) ratingBar dan mengisinya dengan ratingBar dari file xml
        float rating = ratingBar.getRating(); // membuat variabel (float) rating dan mengisinya dengan nilai dari ratingBar

//        Toast.makeText(getApplicationContext(),rating +" stars", Toast.LENGTH_SHORT).show(); // Menampilkan pop-up (Toast) untuk pengetesan

        Intent goToSecond = new Intent(); // Membuat variabel (Intent) goToSecond dan menginisialisasi intent baru
        goToSecond.setClass(this, SecondActivity.class); // Men-set class SecondActivity (Java) pada goToSecond
        goToSecond.putExtra("nbStars", rating); // Menaruh key and value pada goToSecond untuk dikirim
        startActivity(goToSecond); // Menjalankan activity dari goToSecond
        finish(); // Mengakhiri activity jika menekan tombol back (menutup aplikasi)
    }
}
