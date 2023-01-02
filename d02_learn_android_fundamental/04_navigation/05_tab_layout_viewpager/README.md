# Android
Description

## Project
- Nama Project : MyTabLayout
- Target & Minimum Target SDK : Phone and Tablet, Api level 21
- Tipe Activity : Empty Activity
- Activity Name : MainActivity
- Use AndroidX artifacts : True
- Language : Kotlin/`Java`

## Setup Dependency
- Pada `build.gradle(Module: app)` tambahkan library `ViewPager2` dan `Material Design` jika belum ada
```gradle
implementation 'com.google.android.material:material:1.3.1'
implementation "androidx.viewpager2:viewpager2:1.0.0"
```
- Klik `Sync Now` di pojok kanan atas supaya library tersebut terunduh ke dalam project

## Setup Layout Utama
- Atur `activity_main.xml` dengan `LinearLayout` dan tambahkan `TabLayout` dan `ViewPager2`
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">
 
    <com.google.android.material.tabs.TabLayout
        android:id="@+id/tabs"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="?attr/colorPrimary"
        app:tabTextColor="@android:color/white"/>

    <androidx.viewpager2.widget.ViewPager2
        android:id="@+id/view_pager"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />

</LinearLayout>
```

## Menerapkan TabLayout Dengan ViewPager2
- Buat Fragment baru, `klik kanan pada project -> New -> Fragment -> Fragment (Blank)`
- Setup Fragment, name: `HomeFragment`, layout name : `fragment_home`, dan pilih source language yang digunakan
- Atur `fragment_home.xml` menggunakan `FrameLayout`
	```xml
    <?xml version="1.0" encoding="utf-8"?>
    <FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".HomeFragment">
    
        <TextView
            android:id="@+id/section_label"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginStart="16dp"
            android:layout_marginTop="16dp"
            android:text="@string/content_tab_home" />
    
    </FrameLayout>
	```
- Tambahkan resource string pada `res → values → strings.xml`
	```xml
    <resources>
        <string name="app_name">MyTabLayout</string>
        <string name="tab_text_1">Home</string>
        <string name="tab_text_2">Profile</string>
        <string name="tab_text_3">Setting</string>
        <string name="content_tab_home">Welcome Home</string>
        <string name="content_tab_profile">Change your Profile here</string>
        <string name="content_tab_text">This is Tab %1$d</string>
    </resources>
	```
- Buat Fragment lagi, `klik kanan pada project -> New -> Fragment -> Fragment (Blank)`
- Setup Fragment, name: `ProfileFragment`, layout name : `fragment_profile`, dan pilih source language yang digunakan
- Atur `fragment_profile.xml` menggunakan `FrameLayout` yang sama
	```xml
    <?xml version="1.0" encoding="utf-8"?>
    <FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".ProfileFragment">
    
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginStart="16dp"
            android:layout_marginTop="16dp"
            android:text="@string/content_tab_profile" />
    
    </FrameLayout>
	```
- Buat Class baru, `klik kanan pada project -> New -> Kotlin Class / Java Class`
- Beri nama : `SectionsPagerAdapter` untuk mengatur ViewPager2 dan TabLayout
- Jika ada baris merah tekan `Alt+Enter` pada baris tersebut dan pilih `implement member(Kotlin)/method(Java)` dan OK
- Pada `SectionsPagerAdapter` atur kode seperti berikut
    ```java
    public class SectionsPagerAdapter extends FragmentStateAdapter { // Extends FragmentStateAdapter
    
        public SectionsPagerAdapter(AppCompatActivity activity) { // Constructor pada activity, jika pada fragment gunakan (FragmentActivity fragment)
            super(activity); // Jika pada fragment gunakan super(fragment)
        }
    
        @NonNull
        @Override
        public Fragment createFragment(int position) { // Fungsi untuk menampilkan fragment sesuai posisinya
            Fragment fragment = null; // Membuat variable
            switch (position) { // Pengondisian terhadap posisi tab (index)
                case 0:
                    fragment = new HomeFragment();
                    break;
                case 1:
                    fragment = new ProfileFragment();
                    break;
            }
            return fragment; // Mengembalikan fragment untuk ditampilkan
        }
    
        @Override
        public int getItemCount() { // Jumlah tab yang ingin ditampilkan, harus sesuai dengan kode diatas
            return 2;
        }
    }
    ```
- Pada `MainActivity.java` panggil class `SectionsPagerAdapter` dan setup `ViewPager2` dan `TabLayout`
    ```java
    public class MainActivity extends AppCompatActivity {
    
        @StringRes
        private final int[] TAB_TITLES = new int[]{ // Membuat konstanta TAB_TITLES untuk mengatur judul tab
                R.string.tab_text_1, // Judul tab pertama
                R.string.tab_text_2 // Judul tab kedua
        };
    
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
    
            SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this); // Menginstansiasi SPA
            
            ViewPager2 viewPager = findViewById(R.id.view_pager); // Casting viewPager2
            viewPager.setAdapter(sectionsPagerAdapter); // Menerapkan VP pada SPA
            
            TabLayout tabs = findViewById(R.id.tabs); // Casting TabLayout
            
            new TabLayoutMediator(tabs, viewPager, // Mengatur hubungan TL dan VP
                    (tab, position) -> tab.setText(getResources().getString(TAB_TITLES[position]))
            ).attach();

            if(getSupportActionBar() != null) { // Pengondisian jika ada ActionBar
                getSupportActionBar().setElevation(0); // Terapkan diatas
            }
        }
    }
    ```
- Jalankan Aplikasi atau tekan `Shift+F10`

## TabLayout With One Fragment
- Kita hanya akan menggunakan `HomeFragment`, hapus kode yang tidak dibutuhkan dan tambahkan kode seperti berikut
	```java
    public class HomeFragment extends Fragment {
    
        private static final String ARG_SECTION_NUMBER = "section_number"; // Menambagkan konstanta untuk menerima data
    
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_home, container, false);
        }
    
        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) { // Menambahkan method onViewCreated untuk mengatur tampilan fragmen
            super.onViewCreated(view, savedInstanceState);

            final TextView textView = view.findViewById(R.id.section_label); // Casting TV yang sudah ditambahkan pada fragmenta_home.xml

            int index = 1; // 
            if (getArguments() != null) { // Pengondisian mengecek data arguments yang dikirimkan
                index = getArguments().getInt(ARG_SECTION_NUMBER); // Mengambil data yang dikirimkan
                textView.setText(getString(R.string.content_tab_text, index)); // Mengisi TV dengan format text
                // <string name="content_tab_text">This is Tab %1$d</string> 
            }
        }
    }
    ```

- Pada `SectionsPagerAdapter`, hapus kode yang tidak dibutuhkan dan tambahkan kode seperti berikut
	```java
    public class SectionsPagerAdapter extends FragmentStateAdapter { // Extends FragmentStateAdapter
    
        public SectionsPagerAdapter(AppCompatActivity activity) { // Constructor pada activity, jika pada fragment gunakan (FragmentActivity fragment)
            super(activity); // Jika pada fragment gunakan super(fragment)
        }
    
        @NonNull
        @Override
        public Fragment createFragment(int position) {

        // Kode berikut hanya digunakan untuk pemanggilan fragment yang berbeda
        //    Fragment fragment = null;
        //    switch (position) {
        //        case 0:
        //            fragment = new HomeFragment();
        //            break;
        //        case 1:
        //            fragment = new ProfileFragment();
        //            break;
        //    }
        
            HomeFragment fragment = new HomeFragment(); // Menginstansiasi HF
            Bundle bundle = new Bundle(); // Menginstnsiasi Bundle untuk mengirim data
            bundle.putInt(HomeFragment.ARG_SECTION_NUMBER, position+1); // Mengisi data ke HF, position+1 karena index dari 0
            fragment.setArguments(bundle); // Mengirim data melalui Bundle

            return fragment;
        }
    
        @Override
        public int getItemCount() {
            return 3; // Ubah menjadi 3, karena akan menggunakan 3 tab (sesuai kebutuhan)
        }
    }
    ```

- Pada `MainActivity.java` tambahkan judul tab menjadi 3 (sesuai kebutuhan)
    ```java
        @StringRes
        private final int[] TAB_TITLES = new int[]{
                R.string.tab_text_1,
                R.string.tab_text_2,
                R.string.tab_text_3 // Tab tambahan
    };
    ```
- Jalankan Aplikasi atau tekan `Shift+F10`


##
##

# Heading 1 / Judul Utama (gunakan #)

## Heading 2 / Sub Judul (gunakan ##)

Text biasa (ditulis biasa tanpa format apapun)

[Hyperlink](https://www.google.com) (nama hyperlink dibungkus kurung siku, urlnya dibungkus tanda kurung biasa)

```bash
git add .
git commit -m "baris code menggunakan backtick 3x di awal(sertakan bahasanya) dan akhir code"
git push
```

Untuk `menyoroti` bungkus text dengan backtick 1x

# Template

## Sub Judul 
```<bahasa>
git add .
git commit -m 'Update README.md'
git push

```

Update README.md