package com.example.block4;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    MediaPlayer kidSound; // Membuat variabel (MediaPlayer) kidSound

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Menjalankan fungsi onCreate -> membuat tampilan

        setContentView(R.layout.activity_main); // Men-set isi tampilan dengan layout dari file xml (activity_main)

        kidSound = MediaPlayer.create(this, R.raw.kid); // Mengisi kidSound dengan file sound kid

        Switch switch_looping = (Switch) findViewById(R.id.switch_looping); // Membuat variabel (Switch) switch_looping dan mengisinya dengan switch_looping dari file xml
        switch_looping.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) { // Jika switch_looping di set On
                kidSound.setLooping(isChecked); // Men-set looping pada kidSound
            }
        });
    }

    public void playSound (View v) {  // Fungsi onClick playSound dideklarasikan di file xml, Jika tombol start diklik
        kidSound.start(); // Menjalankan sound
    }

    public void pauseSound (View v) { // Fungsi onClick playSound dideklarasikan di file xml, Jika tombol pause diklik
        if(kidSound.isPlaying()) // Jika sound sedang berjalan
            kidSound.pause(); // Lakukan Pause sound
    }
}
