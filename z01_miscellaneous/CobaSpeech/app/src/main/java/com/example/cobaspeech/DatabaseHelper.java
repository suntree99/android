package com.example.cobaspeech;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "tts_indo";
    public static final String TABLE_NAME = "kontak";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAMA = "nama";
    public static final String COLUMN_NOTELP = "notelp";
    private static final int DB_VERSION = 1;
    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME
                + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NAMA + " VARCHAR, "
                + COLUMN_NOTELP + " VARCHAR);";
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);
    }
    public void insertData(String nama, String notelp){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAMA, nama);
        contentValues.put(COLUMN_NOTELP, notelp);
        db.insert(TABLE_NAME, null, contentValues);
// db.close();
// return true;
    }
    public Cursor getDataById(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + " = "
                + id + ";";
        return db.rawQuery(sql, null);
    }
    public ArrayList<ContactListModel> getAllData(String nama) {
        ArrayList<ContactListModel> array_list = new ArrayList<>();
// hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery( "SELECT * FROM " + TABLE_NAME + " WHERE IFNULL(" + COLUMN_NAMA +", '') LIKE '%" + nama + "%' ORDER BY " + COLUMN_ID + " ASC",
                        null);
        res.moveToFirst();
        while(!res.isAfterLast()){
            ContactListModel row = new
                    ContactListModel(res.getString(res.getColumnIndex(COLUMN_NAMA)),
                    res.getString(res.getColumnIndex(COLUMN_NOTELP)));
            array_list.add(row);
            res.moveToNext();
        }
        res.close();
        return array_list;
    }
    public void emptyData() {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "DELETE FROM " + TABLE_NAME + ";";
        db.rawQuery(sql, null);
    }
}
