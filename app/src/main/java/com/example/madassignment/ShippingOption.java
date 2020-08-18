package com.example.madassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ShippingOption extends AppCompatActivity {
    RadioButton poslaju,jtdelivery,dhldelivery;
    EditText name_text,address_text,phone_text,email_text,city,State,postcode;
    Button btnContinue;
    User user;
    FirebaseDatabase database;
    DatabaseReference reference;
    int i=0;

    private Button ContinueCheckOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping_option);

        poslaju=findViewById(R.id.poslaju);
        jtdelivery=findViewById(R.id.jtdelivery);
        dhldelivery=findViewById(R.id.dhldelivery);
        name_text=findViewById(R.id.name_text);
        address_text=findViewById(R.id.address_text);
        phone_text=findViewById(R.id.phone_text);
        email_text=findViewById(R.id.email_text);
        city=findViewById(R.id.city);
        State=findViewById(R.id.State);
        btnContinue=findViewById(R.id.btnContinue);
        reference= database.getInstance().getReference().child("User");
        user=new User();

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(DataSnapshot.exists()){
                    i=(int)DataSnapshot.getChildrenCount();
                }
            }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            ////

            }
        });

        btnContinue.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            String pos= poslaju.getText().toString();
            String jt=jtdelivery.getText().toString();
            String dhl=dhldelivery.getText().toString();


            user.setName(name_text.getText().toString());
            user.setAddress(address_text.getText().toString());
            user.getPhoneNo(phone_text.getText().toString());
            user.getEmail(email_text.getText().toString());
            user.getCity(city.getText().toString());
            user.getState(State.getText().toString());
            user.getPostcode(postcode.getText().toString());

            reference.child(String.valueOf(i+1)).setValue(user)
            if(poslaju.isChecked()){
                user.setDelivery(pos);
                reference.child(String.valueOf(i+1)).setValue(user);
            }
            else if (jtdelivery.isChecked()){
                user.setDelivery(jt);
                reference.child(String.valueOf(i+1)).setValue(user);
            }
            else{
                user.setDelivery(dhl);
                reference.child(String.valueOf(i+1)).setValue(user);
            }
        }

        }

}