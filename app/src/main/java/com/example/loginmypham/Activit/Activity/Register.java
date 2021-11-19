package com.example.loginmypham.Activit.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginmypham.R;

import java.util.ArrayList;

public class Register extends AppCompatActivity {
EditText edtUser , edtPass , edtPassEnter , edtPhoneName ;
TextView txtRegister ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        innit();
        anhXa();
        setUp();
        setClick();
    }

    private void setClick() {
        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = edtPhoneName.getText().toString().trim();
                String passWord = edtPass.getText().toString().trim();
//                String passEnter = edtPassEnter.getText().toString().trim();
//                String phoneName = edtPhoneName.getText().toString().trim();
                if (checkEmpy(edtUser)==true||checkEmpy(edtPass)==true||checkEmpy(edtPassEnter)==true||checkEmpy(edtPhoneName)==true){
                    Toast.makeText(getApplicationContext(),"bạn phải nhập đủ các trường ",Toast.LENGTH_LONG).show();

                }
                else{
                    if (checkPass(edtPass,edtPassEnter)==false){
                        Toast.makeText(getApplicationContext(),"mật khẩu bạn nhập không trùng khớp",Toast.LENGTH_LONG).show();

                    }
                    else {
                        Intent intent = new Intent(Register.this,Otp.class);
                        User user = new User(userName,passWord);
                        intent.putExtra("user" ,user);
                        startActivity(intent);
                    }
                }
            }
        });
    }

    private void setUp() {
    }

    private void anhXa() {
        edtUser = findViewById(R.id.editText);
        edtPass = findViewById(R.id.edtPassRegister);
        edtPassEnter = findViewById(R.id.editText3);
        edtPhoneName = findViewById(R.id.edtPhoneName);
        txtRegister = findViewById(R.id.btnRegister);
    }

    private void innit() {
    }
    private boolean checkPass(EditText edt1,EditText edt2){
        String pass1 = edt1.getText().toString().trim();
        String pass2 = edt2.getText().toString().trim();
        if (pass1.equals(pass2)==true){
            return true ;
        }
        else
            return false ;
    }
    private boolean checkEmpy(EditText edt){
       String editText = edt.getText().toString().trim();
       if (editText.length()>0){
           return false ;
       }
       else
           return true;
    }
}