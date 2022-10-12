package com.example.mylocalsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ListMenuActivity extends AppCompatActivity {
    Button btnSimpleListView;
    Button btnMultipleListView;
    Button btnReturn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_menu);

        btnSimpleListView=findViewById(R.id.btn_simple_listview);
        btnMultipleListView=findViewById(R.id.btn_multiple_listview);
        btnReturn=findViewById(R.id.button_mreturn);

        //返回
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //跳转到简单列表
        btnSimpleListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ListMenuActivity.this,SimpleListViewActivity.class);
                startActivity(intent);
            }
        });

        //跳转到复杂列表
        btnMultipleListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ListMenuActivity.this,MultipleListViewActivity.class);
                startActivity(intent);
            }
        });
    }
}