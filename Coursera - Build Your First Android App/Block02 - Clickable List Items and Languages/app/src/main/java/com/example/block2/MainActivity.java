package com.example.block2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Menjalankan fungsi onCreate -> membuat tampilan

        setContentView(R.layout.activity_main); // Men-set isi tampilan dengan layout dari file xml (activity_main)

        ListView listViewAnimals = (ListView) findViewById(R.id.listView); // Membuat variabel (ListView) listViewAnimal dan mengisinya dengan listView dari file xml

        final ArrayAdapter<CharSequence> adapterAnimals = ArrayAdapter.createFromResource( // Membuat variabel (ArrayAdapter) adapterAnimals dan mengisinya
                this, // Mengambil konteks aplikasi, tampilan saat ini
                R.array.animalsArray, // Mengambil array animalsArray dari file xml (string)
                android.R.layout.simple_list_item_1); // Menerapkan layout simple_list_item_1 (default)

        listViewAnimals.setAdapter(adapterAnimals); // Mengisi listViewAnimals dengan adapterAnimals

        listViewAnimals.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) { // Menerapkan fungsi setOnItemClickListener -> saat item diklik
                String message = getString(R.string.toastMessage) + adapterAnimals.getItem(position); // Membuat variabel (String) message dan mengisinya dengan text dan item adapterAnimals yang diklik
                Toast.makeText(getApplicationContext(), // Membuat pop-up (Toast) text dengan mengambil konteks aplikasi, tampilan saat ini
                        message, // Mengisi text dengan isi message
                        Toast.LENGTH_SHORT).show(); // Pop-up (Toast) ditampilkan dengan waktu yang pendek
            }
        });

        // Catatan : Pembuatan multiple-language dapat dilakukan pada editor bahasa di string.xml
    }
}
