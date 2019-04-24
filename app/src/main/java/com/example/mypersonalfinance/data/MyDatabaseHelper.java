package com.example.mypersonalfinance.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.mypersonalfinance.model.Thunhap;

import java.util.ArrayList;
import java.util.List;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "SQLite";
    private static final int DATABASE_VERSION = 1;
    private Context context;
    private static final String DATABASE_NAME = "thunhap1.db";



    private static final String CREAT_TABLE_THUNHAP = "CREATE TABLE Thu_nhap(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(200), tien INTEGER, ghi_chu VARCHAR(200), ngay VARCHAR(200), icon INTEGER)";

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAT_TABLE_THUNHAP);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS Thu_nhap");
    }

    public boolean addThunhap(Thunhap thunhap) {
        try{
            Log.i(TAG, "MyDatabaseHelper.addThunhap" + thunhap.getThunhap_name());
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("name", thunhap.getThunhap_name());
            values.put("tien", thunhap.getThunhap_tien());
            values.put("ngay", thunhap.getThunhap_ngay());
            values.put("ghi_chu", thunhap.getThunhap_ghichu());
            values.put("icon", thunhap.getThunhap_icon());
            Long i = db.insert("Thu_nhap", null, values);
            db.close();
            return i > 0 ? true: false;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public Thunhap getThunhap(int id) {
        Log.i(TAG, "MyDatabaseHelper.getThunhap" + id);
        SQLiteDatabase db = this.getReadableDatabase();
        String sql= "SELECT * FROM Thu_nhap WHERE id ="+id;
        Cursor cursor = db.rawQuery(sql,null);
        if (cursor != null) cursor.moveToFirst();
        Thunhap thunhap = new Thunhap(cursor.getString(1), Integer.parseInt(cursor.getString(2)), cursor.getString(3), cursor.getString(4), Integer.parseInt(cursor.getString(5)));
        cursor.close();
        db.close();
        return thunhap;
    }

    public ArrayList<Thunhap> getAllThunhap() {
        Log.i(TAG, "MyDatabaseHelper.getAllThunhap");
        ArrayList<Thunhap> thunhapList = new ArrayList<Thunhap>();
        String selectQuery = "SELECT  * FROM Thu_nhap";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        //duyet con tro va them vao danh sach
        if (cursor.moveToFirst()) {
            do {
                Thunhap thunhap = new Thunhap();
                thunhap.setThunhap_id(cursor.getString(0));
                thunhap.setThunhap_name(cursor.getString(1));
                thunhap.setThunhap_tien(Integer.parseInt(cursor.getString(2)));
                thunhap.setThunhap_ngay(cursor.getString(3));
                thunhap.setThunhap_ghichu(cursor.getString(4));
                thunhap.setThunhap_icon(Integer.parseInt(cursor.getString(5)));
                thunhapList.add(thunhap);
            } while ((cursor.moveToNext()));

        }
        return thunhapList;
    }

//    public int getThunhapCount() {
//        Log.i(TAG, "MyDatabaseHelper.getTunhapCount");
//        String countQuery = "SELECT * FROM " + TABLE_THUNHAP;
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(countQuery, null);
//        int count = cursor.getCount();
//        cursor.close();
//        return count;
//    }

    public int updateThunhap(Thunhap thunhap) {
        Log.i(TAG, "MyDatabaseHelper.updateThunhap");
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", thunhap.getThunhap_name());
        values.put("tien", thunhap.getThunhap_tien());
        values.put("ngay", thunhap.getThunhap_ngay());
        values.put("ghi_chu", thunhap.getThunhap_ghichu());
        values.put("icon", thunhap.getThunhap_icon());
        return db.update("Thu_nhap", values,  thunhap.getThunhap_id(), new String[]{String.valueOf(thunhap.getThunhap_id())});
    }
}
