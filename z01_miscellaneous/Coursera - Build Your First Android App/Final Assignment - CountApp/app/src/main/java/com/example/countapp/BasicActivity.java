package com.example.countapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class BasicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Menjalankan fungsi onCreate -> membuat tampilan

        setContentView(R.layout.activity_basic); // Men-set isi tampilan dengan layout dari file xml (activity_basic)

        Toast toast = Toast.makeText(this, R.string.welcome_basic, Toast.LENGTH_SHORT); // Membuat variabel (Toast) toast dan mengisinya dengan pesan selamat datang
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 70); // Mengatur posisi toast
        toast.show(); // Menampilkan toast

        WebView webView = (WebView) findViewById(R.id.webView_basic); // Membuat variabel (WebView) webView dan mengisinya dengan webView_basic dari file xml
        webView.getSettings().setAppCacheEnabled(true); // Men-set AppCacheEnable pada getSetting dari webView
        webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); // Men-set CacheMode pada getSetting dari webView
        webView.setWebViewClient(new WebViewClient()); // Men-set webView dengan menginisialisasi WebViewClient agar tidak membuka browser saat mengklik link baru
        webView.loadUrl("https://www.desmos.com/fourfunction"); // Memuat URL sumber untuk ditampilkan di webView
        WebSettings webSettings = webView.getSettings(); // Membuat variabel (WebSettings) webSettings dan mengambil settingan yang telah diatur di atas
        webSettings.setJavaScriptEnabled(true); // Men-set JavaScriptEnabled pada webSetting

    }
}