package com.example.convertmilestokm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonConvertmtokm = (Button) findViewById(R.id.buttonConvertmtokm);
        buttonConvertmtokm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText textboxMiles = (EditText) findViewById(R.id.editTextMiles);
                EditText textboxKm = (EditText) findViewById(R.id.editTextKilometers);
                double vMiles = Double.valueOf(textboxMiles.getText().toString());
                double vKm = vMiles / 0.62137;
                DecimalFormat formatVal = new DecimalFormat("##.##");
                textboxKm.setText(formatVal.format(vKm));
            }
        });
        Button buttonConvertkmtom = (Button) findViewById(R.id.buttonConvertkmtom);
        buttonConvertkmtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText textboxKm = (EditText) findViewById(R.id.editTextKilometers);
                EditText textboxMiles = (EditText) findViewById(R.id.editTextMiles);
                double vKm = Double.valueOf(textboxKm.getText().toString());
                double vMiles = vKm * 0.62137;
                DecimalFormat formatVal = new DecimalFormat("##.##");
                textboxMiles.setText(formatVal.format(vMiles));
            }
        });
    }
}
