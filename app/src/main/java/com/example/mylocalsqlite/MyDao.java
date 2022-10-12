package com.example.mylocalsqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class MyDao {

    //获取连接
    String url="jdbc:mysql://172.31.224.1:3306/db?useSSL=false";
    String username = "";
    String password = "";





    //增
    public void add(String uname,String psw) throws SQLException {
        Connection conn= DriverManager.getConnection(url,username,password);
        //获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();
        String sql="insert into users values ("+"'"+uname+"'"+","+"'"+psw+"'"+")";
        int i=stmt.executeUpdate(sql);

        stmt.close();
        conn.close();

        if(i>0){
            Log.d("","插入成功");
        }else {
            Log.d("","插入失败");
        }

    }

    //删
    public void del(String uname) throws SQLException {
        Connection conn= DriverManager.getConnection(url,username,password);
        //获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();

        String sql="delete from users where uname='"+uname+"'";
        int i=stmt.executeUpdate(sql);

        stmt.close();
        conn.close();

        if(i>0){
            Log.d("","删除成功");
        }else {
            Log.d("","删除失败");
        }
    }

    //改
    public void modi(String uname,String NewPsw) throws SQLException {
        Connection conn= DriverManager.getConnection(url,username,password);
        //获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();

        String sql="update users set psw='"+NewPsw+"'"+"where uname='"+uname+"'";
        int i=stmt.executeUpdate(sql);

        stmt.close();
        conn.close();

        if(i>0){
            Log.d("","修改成功");
        }else {
            Log.d("","修改成功");
        }
    }

    //查
    public void sel() throws SQLException {

        Connection conn= DriverManager.getConnection(url,username,password);
        //获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();

        String sql="select * from users";
        ResultSet rs=stmt.executeQuery(sql);



        while (rs.next()){
            String uname=rs.getString("uname");
            String psw=rs.getString("psw");
            User user=new User(uname,psw);
            System.out.println(user);
        }
        stmt.close();
        conn.close();


    }

}
