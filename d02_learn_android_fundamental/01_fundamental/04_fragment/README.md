# Fragment
Codelab Fragment di Activity

## Project
- Nama Project : 
- Target & Minimum Target SDK :
- Tipe Activity :
- Activity Name :
- Use AndroidX artifacts :
- Language : 

## Setup Tampilan
Mengatur `activity_main.xml` dengan `FrameLayout` sebagai tempat Fragment
```xml
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/frame_container"
    android:layout_width="match_parent"
    android:layout_height="match_parent"/>
```

## Perpindahan Antar Fragment Pada Activity Yang Sama 
- Buat Fragment baru, `klik kanan pada project -> New -> Fragment -> Fragment (Blank)`
- Setup Fragment, name: `HomeFragment`, layout name : `fragment_home`, dan pilih source language yang digunakan
- Atur `fragment_home.xml` seperti berikut:
	```xml
	<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
		xmlns:tools="http://schemas.android.com/tools"
		android:layout_width="match_parent"
		android:layout_height="match_parent"
		android:orientation="vertical">
	
		<TextView
			android:layout_width="match_parent"
			android:layout_height="wrap_content"
			android:layout_margin="16dp"
			android:text="@string/hello_home_fragment" />

		<Button
			android:id="@+id/btn_category"
			android:layout_width="match_parent"
			android:layout_height="wrap_content"
			android:layout_marginLeft="16dp"
			android:layout_marginRight="16dp"
			android:text="@string/to_category" />
			
	</LinearLayout>
	```
- Tambahkan resource string pada `res → values → strings.xml` seperti berikut:
	```xml
	<resources>
		<string name="app_name">MyFlexibleFragment</string>
	
		<string name="hello_blank_fragment">Hello blank fragment</string>
		<string name="this_profile">Ini activity Profile</string>
		<string name="this_category">Ini fragment Category</string>
		<string name="category_lifestyle">Ke fragment Lifestyle</string>
		<string name="category_name">Category Name</string>
		<string name="category_description">Category Description</string>
		<string name="to_profile">Ke Halaman Profile Activity</string>
		<string name="show_dialog">Tampilkan sebuah dialog</string>
		<string name="hello_home_fragment">Hello Ini Home Fragment</string>
		<string name="to_category">Ke fragment Category</string>
		<string name="question_coach">Siapa pelatih tersukses Machester United?</string>
		<string name="sir_alex_ferguson">Sir Alex Ferguson</string>
		<string name="jose_mourinho">Jose Mourinho</string>
		<string name="louis_van_gaal">Louis Van Gaal</string>
		<string name="david_moyes">David Moyes</string>
		<string name="choose">Pilih</string>
		<string name="close">Tutup</string>
	</resources>
	```
- Pada `HomeFragment` hapus kode yang tidak diperlukan, menjadi seperti ini
	```java
	public class BlankFragment extends Fragment {

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, // 
								Bundle savedInstanceState) {
			// Inflate the layout for this fragment
			return inflater.inflate(R.layout.fragment_home, container, false);
		}
	}
	```
- Pada `HomeFragment` implements `View.OnClickListener` dan tambahkan fungsi `onViewCreated`
	```java
	public class HomeFragment extends Fragment implements View.OnClickListener {
	
		@Override
		public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
								Bundle savedInstanceState) {

			return inflater.inflate(R.layout.fragment_home, container, false);
			// mengubah layout xml menjadi object viewgroup dengan metode inflate()
			// inflate(layout fragment, layout activity (root), ditanamkan atau dipisah dengan root)
		}
	
		@Override
		public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) { // Dipanggil setelah oCreateView
			super.onViewCreated(view, savedInstanceState);

			Button btnCategory = view.findViewById(R.id.btn_category); // Digunakan untuk mengiisiasi view
			// penambahan view. menunjukkan object view berada di fragment bukan di root
			btnCategory.setOnClickListener(this); // dan mengatur actionnya
		}
		@Override
		public void onClick(View v) {
		}
	}
	```
- Pada `MainActivity` kita tanamkan `HomeFragment`
	```java
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		FragmentManager mFragmentManager = getSupportFragmentManager(); // Menginstansiasi Fragment Manager
		HomeFragment mHomeFragment = new HomeFragment(); // Menginstansiasi HomeFragment
		Fragment fragment = mFragmentManager.findFragmentByTag(HomeFragment.class.getSimpleName()); // Mendaftarkan HomeFragment menjadi Fragment menggunakan Fragment Manager
		
		if (!(fragment instanceof HomeFragment)) { 
			Log.d("MyFlexibleFragment", "Fragment Name :" + HomeFragment.class.getSimpleName()); // Menampilkan info melalui Log.d("String", "String")
			mFragmentManager
				.beginTransaction()
				.add(R.id.frame_container, mHomeFragment, HomeFragment.class.getSimpleName()) // add(Activity Layout, Fragment Manager, Fragment)
				.commit();
		}
	}
	```
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