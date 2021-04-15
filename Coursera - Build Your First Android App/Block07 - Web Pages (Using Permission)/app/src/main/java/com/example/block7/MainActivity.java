package com.example.block7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.NumberPicker;

public class MainActivity extends AppCompatActivity {

    NumberPicker possibilities; // Membuat variabel (NumberPicker) possibilities
    WebView webView; // Membuat variabel (WebView) webView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Menjalankan fungsi onCreate -> membuat tampilan

        setContentView(R.layout.activity_main); // Men-set isi tampilan dengan layout dari file xml (activity_main)

        possibilities = (NumberPicker) findViewById(R.id.numberPicker); // Mengisi possibilities dengan numberPicker dari file xml
        webView = (WebView) findViewById(R.id.webView); // Mengisi webView dengan webView dari file xml

        String[] possibilitiesStrings = { // Membuat variabel (Array String) possibilitiesStrings dan mengisinya dengan item
                "Android",
                "Checklist text-input field",
                "Coursera",
                "Supelec"
        };

        possibilities.setDisplayedValues(possibilitiesStrings); // Menampilkan item possibilitiesStrings pada possibilities
        possibilities.setMinValue(0); // Men-set nilai (index) minimum
        possibilities.setMaxValue(possibilitiesStrings.length - 1); // Men-set nilai (index) maksimum
    }

    public void navigate(View v) { // Jika tombol OK diklik (pengaturan onClick pada file xml)
        int choice = possibilities.getValue(); // Membuat variabel (Int) choice dan mengisinya dengan nilai possibilities
        if(choice == 0) { // Jika choice == 0
            webView.setWebViewClient(new WebViewClient()); // Men-set webView dengan menginisialisasi WebViewClient agar tidak membuka browser saat mengklik link baru
            webView.loadUrl("file:///android_asset/android.html"); // Memuat URL sumber untuk ditampilkan di webView
        } else if(choice == 1) // Jika choice == 1
            webView.loadUrl("file:///android_asset/checklist.html"); // Memuat URL sumber untuk ditampilkan di webView
        else if(choice == 2) // Jika choice == 2
            webView.loadUrl("http://www.coursera.org"); // Memuat URL sumber untuk ditampilkan di webView
        else if(choice == 3) // Jika choice == 3
            webView.loadUrl("file:///android_asset/supelec.html"); // Memuat URL sumber untuk ditampilkan di webView
    }
}
