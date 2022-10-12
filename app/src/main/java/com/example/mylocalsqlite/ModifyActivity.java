package com.example.mylocalsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ModifyActivity extends AppCompatActivity {
    Button returnBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);

        returnBtn.findViewById(R.id.button_mreturn);

        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        showRecord(savedInstanceState);

    }

    private void showRecord(Bundle saveInstanceState){
        TextView id=findViewById(R.id.textId);
        TextView uname=findViewById(R.id.textUname);
        TextView pwd=findViewById(R.id.textPwd);

        Bundle data=getIntent().getExtras();
        id.setText("第"+data.getString("id")+"个记录");
        uname.setText(data.getString("uname"));
        pwd.setText(data.getString("pwd"));
    }
}