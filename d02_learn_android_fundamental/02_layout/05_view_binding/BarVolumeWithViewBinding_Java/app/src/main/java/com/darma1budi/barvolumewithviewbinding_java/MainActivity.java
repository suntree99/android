package com.darma1budi.barvolumewithviewbinding_java;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
//hapus kode berikut
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;

import com.darma1budi.barvolumewithviewbinding_java.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

//    hapus kode berikut
//    private EditText edtWidth;
//    private EditText edtHeight;
//    private EditText edtLength;
//    private Button btnCalculate;
//    private TextView tvResult;

    private static final String STATE_RESULT = "state_result";

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        setContentView(R.layout.activity_main);

//        hapus kode berikut
//        edtWidth = findViewById(R.id.edt_width);
//        edtHeight = findViewById(R.id.edt_length);
//        edtLength = findViewById(R.id.edt_height);
//        btnCalculate = findViewById(R.id.btn_calculate);
//        tvResult = findViewById(R.id.tv_result);

        binding.btnCalculate.setOnClickListener(this);

        if(savedInstanceState != null) {
            String result = savedInstanceState.getString((STATE_RESULT));
            binding.tvResult.setText(result);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, binding.tvResult.getText().toString());
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_calculate) {
            String inputLength = binding.edtLength.getText().toString().trim();
            String inputWidth = binding.edtWidth.getText().toString().trim();
            String inputHeight = binding.edtHeight.getText().toString().trim();

            boolean isEmptyFields = false;

            if(TextUtils.isEmpty(inputLength)){
                isEmptyFields = true;
                binding.edtLength.setError("Field ini tidak boleh kosong");
            }

            if(TextUtils.isEmpty(inputWidth)){
                isEmptyFields = true;
                binding.edtWidth.setError("Field ini tidak boleh kosong");
            }

            if(TextUtils.isEmpty(inputHeight)){
                isEmptyFields = true;
                binding.edtHeight.setError("Field ini tidak boleh kosong");
            }

            if(!isEmptyFields){
                Double volume = Double.parseDouble(inputLength) * Double.parseDouble(inputWidth) * Double.parseDouble(inputHeight);
                binding.tvResult.setText(String.valueOf(volume));
            }
        }
    }
}