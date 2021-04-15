package com.example.block10;
        import androidx.appcompat.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Menjalankan fungsi onCreate -> membuat tampilan
        setContentView(R.layout.activity_main); // Men-set isi tampilan dengan layout dari file xml (activity_main)
        // Menampilkan pop-up (Toast) saat membuat tampilan di pembukaan awal aplikasi atau setelah apliasi ditutup
        Toast.makeText(getApplicationContext(), "onCreate", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStart() {
        super.onStart();
        // Menampilkan pop-up (Toast) saat memulai tampilan atau setelah onRestart
        Toast.makeText(getApplicationContext(),"onStart", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        // Menampilkan pop-up (Toast) saat membuka-ulang tampilan dalam kondisi ditutup sementara
        Toast.makeText(getApplicationContext(),"onRestart", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        // Menampilkan pop-up (Toast) saat melanjutkan tampilan setelah onStart
        Toast.makeText(getApplicationContext(),"onResume", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause() {
        super.onPause();
        // Menampilkan pop-up (Toast) saat menutup sementara / beralih ke aplikasi lain atau menutup aplikasi
        Toast.makeText(getApplicationContext(),"onPause", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStop() {
        super.onStop();
        // Menampilkan pop-up (Toast) saat menutup sementara (setelah onPause)
        Toast.makeText(getApplicationContext(),"onStop", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Menampilkan pop-up (Toast) saat menutup aplikasi (setelah onStop)
        Toast.makeText(getApplicationContext(),"onDestroy", Toast.LENGTH_SHORT).show();
    }
}