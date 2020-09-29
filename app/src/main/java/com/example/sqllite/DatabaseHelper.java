package com.example.sqllite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteDatabase {
    public DatabaseHelper(Context context){
        super(context,"LoginSQLite.db",null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE session(id integer PRIMARY KEY, login text)");
        db.execSQL("CREATE TABLE user(id integer PRIMARY KEY AUTOINCREMENT, username text, password text)");
        db.execSQL("INSERT INTO session, login) VALUES(1, "kosong")");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS session");
        db.execSQL("DROP TABLE IF EXISTS user");
        onCreate(db);
    }

    public Boolean checkSession(String sessionValues){
        SQLiteDatabase db = this.getReadablaDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM session WHERE login = ?", new String[]{sessionValues});
        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }
    public Boolean  upgradeSession(String sessionValues, int id){
        SQLiteDatabase db = this.getWriteablaDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("login", sessionValues);
        long update = db.update("session", conventValues, "id="+id, null);
        if(update ==-1){
            return false;
        }
        else{
            return false;
        }
    }

    public Boolean insertUser(String username, String password){
        SQLiteDatabase db = this.getWriteableDatabase();
        ConventValues conventValues = new ConventValues();
        contentValues.put("username",username);
        contentValues.put("password", password);
        longinsert = db.insert("user", null, contentValues);
        if(insert == -1){
            return false;
        }
        else{
            return true;
        }

    }
    public Boolean checkLogin(String username, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT*FROM user WHERE username = ? AND password = ?", new String[]{username, password});
        if(cursor.getCount() > 0){
            return true;
        }
        else{
            return false;
        }
    }

}
