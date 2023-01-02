# Fragment
Codelab Fragment di Activity

## Project
- Nama Project : MyFlexibleFragment
- Target & Minimum Target SDK : Phone and Tablet, API level 21
- Tipe Activity : Empty Activity
- Activity Name : MainActivity
- Use AndroidX artifacts : True
- Language : Kotlin / `Java`

## Setup Layout Utama
- Atur `activity_main.xml` dengan `FrameLayout` sebagai tempat Fragment
```xml
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/frame_container"
    android:layout_width="match_parent"
    android:layout_height="match_parent"/>
```

## Menampilkan Fragment Pada Activity 
- Buat Fragment baru, `klik kanan pada project -> New -> Fragment -> Fragment (Blank)`
- Setup Fragment, name: `HomeFragment`, layout name : `fragment_home`, dan pilih source language yang digunakan
- Atur `fragment_home.xml` menggunakan `LinearLayout`
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
- Tambahkan resource string pada `res → values → strings.xml`
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
		public View onCreateView(LayoutInflater inflater, ViewGroup container, 
								Bundle savedInstanceState) {
			
			return inflater.inflate(R.layout.fragment_home, container, false); // Mengubah layout xml menjadi object viewgroup
			// inflate(layout fragment, layout activity (root), ditanamkan atau dipisah dengan root)
		}
	}
	```
- Masih pada `HomeFragment` tambahkan implements `View.OnClickListener` dan tambahkan fungsi `onViewCreated`
	```java
	public class HomeFragment extends Fragment implements View.OnClickListener {
	
		@Override
		public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
								Bundle savedInstanceState) {

			return inflater.inflate(R.layout.fragment_home, container, false);
		}
	
		@Override
		public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) { // Digunakan untuk menginisiasi view dan mengatur actionnya
			super.onViewCreated(view, savedInstanceState);

			Button btnCategory = view.findViewById(R.id.btn_category); // Untuk fragment ditambahkan view.
			btnCategory.setOnClickListener(this);
		}

		@Override // Implementasi method
		public void onClick(View v) {

		}
	}
	```
- Pada `MainActivity` tanamkan `HomeFragment` menggunakan `FragmentManager`
	```java
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		FragmentManager mFragmentManager = getSupportFragmentManager(); // Menginstansiasi FM dengan getSupportFM
		HomeFragment mHomeFragment = new HomeFragment(); // Menginstansiasi HF
		Fragment fragment = mFragmentManager.findFragmentByTag(HomeFragment.class.getSimpleName()); // Mendaftarkan HF untuk dikelola FM
		
		if (!(fragment instanceof HomeFragment)) { // Mengecek dan memastikan fragment instance dari HF
			Log.d("MyFlexibleFragment", "Fragment Name :" + HomeFragment.class.getSimpleName()); // Menampilkan info via Log.d("String", "String")
			mFragmentManager // Proses manipulasi tampilan fragment di activity
				.beginTransaction()
				.add(R.id.frame_container, mHomeFragment, HomeFragment.class.getSimpleName()) // add(Activity Layout, HF, Fragment Name)
				.commit(); // Menerapkan fragment untui ditampilkan
		}
	}
	```
- Jalankan Aplikasi atau tekan `Shift+F10`

## Berpindah Antar Fragment Pada Activity Yang Sama
- Buat Fragment baru, `klik kanan pada project -> New -> Fragment -> Fragment (Blank)`
- Setup Fragment, name: `CategoryFragment`, layout name : `fragment_category`, dan pilih source language yang digunakan
- Atur `fragment_category.xml` seperti berikut:
	```xml
	<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
		xmlns:tools="http://schemas.android.com/tools"
		android:layout_width="match_parent"
		android:layout_height="match_parent"
		android:orientation="vertical"
		android:padding="16dp">
	
		<TextView
			android:layout_width="match_parent"
			android:layout_height="wrap_content"
			android:layout_marginBottom="16dp"
			android:text="@string/this_category" />

		<Button
			android:id="@+id/btn_detail_category"
			android:layout_width="match_parent"
			android:layout_height="wrap_content"
			android:text="@string/category_lifestyle" />

	</LinearLayout>
	```
- Pada `CategoryFragment` hapus kode yang tidak diperlukan, dan ubah menjadi seperti ini
	```java
	public class CategoryFragment extends Fragment implements View.OnClickListener {
	
		public CategoryFragment() { // Constructor kosong
		}
	
		@Override
		public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
								Bundle savedInstanceState) {
			// Inflate the layout for this fragment
			return inflater.inflate(R.layout.fragment_category, container, false);
		}
		
		@Override
		public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
			super.onViewCreated(view, savedInstanceState);
			
			Button btnDetailCategory = view.findViewById(R.id.btn_detail_category);
			btnDetailCategory.setOnClickListener(this);
		}

		@Override
		public void onClick(View v) {
			if (v.getId() == R.id.btn_detail_category){ // Pengondisian seleksi view berdasarkan id

			}
		}
	}
	```
- Kembali pada `HomeFragment` tambahkan kode pada fungsi onClick() menjadi seperti ini
	```java
	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.btn_category) {
			FragmentManager mFragmentManager = getParentFragmentManager(); // Menginstansiasi FM dengan getParentFM (Mengambil dari Activity)
			CategoryFragment mCategoryFragment = new CategoryFragment();
			mFragmentManager
					.beginTransaction()
					.replace(R.id.frame_container, mCategoryFragment, CategoryFragment.class.getSimpleName()) // replace(Activity Layout, HF, Fragment Name)
					.addToBackStack(null) // Membuat fragment ditutup satu persatu, jika tidak langsung close
					.commit();
		}
	}
	```
- Jalankan Aplikasi atau tekan `Shift+F10`

## Mengirim Data Antar Fragment Pada Activity Yang Sama
- Buat Fragment baru, `klik kanan pada project -> New -> Fragment -> Fragment (Blank)`
- Setup Fragment, name: `DetailCategoryFragment`, layout name : `fragment_detail_category`, dan pilih source language yang digunakan
- Atur `fragment_detail_category.xml` seperti berikut:
	```xml
	<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
		xmlns:tools="http://schemas.android.com/tools"
		android:layout_width="match_parent"
		android:layout_height="match_parent"
		android:orientation="vertical"
		android:padding="16dp">
	
		<TextView
			android:id="@+id/tv_category_name"
			android:layout_width="match_parent"
			android:layout_height="wrap_content"
			android:layout_marginBottom="16dp"
			android:text="@string/category_name" />

		<TextView
			android:id="@+id/tv_category_description"
			android:layout_width="match_parent"
			android:layout_height="wrap_content"
			android:layout_marginBottom="16dp"
			android:text="@string/category_description" />

		<Button
			android:id="@+id/btn_profile"
			android:layout_width="match_parent"
			android:layout_height="wrap_content"
			android:text="@string/to_profile" />
		
		<Button
			android:id="@+id/btn_show_dialog"
			android:layout_width="match_parent"
			android:layout_height="wrap_content"
			android:text="@string/show_dialog" />
	
	</LinearLayout>
	```
- Pada `DetailCategoryFragment` hapus kode yang tidak diperlukan, dan ubah menjadi seperti ini
	```java
	public class DetailCategoryFragment extends Fragment {
	
		// Inisialisasi variabel view
		TextView tvCategoryName;
		TextView tvCategoryDescription;
		Button btnProfile;
		Button btnShowDialog;

		// Inisialisasi konstanta untuk perantara pengiriman data (dibuat di fragment tujuan)
		public static String EXTRA_NAME = "extra_name";
		public static String EXTRA_DESCRIPTION = "extra_description";
		
		// Inisialisasi variable untuk menerima data beserta setter dan getter nya
		private String description;

		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
	
		@Override
		public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
								Bundle savedInstanceState) {
			// Inflate the layout for this fragment
			return inflater.inflate(R.layout.fragment_category, container, false);
		}
		
		@Override
		public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
			super.onViewCreated(view, savedInstanceState);
			
			// Casting variable view
			tvCategoryName = view.findViewById(R.id.tv_category_name);
			tvCategoryDescription = view.findViewById(R.id.tv_category_description);
			btnProfile = view.findViewById(R.id.btn_profile);
			btnShowDialog = view.findViewById(R.id.btn_show_dialog);

			// Menerima Data menggunakan Bundle
			if (savedInstanceState != null) { // Mengecek data yang disimpan di Bundle
				String descFromBundle = savedInstanceState.getString(EXTRA_DESCRIPTION); // Mengambil data yang dikirim
				setDescription(descFromBundle); // Menerapkan data menggunakan setter
			}

			// Menerima Data menggunakan Arguments
			if (getArguments() != null) { // Mengecek data yang dikirimkan via argument
				String categoryName = getArguments().getString(EXTRA_NAME); // Mengambil data yang dikirimkan
				tvCategoryName.setText(categoryName); // Menerapkan data pada text view

				tvCategoryDescription.setText(getDescription()); // Mengambil dan menerapkan data dengan getter
			}
		}

		@Override
		public void onClick(View v) {
			if (v.getId() == R.id.btn_detail_category){

			}
		}
	}
	```
- Kembali pada `CategoryFragment` tambahkan kode pada fungsi onClick() menjadi seperti ini
	```java
	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.btn_detail_category) {
			FragmentManager mFragmentManager = getParentFragmentManager; // Menginstansiasi FM dengan getParentFM
			DetailCategoryFragment mDetailCategoryFragment = new DetailCategoryFragment(); // Menginstansiasi DCF
			
			// Isisialisasi object Bundle untuk mengirim data
			Bundle mBundle = new Bundle(); // Menginstansiasi Bundle untuk menyimpan data di state
			mBundle.putString(DetailCategoryFragment.EXTRA_NAME, "Lifestyle"); // Mengirim data menggunakan Bundle via konstanta EXTRA_NAME di DCF

			// Deklarasi variable untuk dikirimkan menggunakan setter
			String description = "Kategori ini akan berisi produk-produk lifestyle"; // Deklarasi variable

			mDetailCategoryFragment.setArguments(mBundle); // Mengirimkan data dengan bundle via arguments
			mDetailCategoryFragment.setDescription(description); // mengirim data menggunakan setter

			if (mFragmentManager != null) { // Mengecek keberadaan FM
				mFragmentManager
						.beginTransaction()
						.replace(R.id.frame_container, mDetailCategoryFragment, DetailCategoryFragment.class.getSimpleName())
						.addToBackStack(null)
						.commit();
			}
		}
	}
	```
- Jalankan Aplikasi atau tekan `Shift+F10`

## Fragment Untuk Dialog
- Buat Fragment baru, `klik kanan pada project -> New -> Fragment -> Fragment (Blank)`
- Setup Fragment, name: `OptionDialogFragment`, layout name : `fragment_option_dialog`, dan pilih source language yang digunakan
- Atur `fragment_option_dialog.xml` seperti berikut:
	```xml
	<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
		xmlns:tools="http://schemas.android.com/tools"
		android:layout_width="match_parent"
		android:layout_height="wrap_content"
		android:orientation="vertical"
		android:padding="16dp">
	
		<TextView
			android:layout_width="match_parent"
			android:layout_height="wrap_content"
			android:layout_marginBottom="16dp"
			android:text="@string/question_coach" />

		<RadioGroup
			android:id="@+id/rg_options"
			android:layout_width="match_parent"
			android:layout_height="wrap_content"
			android:orientation="vertical">
			<RadioButton
				android:id="@+id/rb_saf"
				android:layout_width="match_parent"
				android:layout_height="wrap_content"
				android:layout_marginBottom="16dp"
				android:text="@string/sir_alex_ferguson" />
			<RadioButton
				android:id="@+id/rb_mou"
				android:layout_width="match_parent"
				android:layout_height="wrap_content"
				android:layout_marginBottom="16dp"
				android:text="@string/jose_mourinho" />
			<RadioButton
				android:id="@+id/rb_lvg"
				android:layout_width="match_parent"
				android:layout_height="wrap_content"
				android:layout_marginBottom="16dp"
				android:text="@string/louis_van_gaal" />
			<RadioButton
				android:id="@+id/rb_moyes"
				android:layout_width="match_parent"
				android:layout_height="wrap_content"
				android:layout_marginBottom="16dp"
				android:text="@string/david_moyes" />
		</RadioGroup>

		<LinearLayout
			android:layout_width="match_parent"
			android:layout_height="wrap_content"
			android:orientation="horizontal">
			<Button
				android:id="@+id/btn_close"
				style="?android:attr/buttonBarButtonStyle"
				android:layout_width="match_parent"
				android:layout_height="wrap_content"
				android:layout_marginEnd="4dp"
				android:layout_marginRight="4dp"
				android:layout_weight="0.5"
				android:text="@string/close" />
			<Button
				android:id="@+id/btn_choose"
				style="?android:attr/buttonBarButtonStyle"
				android:layout_width="match_parent"
				android:layout_height="wrap_content"
				android:layout_marginLeft="4dp"
				android:layout_marginStart="4dp"
				android:layout_weight="0.5"
				android:text="@string/choose" />
		</LinearLayout>

	</LinearLayout>
	```
- Pada `OptionDialogFragment` ubah turunan Fragment menjadi DialogFragment dan hapus kode yang tidak diperlukan
- Tambahkan inisialiasi view, casting, dan mengatur method setOnClickLIstener seperti dibawah ini
	```java
	public class OptionDialogFragment extends DialogFragment { // turunan DialogFragment
	
		// Inisialisasi variabel view
		Button btnChoose, btnClose;
		RadioGroup rgOptions;
		RadioButton rbSaf, rbMou, rbLvg, rbMoyes;
		OnOptionDialogListener optionDialogListener; // Interface untuk menghandle pilihan

		public OptionDialogFragment() {
			// Required empty public constructor
		}

		@Override
		public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
								Bundle savedInstanceState) {
			// Inflate the layout for this fragment
			return inflater.inflate(R.layout.fragment_option_dialog, container, false);
		}
		
		@Override
		public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
			super.onViewCreated(view, savedInstanceState);
			
			// Casting variable view
			btnChoose = view.findViewById(R.id.btn_choose);
			btnClose = view.findViewById(R.id.btn_close);
			rgOptions = view.findViewById(R.id.rg_options);
			rbSaf = view.findViewById(R.id.rb_saf);
			rbLvg = view.findViewById(R.id.rb_lvg);
			rbMou = view.findViewById(R.id.rb_mou);
			rbMoyes = view.findViewById(R.id.rb_moyes);

			btnChoose.setOnClickListener(v -> { // Menangkap pilihan saat tombol diklik
				int checkedRadioButtonId = rgOptions.getCheckedRadioButtonId();

				if (checkedRadioButtonId != -1) { // Ketika ada yang dipilih
					String coach = null;
					if (checkedRadioButtonId == R.id.rb_saf) { coach = rbSaf.getText().toString().trim(); }
					else if (checkedRadioButtonId == R.id.rb_mou) { coach = rbMou.getText().toString().trim(); }
					else if (checkedRadioButtonId == R.id.rb_lvg) { coach = rbLvg.getText().toString().trim(); }
					else if (checkedRadioButtonId == R.id.rb_moyes) { coach = rbMoyes.getText().toString().trim(); }

					if (optionDialogListener != null) { // Ketika ada yang dipilih
						optionDialogListener.onOptionChosen(coach); // Memasukkan parameter pada fungsi onOptionChosen
					}

					getDialog().dismiss(); // Untuk menutup dialog
				}

			});

			btnClose.setOnClickListener(v -> getDialog().cancel()); // Untuk membatalkan dan menutup dialog
		}

		@Override
		public void onAttach(Context context) { // Fungsi saat ODF dipanggil
			super.onAttach(context);

			Fragment fragment = getParentFragment(); // Mengambil DCF
	
			if (fragment instanceof DetailCategoryFragment) {
				DetailCategoryFragment detailCategoryFragment = (DetailCategoryFragment) fragment;
				this.optionDialogListener = detailCategoryFragment.optionDialogListener; // menghubungkan listener ODF dan DCF
			}
		}
	
		@Override
		public void onDetach() { // Fungsi saat ODF dimatikan
			super.onDetach();

			this.optionDialogListener = null; // Menghapus hubungan ODF untuk menghapus penggunaan memori
		}
	
		public interface OnOptionDialogListener { // Interface untuk menghandle ketika tombol Pilih diklik
			void onOptionChosen(String text);
		}
	}
	```
- Pada `DetailCategoryFragment` di method `onViewCreated `tambahkan kode untuk memanggil DialogFragment
	```java
	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		...
		
		btnShowDialog.setOnClickListener(v -> {
			FragmentManager mFragmentManager = getChildFragmentManager(); // Menginstansiasi FM dengan getChildFM
			OptionDialogFragment mOptionDialogFragment = new OptionDialogFragment(); // Menginstansiasi ODF
			mOptionDialogFragment.show(mFragmentManager, OptionDialogFragment.class.getSimpleName()); // Menampilkan ODF ke Layar menggunakan FM
		});
	}
	```
- Masih Pada `DetailCategoryFragment` tambahkan kode untuk Menampilkan Toast seperti berikut
	```java
	public class DetailCategoryFragment extends Fragment {
	
		...
		
		OptionDialogFragment.OnOptionDialogListener optionDialogListener = new OptionDialogFragment.OnOptionDialogListener() { // Menginstansiasi optionDialogListener
			@Override
			public void onOptionChosen(String text) {
				Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show(); // Melakukan override untuk menampilkan Toast
			}
		};
	}
	```

## Memanggil Activity Dari Fragment
- Buat Acativity baru, `klik kanan pada project -> New -> Activity -> Empty Acitivity`
- Setup Activity, name: `ProfileAcitivity`, layout name : `activity_profile`, dan pilih source language yang digunakan
- Atur `activity_profile.xml` seperti berikut:
	```xml
	<?xml version="1.0" encoding="utf-8"?>
	<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
		xmlns:tools="http://schemas.android.com/tools"
		android:layout_width="match_parent"
		android:layout_height="match_parent"
		android:padding="16dp">
	
		<TextView
			android:layout_width="match_parent"
			android:layout_height="wrap_content"
			android:text="@string/this_profile" />
	</RelativeLayout>
	```
- Pada `DetailCategoryFragment` tambahkan fungsi onClick untuk perpindah ke Activity
	```java
	@Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

		...

        btnProfile.setOnClickListener(v -> {
            Intent mIntent = new Intent(getActivity(), ProfileActivity.class); // Gunakan getActivity() untuk memanggil context Activity dari fragment
            startActivity(mIntent);
        });
    }
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