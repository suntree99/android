package com.example.block8;

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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View v) {
        String message = ((EditText) (findViewById(R.id.editText_message))).getText().toString();
        Uri destination = Uri.parse("smsto:5556");
        Intent smsIntense = new Intent(Intent.ACTION_SENDTO, destination);
        smsIntense.putExtra("sms_body", message);
        startActivity(smsIntense);
        Log.i("TAG_I_made_up", "I'm here!");

    }
}
