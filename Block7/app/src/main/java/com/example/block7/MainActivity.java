package com.example.block7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.NumberPicker;

public class MainActivity extends AppCompatActivity {

    NumberPicker possibilities;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        possibilities = (NumberPicker) findViewById(R.id.numberPicker);
        webView = (WebView) findViewById(R.id.webView);
        String[] possibilitiesStrings = {
                "Android",
                "Checklist text-input field",
                "Coursera",
                "Supelec"
        };
        possibilities.setDisplayedValues(possibilitiesStrings);
        possibilities.setMinValue(0);
        possibilities.setMaxValue(possibilitiesStrings.length - 1);

    }

    public void navigate(View v) {
        int choice = possibilities.getValue();
        if(choice == 0) {
            webView.setWebViewClient(new WebViewClient());
            webView.loadUrl("file:///android_asset/dodol.html");
        } else if(choice == 1)
            webView.loadUrl("file:///android_asset/garut.html");
        else if(choice == 2)
            webView.loadUrl("http://www.coursera.org");
        else if(choice == 3)
            webView.loadUrl("file:///android_asset/legit.html");
    }
}
