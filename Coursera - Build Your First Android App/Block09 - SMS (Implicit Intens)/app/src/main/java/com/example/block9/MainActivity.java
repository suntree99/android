package com.example.block9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Menjalankan fungsi onCreate -> membuat tampilan

        setContentView(R.layout.activity_main); // Men-set isi tampilan dengan layout dari file xml (activity_main)
    }

    public void sendMessage(View v) {

        EditText editTextMessaga = (EditText)findViewById(R.id.editText_message);
        String message = (editTextMessaga.getText().toString()); // Membuat variabel (String) message dan mengisinya dengan exitText_message dari file xml

        Uri destination = Uri.parse("smsto:5556"); // Membuat variabel (Uri) destination dan mengisinya

        Intent smsIntent = new Intent(Intent.ACTION_SENDTO, destination); // Membuat variabel (Intent) smsIntent dan menginisialisasi Intent dengan parameter destination
        smsIntent.putExtra("sms_body", message); // Menaruh key and value kedalaman smsIntent
        startActivity(smsIntent); // Menjalankan activity smsIntent

        Log.i("TAG_I_made_up", "I'm here!");
    }
}
