package com.example.mylocalsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultipleListViewActivity extends AppCompatActivity {
    Button btnReturn=null;
    Button btnQuery=null;

    private ListView listView;
    private List<Map<String,Object>> userList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_list_view);

        btnQuery=findViewById(R.id.button_mquery);
        btnReturn=findViewById(R.id.button_mreturn);

        //返回
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap map;

                for(int i=0;i<10;i++){
                    map=new HashMap();
                    map.put("uname","xx"+i);
                    map.put("pwd",""+i);
                    userList.add(map);
                }

                initView(userList);
            }
        });

    }
    private void initView(List userList){
        listView=(ListView)findViewById(R.id.mlist_item);
        UserAdapter adapter=new UserAdapter(MultipleListViewActivity.this,R.layout.activity_list_item,userList);
        listView.setAdapter(adapter);
    }
}