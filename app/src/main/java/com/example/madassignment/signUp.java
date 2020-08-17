package com.example.madassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class signUp extends AppCompatActivity {

    private EditText mname, memail, mpassword, mconfirmPwd;
    private Button btnSignUp;
    private TextView goLogin;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseUser mUser;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mDatabaseReference;

//    private FirebaseFirestore mStore;
//    private String userId;
    private static final String TAG = "signUp";

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
        mDatabase  =FirebaseDatabase.getInstance();
        mDatabaseReference = mDatabase.getReference().child("Users");

//        mStore = FirebaseFirestore.getInstance();
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
                String Name = mname.getText().toString().trim();

                if(TextUtils.isEmpty(Name)) {
                    mname.setError("Name is Required!");
                    return;
                }
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

//                mAuth.createUserWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
//                    @Override
//                    public void onSuccess(AuthResult authResult) {
//                        if (authResult != null) {
//                            String userId = mAuth.getCurrentUser().getUid();
//                            DatabaseReference currentUserDb = mDatabaseReference.child(userId);
//                            currentUserDb.child("Name").setValue(mname);
//                            currentUserDb.child("Email").setValue(memail);
//                            currentUserDb.child("Image").setValue("none");
//
//                            Intent intent = new Intent(signUp.this, MainPage.class);
//                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                            startActivity(intent);
//
//                        }else {
//                            Toast.makeText(signUp.this, "Error!!!", Toast.LENGTH_LONG).show();
//                            progressBar.setVisibility(View.GONE);
//                        }
//                    }
//                });

                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            FirebaseUser laccUser = mAuth.getCurrentUser();
                            laccUser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(signUp.this, "Verification Email Has Been Sent.", Toast.LENGTH_LONG).show();
                                    mname.setText("");
                                    memail.setText("");
                                    mpassword.setText("");
                                    mconfirmPwd.setText("");
                                    startActivity(new Intent(signUp.this, Login.class));
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG, "onFailure: Email not sent" + e.getMessage());
                                }
                            });


//                            Toast.makeText(signUp.this, "User Created.", Toast.LENGTH_LONG).show();
//                            userId = mAuth.getCurrentUser().getUid();
//                            DocumentReference documentReference = mStore.collection("users").document(userId);
//                            Map<String, Object> user = new HashMap<>();
//                            user.put("Name", mname);
//                            user.put("email", memail);
//                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
//                                @Override
//                                public void onSuccess(Void aVoid) {
//                                    Log.d(TAG, "onSuccess: user profile is created for " + userId);
//                                }
//                            }).addOnFailureListener(new OnFailureListener() {
//                                @Override
//                                public void onFailure(@NonNull Exception e) {
//                                    Log.d(TAG, "onFailure: " + e.toString());
//                                }
//                            });
//                            startActivity(new Intent(signUp.this, MainPage.class));
                        }else {
                            Toast.makeText(signUp.this, "Error!!!" + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });


        goLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                startActivity(new Intent(signUp.this, Login.class));
            }
        });
    }
}