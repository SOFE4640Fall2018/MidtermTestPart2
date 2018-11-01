package com.example.sofe4640.midtermtestpart2;
/*
This class is used to create, maniplate users data
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyDBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERVION =1;
    private static final String DATABASE_NAME = "users2.db";
    private static final String TABLE_NAME = "users";
    private static final String COL_1 = "id";
    private static final String COL_2 = "userName";

    public MyDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERVION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + "(" +
                COL_1 + " Integer PRIMARY KEY AUTOINCREMENT," +
                COL_2 +  " Text NOT NULL" +")" + ";" ;
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table " + TABLE_NAME + ";" );
        this.onCreate(db);
    }

    public void addRecord(Users user){
        ContentValues values= new ContentValues();
        values.put(COL_2,user.getName());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    public  String searchForUser(String name){
        String result="";
        SQLiteDatabase db = getWritableDatabase();
        String query ="  Select distinct * from " + TABLE_NAME + " where " + COL_2 + "='" + name +"';";
        Log.d("test","addRecord: " + query);
        Cursor c = db.rawQuery(query,null);
        c.moveToFirst();
        //result = c.getString(c.getColumnIndex(COL_2));
        while(!(c.isAfterLast())){
            result += c.getString(c.getColumnIndex(COL_2));
            result+= " \n ";
            c.moveToNext();        }
        db.close();
        return result;
    }

    public void deteleRows( ) {
        SQLiteDatabase db = getWritableDatabase();
        String deleterows = "delete from " + TABLE_NAME + ";" ;
        db.execSQL(deleterows);
        db.close();
    }

}
