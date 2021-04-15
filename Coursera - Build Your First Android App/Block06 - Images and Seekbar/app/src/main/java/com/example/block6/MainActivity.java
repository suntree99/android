package com.example.block6;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Menjalankan fungsi onCreate -> membuat tampilan

        setContentView(R.layout.activity_main); // Men-set isi tampilan dengan layout dari file xml (activity_main)

        final ImageView imageView_large = (ImageView) findViewById(R.id.imageViewLarge); // Membuat variabel (ImageView) imageView_large dan mengisinya dengan imageViewLarge dari file xml
        imageView_large.setImageResource(R.drawable.rainbow); // Men-set gambar rainbow untuk mengisi imageView_large

        SeekBar tuner = (SeekBar) findViewById(R.id.seekBar_tuner); // Membuat variabel (SeekBar) tuner dan mengisinya dengan seekBar_tuner dari file xml

        tuner.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // Memberikan fungsi perubahan seekbar pada tuner

            int lastProgress; // Membuat variabel (int) lastProgress untuk menyimpan data terakhir

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { // Saat perubahan progress seekbar
                lastProgress = progress; // Mengisi lastProgress dengan progress terkini
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { // Saat mulai menekan dan menggeser tombol seekBar

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { // Saat berhenti dari tombol seekBar
                imageView_large.setColorFilter(Color.argb(255, 0, lastProgress, 255-lastProgress)); // Men-set warna imageView_large dengan konfigurasi warna
            }
        });
    }
}
