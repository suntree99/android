package com.example.countapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MediaPlayer clickPlayer; // Membuat variabel (MediaPlayer) clickPlayer untuk memutar suara

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Menjalankan fungsi onCreate -> membuat tampilan

        setContentView(R.layout.activity_main); // Men-set isi tampilan dengan layout dari file xml (activity_main)

        Button buttonBasic = (Button) findViewById(R.id.button_basic); // Membuat variabel (Button) buttonBasic dan mengisinya dengan button_basic dari file xml
        Button buttonScientific = (Button) findViewById(R.id.button_scientific); // Membuat variabel (Button) buttonScientific dan mengisinya dengan button_scientific dari file xml
        TextView buttonExit = (TextView) findViewById(R.id.button_exit); // Membuat variabel (Button) buttonExit dan mengisinya dengan button_exit dari file xml
    }

    public void clickBasic(View v) { // Jika buttonBasic di klik
        clickPlayer = MediaPlayer.create(this, R.raw.click_on); // Mengisi clickPlayer dengan file click_on.mp3 dari folder raw
        clickPlayer.start(); // Menjalankan clickPlayer
        Intent goToBasic = new Intent(); // Membuat variabel (Intent) goToBasic dan menginisialisasinya
        goToBasic.setClass(this, BasicActivity.class); // Men-set class BasicActivity (Java) pada goToBasic
        startActivity(goToBasic); // Menjalankan activity dari goToBasic
    }

    public void clickScientific(View v) { // Jika buttonScientific di klik
        clickPlayer = MediaPlayer.create(this, R.raw.click_on); // Mengisi clickPlayer dengan file click_on.mp3 dari folder raw
        clickPlayer.start(); // Menjalankan clickPlayer
        Intent goToScientific = new Intent(); // Membuat variabel (Intent) goToScientific dan menginisialisasinya
        goToScientific.setClass(this, ScientificActivity.class); // Men-set class ScientificActivity (Java) pada goToScientific
        startActivity(goToScientific); // Menjalankan activity dari goToScientific
    }

    public void clickExit(View view) {
        clickPlayer = MediaPlayer.create(this, R.raw.click_off); // Mengisi clickPlayer dengan file click_off.mp3 dari folder raw
        clickPlayer.start(); // Menjalankan clickPlayer
        Toast.makeText(this, R.string.bye_bye, Toast.LENGTH_SHORT).show();
        MainActivity.this.finish(); // Mengakhiri activity
    }

}
