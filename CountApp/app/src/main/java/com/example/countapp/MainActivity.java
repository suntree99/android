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

    MediaPlayer clickPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonBasic = (Button) findViewById(R.id.button_basic);
        Button buttonScientific = (Button) findViewById(R.id.button_scientific);
        TextView buttonExit = (TextView) findViewById(R.id.button_exit);
    }

    public void clickBasic(View v) {
        clickPlayer = MediaPlayer.create(this, R.raw.click_on);
        clickPlayer.start();
        Intent goToBasic = new Intent();
        goToBasic.setClass(this, BasicActivity.class);
        startActivity(goToBasic);
    }

    public void clickScientific(View v) {
        clickPlayer = MediaPlayer.create(this, R.raw.click_on);
        clickPlayer.start();
        Intent goToScientific = new Intent();
        goToScientific.setClass(this, ScientificActivity.class);
        startActivity(goToScientific);
    }

    public void clickExit(View view) {
        clickPlayer = MediaPlayer.create(this, R.raw.click_off);
        clickPlayer.start();
        Toast.makeText(this, R.string.bye_bye, Toast.LENGTH_SHORT).show();
        MainActivity.this.finish();
    }

}
