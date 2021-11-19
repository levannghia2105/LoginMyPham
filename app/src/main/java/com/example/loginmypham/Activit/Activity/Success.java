package com.example.loginmypham.Activit.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.loginmypham.R;

public class Success extends AppCompatActivity {
TextView txtSucces ;
    User user ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        txtSucces = findViewById(R.id.txtSuccess);
        Intent intent = getIntent();
       user = (User) intent.getSerializableExtra("user");
        txtSucces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Success.this,Login.class);
                intent.putExtra("user",user);
                startActivity(intent);

            }
        });


    }
}