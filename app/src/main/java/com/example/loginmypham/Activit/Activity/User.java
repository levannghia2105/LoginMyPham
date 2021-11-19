package com.example.loginmypham.Activit.Activity;

import android.content.Context;
import android.widget.Toast;

import java.io.Serializable;

public class User implements Serializable {
    private String userName;
    private String passWord ;
    Context mContext ;



    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;


    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    private void  checkUser(){
        if (userName==""||passWord==""){
            Toast.makeText(mContext,"bạn phải nhập đẩy đủ họ tên ",Toast.LENGTH_LONG).show();
        }

}
}
