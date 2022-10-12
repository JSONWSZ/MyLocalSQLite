package com.example.mylocalsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class SimpleListViewActivity extends AppCompatActivity {

    Button btnReturn=null;
    Button btnQuery=null;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list_view);

        btnQuery=findViewById(R.id.btn_query);
        btnReturn=findViewById(R.id.btn_return);


        //返回
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //展示数据
        btnQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("查询");
                //要展示的列表
                String[] strArr=new String[] {"A","B","C","D","E"};

                listView=(ListView) findViewById(R.id.list_item);

                ArrayAdapter<String> adapter=new ArrayAdapter<>(SimpleListViewActivity.this, android.R.layout.simple_list_item_1,strArr);

                listView.setAdapter(adapter);
            }
        });
    }
}