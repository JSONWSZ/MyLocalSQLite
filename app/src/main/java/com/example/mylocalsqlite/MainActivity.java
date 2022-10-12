package com.example.mylocalsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText uname,psw;
    Button add,del,modi,sel;
    TextView content;
    Button btnlist=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uname=findViewById(R.id.uname);
        psw=findViewById(R.id.psw);
        add=findViewById(R.id.add);
        del=findViewById(R.id.del);
        modi=findViewById(R.id.modi);
        sel=findViewById(R.id.sel);
        content=findViewById(R.id.content);

        btnlist=findViewById(R.id.button_list);
        //DB db=new DB(this);

        MyDao db=new MyDao();

        //增
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n=uname.getText().toString();
                String p=psw.getText().toString();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            db.add(n,p);

                            Looper.prepare();
                            Toast.makeText(MainActivity.this,"添加成功",Toast.LENGTH_SHORT).show();
                            Looper.loop();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                }).start();
            }
        });

        //改
        modi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n=uname.getText().toString();
                String p=psw.getText().toString();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            db.modi(n,p);
                            Looper.prepare();
                            Toast.makeText(MainActivity.this,"修改成功",Toast.LENGTH_SHORT).show();
                            Looper.loop();
                        } catch (SQLException throwables) {

                            throwables.printStackTrace();
                        }
                    }
                }).start();




            }
        });

        //删
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n=uname.getText().toString();
                String p=psw.getText().toString();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            db.del(n);
                            Looper.prepare();
                            Toast.makeText(MainActivity.this,"删除成功",Toast.LENGTH_SHORT).show();
                            Looper.loop();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                }).start();



            }
        });

        //查
        sel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            db.sel();
                            Looper.prepare();
                            Toast.makeText(MainActivity.this,"查询成功",Toast.LENGTH_SHORT).show();
                            Looper.loop();
                        } catch (SQLException throwables) {

                            throwables.printStackTrace();
                        }
                    }
                }).start();



            }
        });


        //跳转
        btnlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ListMenuActivity.class);
                startActivity(intent);
            }
        });
    }
}