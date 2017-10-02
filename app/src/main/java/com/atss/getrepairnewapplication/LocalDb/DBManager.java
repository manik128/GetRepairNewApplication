package com.atss.getrepairnewapplication.LocalDb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by DFMS1 on 24-Jan-17.
 */

public class DBManager {
    private Mysqlite dbHelper;

    private Context context;

    private SQLiteDatabase database;

    public DBManager(Context c) {
        context = c;
    }

    public DBManager open() throws SQLException {
        dbHelper = new Mysqlite(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String name, String desc,String mobile) {
        ContentValues contentValue = new ContentValues();
        contentValue.put("name", name);
        contentValue.put("address", desc);
        contentValue.put("mobile",mobile);
        database.insert("contact", null, contentValue);
    }

    public Cursor fetch() {
        String[] columns = new String[] { "_id", "name", "address","mobile"};
        Cursor cursor = database.query("contact", columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(long _id, String name, String desc,String mobile) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("address", desc);
        contentValues.put("mobile",mobile);
        int i = database.update("contact", contentValues,"_id" + " = " + _id, null);
        return i;
    }

    public void delete(long _id) {
        database.delete("contact", "_id" + "=" + _id, null);
    }
}
