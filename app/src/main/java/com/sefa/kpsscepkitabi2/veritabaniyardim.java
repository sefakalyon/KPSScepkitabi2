package com.sefa.kpsscepkitabi2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class veritabaniyardim extends SQLiteOpenHelper {

    public veritabaniyardim(Context context) {
        super(context, "sefa2", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE veriler2 (eklendigi_kutu INTEGER,unitesi INTEGER,bilgi_kendi TEXT);");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS  sefa2");
        onCreate(db);

    }
}
