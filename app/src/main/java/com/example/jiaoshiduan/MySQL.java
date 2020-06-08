package com.example.jiaoshiduan;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MySQL extends SQLiteOpenHelper {
    private SQLiteDatabase sql;
    public MySQL(Context context){
        super(context,"db_test",null,6);
        sql = getReadableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase sql) {
        sql.execSQL("CREATE TABLE IF NOT EXISTS book("+
                "_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "name TEXT,"+
                "type TEXT,"+
                "rank TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sql, int oldVersion, int newVersion) {
        sql.execSQL("DROP TABLE IF EXISTS book");
        onCreate(sql);

    }
    public void add(String name,String type,String rank){
        sql.execSQL("INSERT INTO book (name,type,rank) VALUES(?,?,?)",new Object[]{name,type,rank});
    }
    public void delete(String name,String type,String rank){
        sql.execSQL("DELETE FROM book WHERE name = AND type=AND rank ="+name+type+rank);
    }
    public void updata(String type){
        sql.execSQL("UPDATE book SET type = ?",new Object[]{type});
    }
    public ArrayList<Book> getAllData(){

        ArrayList<Book> list = new ArrayList<Book>();
        Cursor cursor = sql.query("book",null,null,null,null,null,"name DESC");
        while(cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String type = cursor.getString(cursor.getColumnIndex("type"));
            String rank = cursor.getString(cursor.getColumnIndex("rank"));
            list.add(new Book(name,type,rank));
        }
        return list;
    }
}