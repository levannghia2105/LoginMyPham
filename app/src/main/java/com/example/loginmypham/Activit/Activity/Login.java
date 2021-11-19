package com.example.loginmypham.Activit.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.UnicodeSet;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginmypham.R;

import java.util.ArrayList;

public class Login extends AppCompatActivity {
    ArrayList<User> userArrayList ;
    EditText edtUser , edtPassWord ;
    TextView txtLogin ;
    TextView txtRegister ;
    int dem = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        innit();
        anhXa();
        setUp();
        setClick();
    }
        private void innit() {
            userArrayList = new ArrayList<>();
            userArrayList.add(new User("0123","levannghia"));

        }
        private void anhXa() {
            edtUser = findViewById(R.id.edtUser);
            edtPassWord = findViewById(R.id.edtPassWord);
           txtLogin =(TextView) findViewById(R.id.txtLoginActivity);
           txtRegister = findViewById(R.id.txtRegister);
        }
        private void setUp() {

        }
        public void setClick() {
       txtLogin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String editUser = edtUser.getText().toString();
               String editPass = edtPassWord.getText().toString();

              if (editUser.matches("")||editPass.matches("")){
                  Toast.makeText(getApplicationContext(),"bạn phải nhập đầy đủ",Toast.LENGTH_LONG).show();
              }
              else {
                  for (User user : userArrayList){
                      if (editUser.contains(user.getUserName())&&editPass.contains(user.getPassWord())){
                          Intent intent = new Intent(Login.this,MainActivity.class);
                          startActivity(intent);
                          dem++;
                      }

                  }
                  if (dem ==0)

                      Toast.makeText(getApplicationContext(),"bạn nhập sai tên tài khoản mật khẩu",Toast.LENGTH_LONG).show();

              }
           }
       });
       txtRegister.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(Login.this,Register.class);
               startActivity(intent);
           }
       });
        }







    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        User user = (User) intent.getSerializableExtra("user");
        if (user==null){
            return;
        }
        else

        userArrayList.add(user);
    }
}