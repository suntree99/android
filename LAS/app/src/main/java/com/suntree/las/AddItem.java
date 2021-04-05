package com.suntree.las;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class AddItem extends AppCompatActivity implements View.OnClickListener {

    EditText editTextNama, editTextNik, editTextNoHp, editTextLaporan;
    Button buttonAddItem;
    @Override
    protected void onCreate (@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.add_item);

        editTextNama = (EditText) findViewById(R.id.et_nama);
        editTextNik = (EditText)findViewById(R.id.et_nik);
        editTextNoHp = (EditText)findViewById(R.id.et_no_hp);
        editTextLaporan = (EditText)findViewById(R.id.et_laporan);

        buttonAddItem = (Button)findViewById(R.id.btn_add_item);
        buttonAddItem.setOnClickListener(this);

    }

    // This is the part where data is transferred from Your android phone to sheet byy using HTTP Rest API calls

    private void addItemToSheet() {

        final ProgressDialog loading = ProgressDialog.show(this, "Mengirim Laporan", "Laporan sedang dikirim...");
        final String nama = editTextNama.getText().toString().trim();
        final String nik = editTextNik.getText().toString().trim();
        final String noHp = editTextNoHp.getText().toString().trim();
        final String laporan = editTextLaporan.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                "https://script.google.com/macros/s/AKfycbwIIzfdDBCddm4OIjwYNYzh67Mqn9gCLc1gQd8ll0yS-FE4iB6OCPQTXVccN1N8Vd3q9Q/exec",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        loading.dismiss();
                        Toast.makeText(AddItem.this, response, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> parmas = new HashMap<>();

                //here we pass params
                parmas.put("action", "addItem");
                parmas.put("nama", nama);
                parmas.put("nik", nik);
                parmas.put("noHp", noHp);
                parmas.put("laporan", laporan);

                return parmas;
            }
        };

        int socketTimeOut = 50000; // u can change this .. here it is 50 seconds

        RetryPolicy retryPolicy = new DefaultRetryPolicy(socketTimeOut,0,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(retryPolicy);

        RequestQueue queue = Volley.newRequestQueue(this);

        queue.add(stringRequest);

    }

    @Override
    public void onClick(View v) {

        if (v == buttonAddItem) {
            addItemToSheet();

            // Define what to do whn button is clicked
        }

    }

}
