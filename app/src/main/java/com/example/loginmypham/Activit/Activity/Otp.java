package com.example.loginmypham.Activit.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginmypham.R;

public class Otp extends AppCompatActivity {
    EditText edt1 ,edt2 ,edt3,edt4 ;
    TextView txtXacNhan ,txtSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        edt3 = findViewById(R.id.edt3);
        edt4 = findViewById(R.id.edt4);
        txtSend = findViewById(R.id.txtSend);

        txtXacNhan = findViewById(R.id.txtXacNhan);
        Intent intent = getIntent();
        User user = (User) intent.getSerializableExtra("user");
        txtXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkEmpy(edt1)==true&&checkEmpy(edt2)==true&&checkEmpy(edt3)==true&&checkEmpy(edt4)==true){
                    Toast.makeText(getApplicationContext(),"bạn chưa nhập mã otp",Toast.LENGTH_LONG).show();

                }else {
                    Intent intent = new Intent(Otp.this,Success.class);

                    intent.putExtra("user" ,user);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),"đăng kí thành công",Toast.LENGTH_LONG).show();
                }
            }

        });
        txtSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetOtp(edt1,edt2,edt3,edt4);
            }
        });

    }
    private boolean checkEmpy(EditText edt){
        String editText = edt.getText().toString().trim();
        if (editText.length()>0){
            return false ;
        }
        else
            return true;
    }
    private void resetOtp(EditText edt1,EditText edt2,EditText edt3 ,EditText edt4){
        edt1.setText("");
        edt2.setText("");
        edt3.setText("");
        edt4.setText("");
    }
}