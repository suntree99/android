package com.example.cobaspeech;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

public class ContactListActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        TextView text = (TextView) findViewById(R.id.text);
        ListView list = (ListView) findViewById(R.id.list);
        Bundle extras = getIntent().getExtras();
        String stt = extras.getString("stt") != null ? extras.getString("stt") : "";
        text.setText(stt);
        DatabaseHelper mydb = new DatabaseHelper(this);
        final ArrayList<ContactListModel> data = mydb.getAllData(stt);
        mydb.close();
        for (int i = 0; i < data.size(); i++) {
            ContactListsAdapter adapter = new ContactListsAdapter(this, data);
            list.setAdapter(adapter);
        }
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String notelp = data.get(i).getNotelp();
                Intent intent = new Intent();
                intent.putExtra("notelp", notelp);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}