package com.darma1budi.mytestingapp_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSetValue;
    private TextView tvText;
    private ArrayList<String> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvText = findViewById(R.id.tv_text);
        btnSetValue = findViewById(R.id.btn_set_value);

        btnSetValue.setOnClickListener(this);

        names = new ArrayList<>();
        names.add("Narenda Wicaksono");
        names.add("Kevin");
        names.add("Yoza");
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_set_value) {
//             tvText.setText("19");

            Log.d("MainActivity", names.toString()); // menampilkan data pada log
            StringBuilder name = new StringBuilder();
            for (int i = 0; i <= 2; i++){
                name.append(names.get(i)).append("\n");
            }
            tvText.setText(name.toString());
        }
    }
}