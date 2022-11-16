package com.example.block8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Menjalankan fungsi onCreate -> membuat tampilan

        setContentView(R.layout.activity_second); // Men-set isi tampilan dengan layout dari file xml (activity_second)

        Intent caller = getIntent(); // Membuat variabel (Intent) caller untuk mengambil intent yang di kirim
        float rating = caller.getFloatExtra("nbStars", 0); // Membuat variabel (float) dan mengisinya dengan nilai dari intent caller

        TextView textView = (TextView) findViewById(R.id.textView); // Membuat variabel (TextView) textview dan mengisinya dengan textView dari file xml
        textView.setText("Welcome to the second ivity! Your rating " + rating); // Men-set isi text dari textView dengan menyertakan nilai rating
    }
}
