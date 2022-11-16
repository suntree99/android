package com.example.convertmilestokmapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Menjalankan fungsi onCreate -> membuat tampilan

        setContentView(R.layout.activity_main); // Men-set isi tampilan dengan layout dari file xml (activity_main)

        Button buttonConvMilesToKm = (Button) findViewById(R.id.buttonConvMilesToKm); // Membuat variabel (Button) buttonConvMilesToKm dan mengisinya dengan buttonConvMilesToKm dari file xml
        buttonConvMilesToKm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // Menerapkan fungsi jika tombol diklik
                EditText textBoxMiles = (EditText) findViewById(R.id.editTextMiles); // Membuat variabel (EditText) textBoxMiles dan mengisinya dengan editTextMiles dari file xml
                EditText textBoxKm = (EditText) findViewById(R.id.editTextKm); // Membuat variabel (EditText) textBoxKm dan mengisinya dengan editTextKm dari file xml
                double vMiles = Double.valueOf(textBoxMiles.getText().toString()); //  Membuat variabel (double) vMiles dan mengisinya dengan nilai dari textBoxMiles
                double vKm = vMiles / 0.62137; // Membuat variabel (double) dan mengisinya dengan nilai konversi terhadap vMiles
                DecimalFormat formatVal = new DecimalFormat("##.##"); // Membuat variabel (DecimalFormat) formatVal dan menginisialisasinya dengan pola ##.##
                textBoxKm.setText(formatVal.format(vKm)); // Men-set isi text dari textBoxKm dengan vKm yang diberi format desimal
            }
        });

        Button buttonConvKmToMiles = (Button) findViewById(R.id.buttonConvKmToMiles); // Membuat variabel (Button) buttonConvKmToMiles dan mengisinya dengan buttonConvKmToMiles dari file xml
        buttonConvKmToMiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // Menerapkan fungsi jika tombol diklik
                EditText textBoxMiles = (EditText) findViewById(R.id.editTextMiles); // Membuat variabel (EditText) textBoxMiles dan mengisinya dengan editTextMiles dari file xml
                EditText textBoxKm = (EditText) findViewById(R.id.editTextKm); // Membuat variabel (EditText) textBoxKm dan mengisinya dengan editTextKm dari file xml
                double vKm = Double.valueOf(textBoxKm.getText().toString()); //  Membuat variabel (double) vKm dan mengisinya dengan nilai dari textBoxKm
                double vMiles = vKm * 0.62137; // Membuat variabel (double) dan mengisinya dengan nilai konversi terhadap vKm
                DecimalFormat formatVal = new DecimalFormat("##.##"); // Membuat variabel (DecimalFormat) formatVal dan menginisialisasinya dengan pola ##.##
                textBoxMiles.setText(formatVal.format(vMiles)); // Men-set isi text dari textBoxMiles dengan vMiles yang diberi format desimal
            }
        });
    }
}
