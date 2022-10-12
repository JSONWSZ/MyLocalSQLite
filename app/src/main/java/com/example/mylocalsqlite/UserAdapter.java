package com.example.mylocalsqlite;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserAdapter extends ArrayAdapter {
    private Activity context;
    private final int resourceId;
    private LayoutInflater mInflater;
    private List<Map<String,Object>> userList=new ArrayList<>();
    private Button btnDelete;



    public UserAdapter(@NonNull Activity context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.context=context;

        this.resourceId = resource;
        this.userList=objects;
        this.mInflater=LayoutInflater.from(context);
    }


    public class ViewHolder{
        public int id;
        public ImageView img;
        public TextView uname;
        public TextView pwd;
        public Button btnDelete;
        public Button btnModify;
    }

    public View getView(int position , View convertView  , ViewGroup parent  ){
        ViewHolder holder=null;
        if(convertView==null){
            holder=new ViewHolder();
            convertView=mInflater.inflate(R.layout.activity_list_item,null);
            holder.img=(ImageView)convertView.findViewById(R.id.imageView);
            holder.uname=(TextView)convertView.findViewById(R.id.edit_uname);
            holder.pwd=(TextView)convertView.findViewById(R.id.edit_pwd);
            holder.btnDelete=(Button)convertView.findViewById(R.id.button_delete);
            holder.btnModify=(Button)convertView.findViewById(R.id.button_modify);
            convertView.setTag(holder);
        }else {
            holder=(ViewHolder)convertView.getTag();
        }

        Map map=(Map)userList.get(position);
        holder.id=position;
        holder.uname.setText((String)map.get("uname"));
        holder.pwd.setText((String)map.get("pwd"));

        ViewHolder userRecord=holder;

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDeleteInfo(userRecord);
            }
        });

        holder.btnModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goModify(userRecord);
            }
        });

        return  convertView;
    }

    public void showDeleteInfo(ViewHolder record){
        AlertDialog.Builder builder=new AlertDialog.Builder(context);
        builder.setTitle("即将删除确认");
        builder.setMessage("你即将删除的记录[第"+record.id+"]"+"用户名是"+record.uname.getText().toString()+"密码是"+record.pwd.getText().toString());

        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        final AlertDialog show=builder.show();
    }

    private void goModify(ViewHolder userRecord){
        Intent intent=new Intent(context,ModifyActivity.class);
        Bundle bundle=new Bundle();
        bundle.putString("id",String.valueOf(userRecord.id));
        bundle.putString("uname",userRecord.uname.getText().toString());
        bundle.putString("pwd",userRecord.pwd.getText().toString());
        intent.putExtras(bundle);
        context.startActivity(intent);

    }


}
