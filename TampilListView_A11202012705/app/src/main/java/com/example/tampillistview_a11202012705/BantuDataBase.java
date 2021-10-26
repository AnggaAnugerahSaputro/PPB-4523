package com.example.tampillistview_a11202012705;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BantuDataBase extends SQLiteOpenHelper {


    public static final String DATABASE_BUAH = "db_buah";
    private static final String TABEL_BUAH= "tabel_buah";
    public static final String KODE = "kode";
    private static final String NAMA_BUAH = "nm_buah";


    public BantuDataBase(@Nullable Context context) {
        super(context, DATABASE_BUAH, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String nama_tabel="create table"+TABEL_BUAH+ "(" + KODE + " ineger primary key autoincrement," + NAMA_BUAH + " text)";
        db.execSQL(nama_tabel);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public boolean TambahData(String namabuah)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(NAMA_BUAH);

        long hasil=db.insert(TABEL_BUAH,null,contentValues);
        return hasil != -1;
    }
    public void tampilBuah()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String sql="select * from"+TABEL_BUAH;
        Cursor cursor=db.rawQuery(sql,null);
    }
    public boolean hapusRecord(String id)
    {
        TampilListview_A11202012705.editText.setText(""+id);
        SQLiteDatabase db:this.getWritableDatabase();
        boolean hasil=db.delete(TABEL_BUAH,KODE+"="+id,null)>0;
    }

}
