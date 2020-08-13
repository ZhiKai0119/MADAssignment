package com.example.madassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class signUp extends AppCompatActivity {

    private EditText name, email, password, confirmPwd;
    private TextView goLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name = (EditText) findViewById(R.id.name_insert);
        email = (EditText) findViewById(R.id.email_insert);
        password = (EditText) findViewById(R.id.password_insert);
        confirmPwd = (EditText) findViewById(R.id.password_insert_2);

        goLogin = (TextView) findViewById(R.id.Go_Login);
        goLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(signUp.this, Login.class));
            }
        });
    }
}