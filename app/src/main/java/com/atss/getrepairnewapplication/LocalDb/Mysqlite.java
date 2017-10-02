package com.atss.getrepairnewapplication.LocalDb;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DFMS1 on 11-Jan-17.
 */

public class Mysqlite extends SQLiteOpenHelper {
    public Mysqlite(Context context) {
        super(context, "contanctdb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table contact(_id integer primary key autoincrement,name varchar,address varchar,mobile varchar)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "contact");
        onCreate(db);
    }
    public Cursor getdetails(){
        SQLiteDatabase db=getReadableDatabase();
        return db.rawQuery("select rowid _id,* from contact",null);
    }
}
