package com.example.mylocalsqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DB extends SQLiteOpenHelper {
    public DB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="create table users( uname varchar(10) primary key , psw varchar(10) not null )";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private SQLiteDatabase db;
    public DB(Context context){
        super(context,"test",null,1);
        db=this.getWritableDatabase();
    }

    //增
    public boolean add(String uname,String psw){
        ContentValues values=new ContentValues();
        values.put("uname",uname);
        values.put("psw",psw);
        long i=db.insert("users",null,values    );

        if(i>0){
            Log.d("","插入成功");
            return true;
        }else {
            return false;
        }
    }

    //删
    public boolean del(String uname){
        long i=db.delete("users","uname=?",new String []{uname});
        if(i>0){
            Log.d("","删除成功");
            return true;
        }else {
            return false;
        }
    }

    //改
    public boolean modi(String uname,String NewPsw){
        ContentValues values=new ContentValues();
        values.put("psw",NewPsw);
        long i=db.update("users",values,"uname=?",new String[]{uname});

        if(i>0){
            Log.d("","修改成功");
            return true;
        }else {
            return false;
        }
    }
    //查
    public ArrayList sel(){
        ArrayList array=new ArrayList();
        Cursor cursor=db.query("users",null,null,null,null,null,null);
        while (cursor.moveToNext()){
           @SuppressLint("Range") String uname=cursor.getString(cursor.getColumnIndex("uname"));
            @SuppressLint("Range") String psw=cursor.getString(cursor.getColumnIndex("psw"));
            User user=new User(uname,psw);
            array.add(user);
        }
        return array;
    }


}
