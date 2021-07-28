package com.sefa.kpsscepkitabi2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class verilerdao {

    public void kelimeekle(veritabaniyardim vt,int eklendigikutuu,int unitesii,String bilgikendisi){
        SQLiteDatabase dbx= vt.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("eklendigi_kutu",eklendigikutuu);
        values.put("unitesi",unitesii);
        values.put("bilgi_kendi",bilgikendisi);

        dbx.insertOrThrow("veriler2",null,values);
        dbx.close();

    }
    public ArrayList<userlists>tumbilgiler(veritabaniyardim vt){
        ArrayList<userlists>bilgilerarraylist=new  ArrayList<>();
        SQLiteDatabase dbx=vt.getReadableDatabase();
        Cursor c=dbx.rawQuery("SELECT * FROM veriler2",null);


        while (c.moveToNext()){
            userlists userlists3=new userlists(c.getInt(c.getColumnIndex("eklendigi_kutu")),
                    c.getInt(c.getColumnIndex("unitesi")),
                    c.getString(c.getColumnIndex("bilgi_kendi")));
            bilgilerarraylist.add(userlists3);
        }

        return bilgilerarraylist;
    }


    public void kelimesil(veritabaniyardim vt,int a,int a2,String a3){
        SQLiteDatabase dbx=vt.getWritableDatabase();
        dbx.delete("veriler2","eklendigi_kutu=? and unitesi=? and bilgi_kendi=?",new String[]{String.valueOf(a),String.valueOf(a2),String.valueOf(a3)});


    }

    public void kelimguncelle(veritabaniyardim vt,int eklendigikutuu,int unitesii,String bilgikendisi){
        SQLiteDatabase dbx= vt.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("eklendigi_kutu",eklendigikutuu);
        values.put("unitesi",unitesii);
        values.put("bilgi_kendi",bilgikendisi);

        //dbx.update("veriler2","eklendigi_kutu and unitesi=? and unitesi=? and bilgi_kendi=?",new String[]{String.valueOf(eklendigikutuu),String.valueOf(unitesii),String.valueOf(bilgikendisi)});

        dbx.close();

    }
}
