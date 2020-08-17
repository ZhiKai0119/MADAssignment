package com.example.madassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ContactUs extends AppCompatActivity {
EditText name_ali, email_ali_gmail_com, tel_ali;
Button button_submit;
DatabaseReference reff;
Member member;
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

        name_ali=(EditText)findViewById(R.id.name_ali);
        email_ali_gmail_com=(EditText)findViewById(R.id.email_ali);
        tel_ali=(EditText)findViewById(R.id.tel_ali);
        button_submit=(Button)findViewById(R.id.button_submit);
        member=new Member();
        reff= FirebaseDatabase.getInstance().getReference().child("Member");
        button_submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Long tel= Long.parseLong(tel_ali.getText().toString().trim());
                member.setTel(tel);
                member.setName(name_ali.getText().toString().trim());
                member.setEmail(email_ali_gmail_com.getText().toString().trim());
                reff.child("member1").setValue(member);
                Toast.makeText(ContactUs.this, "data inserted successfully", Toast.LENGTH_LONG).show();
            }
        });
    }
}