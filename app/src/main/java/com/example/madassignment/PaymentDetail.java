package com.example.madassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class PaymentDetail extends AppCompatActivity {
EditText Card_Name,bank_text,card_number,expDate,ccv_text;
Button Btnconfirm;
DatabaseReference reff;
Member1 member1;
    private Button confirmBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_detail);

        Card_Name=findViewById(R.id.Card_Name);
        bank_text=findViewById(R.id.bank_text);
        card_number=findViewById(R.id.card_number);
        expDate=findViewById(R.id.expDate);
        ccv_text=findViewById(R.id.ccv_text);
        Btnconfirm=findViewById(R.id.Btnconfirm);
        member1=new Member1();
        reff= FirebaseDatabase.getInstance().getReference().child("Member1");
        Btnconfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number= Integer.parseInt(card_number.getText().toString().trim());
                int Date= Integer.parseInt(expDate.getText().toString().trim());
                int cvvNum= Integer.parseInt(ccv_text.getText().toString().trim());
                member1.setName(Card_Name.getText().toString().trim());
                member1.setBankName(bank_text.getText().toString().trim());
                member1.setNumber(number);
                member1.setDate(date);
                member1.setCvvNum(cvvNum);
                reff.push().setValue(member1);
                Toast.makeText(PaymentDetail.this,text:"Order completed",Toast.LENGTH_LONG).show();
            }
        });


    }
}