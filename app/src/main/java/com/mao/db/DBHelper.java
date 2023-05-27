package com.mao.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private final String db_name ;
    private final String db_structure;
    private final int db_version;
    public DBHelper(Context context, String  db_name, String dbStructure, int db_version) {
        super(context, db_name, null, db_version);
        this.db_name=db_name;
        this.db_structure = dbStructure;
        this.db_version=db_version;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+this.db_structure);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void execSQL(String sql,Object[] params){
        SQLiteDatabase db = getWritableDatabase();
        if(params!=null){
            db.execSQL(sql, params);
        }else {
            db.execSQL(sql);
        }
        db.close();
    }
    public Cursor query(String sql,String[] params){
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery(sql,params);
    }
}