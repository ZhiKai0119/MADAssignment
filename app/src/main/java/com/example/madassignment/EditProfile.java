package com.example.madassignment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import de.hdodenhof.circleimageview.CircleImageView;

public class EditProfile extends AppCompatActivity {

    public static final String TAG = "EditProfile";
    private EditText name, userEmail, userPhone;
    private CircleImageView userImage;
    private Button save;
    private FirebaseAuth mAuth;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        Intent data = getIntent();
        final String fullName = data.getStringExtra("fullName");
        String email = data.getStringExtra("email");
        String phone = data.getStringExtra("phone");

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        name = (EditText) findViewById(R.id.enter_username);
        userEmail = (EditText) findViewById(R.id.enter_email);
        userPhone = (EditText) findViewById(R.id.enter_phone);
        userImage = (CircleImageView) findViewById(R.id.profile_image);
        save = (Button) findViewById(R.id.btnSave);

        userImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        name.setText(fullName);
        userEmail.setText(email);
        userPhone.setText(phone);

        Log.d(TAG, "onCreate:" + fullName + "" + email + "" + phone);
    }
}