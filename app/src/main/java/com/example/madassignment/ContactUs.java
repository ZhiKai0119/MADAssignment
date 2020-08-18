package com.example.madassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class ContactUs extends AppCompatActivity {
    private EditText name_ali, email_ali_gmail_com, tel_ali;
    private Button button_submit;
    private DatabaseReference reff;
    private FirebaseUser mUser;
    private FirebaseAuth mAuth;
    private ProgressBar mProgress;
    private Member member;
    private long maxId = 0;

    Intent intent = null, chooser=null;
    private TextView email;
    private TextView phone;
    private TextView facebook;
    private TextView instagram;
    private TextView webpage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        email = (TextView) findViewById(R.id.Lacc_email);
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));
                String to = "customercare@jdsports.my";
                intent.putExtra(Intent.EXTRA_EMAIL, to);
                intent.putExtra(Intent.EXTRA_SUBJECT, "LACC Fashion Customer Service");
                intent.setType("message/rfc822");
                chooser = Intent.createChooser(intent, "Send Email");
                startActivity(chooser);
            }
        });

        phone = (TextView) findViewById(R.id.Lacc_phone);
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
//                String number = "0184664697";
                callIntent.setData(Uri.parse("tel:015-4877 0606"));
                if(ActivityCompat.checkSelfPermission(ContactUs.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                    return;
                }
                startActivity(callIntent);
            }
        });

        facebook = (TextView) findViewById(R.id.facebook_jdsports);
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent facebookIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/jdsportsmalaysia"));
                startActivity(facebookIntent);
            }
        });

        instagram = (TextView) findViewById(R.id.instagram);
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent instaIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/jdsportsmy"));
                startActivity(instaIntent);
            }
        });

        webpage = (TextView) findViewById(R.id.webpage);
        webpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent webpageIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.jdsports.my/"));
                startActivity(webpageIntent);
            }
        });

        mProgress = new ProgressBar(this);
        //Database (Firebase)
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        reff= FirebaseDatabase.getInstance().getReference().child("Member");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                    maxId = (snapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        name_ali=(EditText)findViewById(R.id.name_ali);
        email_ali_gmail_com=(EditText)findViewById(R.id.email_ali);
        tel_ali=(EditText)findViewById(R.id.tel_ali);
        button_submit=(Button)findViewById(R.id.button_submit);
        member = new Member();

        button_submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mProgress.setVisibility(View.VISIBLE);

                final String name = name_ali.getText().toString().trim();
                final String email = email_ali_gmail_com.getText().toString().trim();
                final Long tel= Long.parseLong(tel_ali.getText().toString().trim());
                String saveCurrentTime, saveCurrentDate;

                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd, yyyy");
                saveCurrentDate = currentDate.format(calendar.getTime());

                SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
                saveCurrentTime = currentTime.format(calendar.getTime());

                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(email) && tel != null){
                    member.setTel(tel);
                    member.setName(name);
                    member.setEmail(email);
                    member.setTime(saveCurrentTime);
                    member.setDate(saveCurrentDate);

                    reff.child("Member" + String.valueOf(maxId+1)).setValue(member);

                    Toast.makeText(ContactUs.this, "Data Inserted Successfully", Toast.LENGTH_LONG).show();
                }
                //Clear The Edit Text
                name_ali.setText("");
                email_ali_gmail_com.setText("");
                tel_ali.setText("");
            }
        });
    }
}