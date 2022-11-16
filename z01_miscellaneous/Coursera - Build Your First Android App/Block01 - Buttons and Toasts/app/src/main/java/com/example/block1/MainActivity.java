package com.example.block1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonBlue, buttonPink; // Membuat variabel (Button) buttonBlue dan buttonPink

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Menjalankan fungsi onCreate -> membuat tampilan

        setContentView(R.layout.activity_main); // Men-set isi tampilan dengan layout dari file xml (activity_main)

        buttonBlue = (Button) findViewById(R.id.button_blueInvisible); // Mengisi buttonBlue dengan button_blueInvisible dari file xml
        buttonBlue.setOnClickListener(this); // Menerapkan fungsi jika tombol diklik

        buttonPink = new Button(getApplicationContext()); // Membuat Button tanpa melalui file xml, mengambil konteks aplikasi - tampilan saat ini (activity_main)
        buttonPink.setBackgroundColor(Color.parseColor("#FD9BF3")); // Men-set warna background menjadi pink
        buttonPink.setTextColor(Color.BLACK); // Men-set warna text menjadi hitam
        buttonPink.setText("The Pink Panther To Do List"); // Men-set isi text

        RelativeLayout rl_mainScreen = (RelativeLayout) findViewById(R.id.relativeLayout_mainScreen); // Membuat variabel (RelativeLayout) rl_mainScreen dan mengisinya dengan relativeLayout_mainScreen dari file xml
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams( // Membuat variabel (LayourParams) params untuk parameter rl_mainScreen
                RelativeLayout.LayoutParams.MATCH_PARENT, // Parameter 1
                RelativeLayout.LayoutParams.WRAP_CONTENT); // Parameter 2
        params.addRule(RelativeLayout.BELOW, buttonBlue.getId()); // Menambahkan rule terhadap params, mengambil lokasi di bawah dari buttonBlue dan mengambil id-nya
        rl_mainScreen.addView(buttonPink, params); // Menambahkan buttonPink pada rl_mainScreen dengan params yang telah ditentukan diatas
        buttonPink.setOnClickListener(this); // Menerapkan fungsi jika tombol di klik
    }

    public void toDo(View v) { // v sebagai parameter / variable untuk button
        if (v.equals(buttonBlue)) // Jika tombol buttonBlue diklik
            // invisibility
            v.setVisibility(View.INVISIBLE); // Men-set tampilannya menjadi invisible (tidak terlihat)
        if (v.equals(buttonPink)) // Jika tombol buttonPink diklik
            // pop-up
            Toast.makeText(getApplicationContext(), // Membuat pop-up (Toast) text dengan mengambil konteks aplikasi - tampilan saat ini
                    "To do to do to do..", // Isi text
                    Toast.LENGTH_SHORT).show(); // Pop-up (Toast) ditampilkan dengan waktu yang pendek
    }

    @Override
    public void onClick(View v) { // Fungsi onClick -> saat tombol diklik
        toDo(v); // Jalankan fungsi toDo(v)
    }
}
