package com.suntree.las;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddItem extends AppCompatActivity implements View.OnClickListener {
    Button buttonAddItem;
    private EditText editTextItemName;
    private EditText editTextBrand;
    @Override
    protected void onCreate (@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.add_item);

        editTextItemName = (EditText) findViewById(R.id.et_item_name);
        editTextBrand = (EditText)findViewById(R.id.et_brand);

        buttonAddItem = (Button)findViewById(R.id.btn_add_item);
        buttonAddItem.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

    }

//    private void addItemToSheet() {
//
//        final ProgressDialogloading = ProgressDialog.show(this, "Adding Item", "PLeaseWait");
//        final String name = editTextItemName.getText().toString.trim();
//        final String brand = editTextBrand.getText().toString.trim();
//
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://",
//            new Response.Listener<String>() {
//                @Override
//                public void onResponse(String response) {
//
//                    loading.dismiss();
//                    Toast.makeText(AddItem.this,response,Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                    startActivity(intent);
//
//                }
//            },
//            new Response.ErrorListener() {
//                @Override
//                public void onErrorResponse(VolleyError error) {
//
//                }
//            }
//        ) {
//            @Override
//            protected Map<String, String> getParams() {
//                Map<String, String> parmas = new HashMap<>();
//
//                //here we pass params
//                parmas.put("action","addItem");
//                parnas.put("itemName",name);
//                parmas.put("brand",brand);
//
//                return parmas;
//            }
//        };
//
//        int socketTimeOut = 50000;// u can change this .. here it is 50 seconds
//
//        RetryPolicy retryPolicy = new DefaultRetryPolicy(socketTimeOut,0,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
//        stringRequest.setRetryPolicy(retryPolicy);
//
//        RequestQueue queue = Volley.newRequestQueue(this);
//
//        queue.add(stringRequest);
//
//    }

}
