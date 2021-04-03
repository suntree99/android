package com.example.cobaspeech;

import android.Manifest;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.speech.RecognizerIntent;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.example.cobaspeech.services.PermissionHandler;
import com.example.cobaspeech.services.SpeechRecognizerManager;
import java.util.ArrayList;

public class MainActivity extends Activity {
    private SpeechRecognizerManager mSpeechManager;
    private static final String TAG = MainActivity.class.getSimpleName();
    private Intent voiceService = null;
    private static final String WORD_TRIGGER = "kirim";
    private EditText numbertEdt, textEdt;
    private Button btnKirim;
    private String phoneNumber, text2Send;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if ((grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    Toast.makeText(getApplicationContext(), "Access has been granted.", Toast.LENGTH_SHORT).show();
                    getContacts();
                } else {
                    Toast.makeText(getApplicationContext(), "Access to contact must be allowed to use this feature!", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
        }
        if(PermissionHandler.checkPermission(this,PermissionHandler.RECORD_AUDIO)) {
            SetSpeechListener();
        } else {
            PermissionHandler.askForPermission(PermissionHandler.RECORD_AUDIO,this);
        }

        if(PermissionHandler.checkPermission(this,PermissionHandler.SEND_SMS)) {
            sendSMS(phoneNumber,text2Send);
        } else {
            PermissionHandler.askForPermission(PermissionHandler.SEND_SMS,this);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, 1);
            }else {
                getContacts();
            }
            if(checkSelfPermission(Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.RECORD_AUDIO},50);
            } else {
                SetSpeechListener();
            }
        } else {
            SetSpeechListener();
            getContacts();
        }
        btnKirim = (Button) findViewById(R.id.btnkirim);
        numbertEdt = (EditText) findViewById(R.id.nomorHp);
        textEdt = (EditText) findViewById(R.id.pesan);
        text2Send = textEdt.getText().toString();
        phoneNumber = numbertEdt.getText().toString();
        btnKirim.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text2Send.equals("") || phoneNumber.equals("")){
                    Toast.makeText(getApplicationContext(),"Pesan atau nomor tujuan belum ada",Toast.LENGTH_LONG).show();
                } else {
                    sendSMS(phoneNumber,text2Send);
                }
            }
        });
        ImageButton speechbtn = (ImageButton) findViewById(R.id.speechbtn);
        speechbtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "id-ID");
                try {
                    startActivityForResult(intent, 1);
                    EditText pesan = (EditText) findViewById(R.id.pesan);
                    pesan.setText("");
                } catch (ActivityNotFoundException a) {
                    Toast t = Toast.makeText(getApplicationContext(),"Perangkat Tidak Mendukung", Toast.LENGTH_SHORT);
                    t.show();
                }
            }
        });

//btnkontak
        ImageButton pickcontact = (ImageButton) findViewById(R.id.pickcontact);
        pickcontact.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "id-ID");
                try {
                    startActivityForResult(intent, 2);
                } catch (ActivityNotFoundException a) {
                    Toast.makeText(getApplicationContext(), "Perangkat Tidak Mendukung", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void SetSpeechListener() {
        mSpeechManager=new SpeechRecognizerManager(this, new
                SpeechRecognizerManager.onResultsReady() {
                    @Override
                    public void onResults(ArrayList<String> results) {
                        if(results!=null && results.size()>0) {
                            if(results.size()==1) {
                                mSpeechManager.destroy();
                                mSpeechManager = null;
                            } else {
                                StringBuilder sb = new StringBuilder();
                                if (results.size() > 5) {
                                    results = (ArrayList<String>) results.subList(0, 5);
                                }
                                for (String result : results) {
                                    sb.append(result).append("\n");
                                }
                                if (sb.toString().contains(WORD_TRIGGER)) {
                                    phoneNumber = numbertEdt.getText().toString();
                                    text2Send = textEdt.getText().toString();
                                    if (!(phoneNumber.equals("")) &&
                                            !(text2Send.equals(""))){
                                        numbertEdt.setText("");
                                        textEdt.setText("");
                                        Toast.makeText(getApplicationContext(),"Pesan Terkirim",Toast.LENGTH_LONG).show();
                                                sendSMS(phoneNumber,text2Send);
                                    } else {
                                        Toast.makeText(getApplicationContext(),"Pesan atau nomor tujuan belum ada",Toast.LENGTH_LONG).show();
                                    }
                                }
                            }
                        } else
                            Log.d(TAG,"Result not found");
                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> text = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    EditText pesan = (EditText) findViewById(R.id.pesan);
                    pesan.setText(text.get(0));
                    text2Send = text.get(0);
                }
                break;
            }
            case 2: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> text = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    Intent intent = new Intent(MainActivity.this, ContactListActivity.class);
                    intent.putExtra("stt", text.get(0));
                    startActivityForResult(intent, 100);
                }
                break;
            }
            case 3: {
                if (resultCode == RESULT_OK && null != data) {
                    Uri contactData = data.getData();
                    Cursor cursor = managedQuery(contactData, null, null, null,null);
                    cursor.moveToFirst();
                    String number = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    phoneNumber = number;
                    EditText nomorHp = (EditText) findViewById(R.id.nomorHp);
                    nomorHp.setText(number);
                }
                break;
            }
            case 100: {
                if (resultCode == RESULT_OK && null != data) {
                    Bundle extra = data.getExtras();
                    String number = extra.getString("notelp");
                    phoneNumber = number;
                    EditText nomorHp = (EditText) findViewById(R.id.nomorHp);
                    nomorHp.setText(number);
                }
                break;
            }
        }
    }

    public void getContacts() {
        DatabaseHelper mydb = new DatabaseHelper(this);
        mydb.emptyData();
        ContentResolver cr = getContentResolver();
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null,null, null);
        String prev_notelp = null;
        if (cur.getCount() > 0) {
            while (cur.moveToNext()) {
                String id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));
                String name = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                if
                (cur.getInt(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)) > 0) {
                    Cursor pCur = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" =?", new String[]{id}, null);
                    while (pCur.moveToNext()) {
                        String phoneNo = pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        if (!phoneNo.equals(prev_notelp)) {
                            mydb.insertData(name, phoneNo);
                            prev_notelp = phoneNo;
                        }
                    }
                    pCur.close();
                }
            }
        }
        mydb.close();
    }

    // sendSMS
    private void sendSMS(String phoneNumber, String message) {

        if(PermissionHandler.checkPermission(this,PermissionHandler.RECORD_AUDIO)) {
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(phoneNumber, null, message, null, null);
            Toast.makeText(getApplicationContext(), "SMS Berhasil dikirim", Toast.LENGTH_LONG).show();

            //(phoneNumber,text2Send);
        } else {
            PermissionHandler.askForPermission(PermissionHandler.RECORD_AUDIO,this);
        }
    }

    private boolean mIsBound;

    @Override
    protected void onPause() {
        if(mSpeechManager!=null) {
            mSpeechManager.destroy();
            mSpeechManager=null;
        }
        super.onPause();
    }
    @Override
    protected void onResume() {
        if (mSpeechManager == null) SetSpeechListener();
        super.onResume();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
    private class resumeVoiceCommand extends AsyncTask<Void,Void,Void> {
        @Override
        protected Void doInBackground(Void... params) {
            if (mSpeechManager == null) {
                SetSpeechListener();
            }
            return null;
        }
    }
}