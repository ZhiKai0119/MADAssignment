package com.example.madassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signUp extends AppCompatActivity {

    private EditText mname, memail, mpassword, mconfirmPwd;
    private Button btnSignUp;
    private TextView goLogin;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mname = (EditText) findViewById(R.id.name_insert);
        memail = (EditText) findViewById(R.id.email_insert);
        mpassword = (EditText) findViewById(R.id.password_insert);
        mconfirmPwd = (EditText) findViewById(R.id.password_insert_2);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        goLogin = (TextView) findViewById(R.id.Go_Login);

        mAuth = FirebaseAuth.getInstance();
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                mUser = firebaseAuth.getCurrentUser();

                if (mUser != null) {
                    Toast.makeText(signUp.this, "Signed In", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(signUp.this, MainPage.class));
                    finish();
                }else {
                    Toast.makeText(signUp.this, "Not Signed In", Toast.LENGTH_LONG).show();
                }
            }
        };

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = memail.getText().toString().trim();
                String password = mpassword.getText().toString().trim();
                String confirmPwd = mconfirmPwd.getText().toString().trim();

                if(TextUtils.isEmpty(email)) {
                    memail.setError("Email is Enquired!");
                    return;
                }
                if(TextUtils.isEmpty(password)) {
                    mpassword.setError("Password is required!");
                    return;
                }
                if (TextUtils.isEmpty(confirmPwd)) {
                    mconfirmPwd.setError("Confirm Password is Required!");
                    return;
                }
                if(password.length() < 6) {
                    mpassword.setError("Password Must be >= 6 Characters!");
                    return;
                }
                if(!password.equals(confirmPwd)) {
                    mconfirmPwd.setError("Password Don't Match");
                    mpassword.setError("Password Don't Match");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);

                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(signUp.this, "User Created.", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(signUp.this, MainPage.class));
                        }else {
                            Toast.makeText(signUp.this, "Error!!!" + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });


        goLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(signUp.this, Login.class));
            }
        });
    }
}