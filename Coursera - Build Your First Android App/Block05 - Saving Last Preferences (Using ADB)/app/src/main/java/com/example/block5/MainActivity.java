package com.example.block5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Menjalankan fungsi onCreate -> membuat tampilan

        setContentView(R.layout.activity_main);  // Men-set isi tampilan dengan layout dari file xml (activity_main)

        SharedPreferences preferences = getSharedPreferences("COLOR_PREF", Context.MODE_PRIVATE); // Membuat variabel (SharedPreferences) preferences dan mengisinya dengan preferensi warna
        final SharedPreferences.Editor editor = preferences.edit(); // Membuat variabel (Editor) editor untuk mengedit preferences

        final RelativeLayout layout = (RelativeLayout) findViewById(R.id.layout); // Membuat variabel (RelativeLayout) layout dan mengisinya dengan layout dari file xml

            if (preferences.contains(("colorId"))) // Jika preferenes berisi colorId
                layout.setBackgroundColor(preferences.getInt("colorId", 0)); // Men-set warna background layout dengan colorId

        RadioGroup radioGroup_colors = (RadioGroup) findViewById(R.id.radioGroup_colors); // Membuat variabel (RadioGroup) radioGroup_colors dan mengisinya dengan radioGroup_colors dari file xml

        radioGroup_colors.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // Jika radioGroup_colors berganti opsi
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) { // Fungsi perubahan opsi -> saat opsi dipilih

                int colorCode = 0; // Membuat variabel (int) colorCode dan mengisinya dengan nilai awal 0

                switch (checkedId) {
                    case R.id.radioButton_blue: // Jika opsi radioButton_blue yang dipilih
                        colorCode = Color.BLUE; // Isi colorCode dengan warna Biru
                        break; // Hentikan switch
                    case R.id.radioButton_magenta: // Jika opsi radioButton_magenta yang dipilih
                        colorCode = Color.MAGENTA; // Isi colorCode dengan warna Magenta
                        break; // Hentikan switch
                    case R.id.radioButton_yellow: // Jika opsi radioButton_yellow yang dipilih
                        colorCode = Color.YELLOW; // Isi colorCode dengan warna Kuning
                        break; // Hentikan switch
                }

                layout.setBackgroundColor(colorCode); // Men-set warna background layout sesuai colorCode
                editor.putInt("colorId", colorCode); // Menaruh nilai colorCode ke dalam colorId pada editor
                editor.commit(); // Menyimpan colorId dalam editor
            }
        });
    }
}
