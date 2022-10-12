package com.example.mylocalsqlite;

public class User {
    String uname;
    String psw;
    public User(String name,String psw){
        this.uname=name;
        this.psw=psw;
    }

    @Override
    public String toString() {
        return uname + ',' +psw ;
    }
}
