package com.example.madassignment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ShippingOption extends AppCompatActivity {
    private RadioButton poslaju,jtdelivery,dhldelivery;
    private EditText name_text,address_text,phone_text,email_text,city,State,postcode;
    private Button btnContinue;
    private User user;
    private DatabaseReference reference;
    private long maxId = 0;

    private String totalAmount = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping_option);

        totalAmount = getIntent().getStringExtra("Total Price");
        Toast.makeText(this, "Total Price = " + totalAmount, Toast.LENGTH_SHORT).show();

        poslaju = (RadioButton) findViewById(R.id.poslaju);
        jtdelivery = (RadioButton) findViewById(R.id.jtdelivery);
        dhldelivery = (RadioButton) findViewById(R.id.dhldelivery);

        name_text = (EditText) findViewById(R.id.Name);
        address_text = (EditText) findViewById(R.id.address_text);
        phone_text = (EditText) findViewById(R.id.phone_label);
        email_text = (EditText) findViewById(R.id.Email);
        city = (EditText) findViewById(R.id.city);
        State = (EditText) findViewById(R.id.State);
        postcode = (EditText) findViewById(R.id.postcode);

        btnContinue = (Button) findViewById(R.id.btnContinue);
        user = new User();
        reference = FirebaseDatabase.getInstance().getReference().child("Shipping Option");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                    maxId = (snapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pos = poslaju.getText().toString();
                String jt = jtdelivery.getText().toString();
                String dhl = dhldelivery.getText().toString();

                final String name = name_text.getText().toString();
                final String address = address_text.getText().toString();
                final String phoneNo = phone_text.getText().toString();
                final String email = email_text.getText().toString();
                final String City = city.getText().toString();
                final String state = State.getText().toString();
                final int Postcode = Integer.parseInt(postcode.getText().toString());

                if(TextUtils.isEmpty(name)){
                    name_text.setError("This Area Must Insert.");
                }
                if(TextUtils.isEmpty(address)){
                    address_text.setError("This Area Must Insert.");
                }
                if(TextUtils.isEmpty(phoneNo)){
                    phone_text.setError("This Area Must Insert.");
                }
                if(TextUtils.isEmpty(email)){
                    email_text.setError("This Area Must Insert.");
                }
                if(TextUtils.isEmpty(City)){
                    city.setError("This Area Must Insert.");
                }
                if(TextUtils.isEmpty(state)){
                    State.setError("This Area Must Insert.");
                }

                if (poslaju.isChecked()) {
                    user.setDelivery(pos);
                    user.setName(name);
                    user.setAddress(address);
                    user.setPhoneNo(phoneNo);
                    user.setEmail(email);
                    user.setCity(City);
                    user.setState(state);
                    user.setPostcode(Postcode);
                    reference.child("Option (Poslaju)" + String.valueOf(maxId + 1)).setValue(user);
                } else if (jtdelivery.isChecked()) {
                    user.setDelivery(jt);
                    user.setName(name);
                    user.setAddress(address);
                    user.setPhoneNo(phoneNo);
                    user.setEmail(email);
                    user.setCity(City);
                    user.setState(state);
                    user.setPostcode(Postcode);
                    reference.child("Option (JT)" + String.valueOf(maxId + 1)).setValue(user);
                } else {
                    user.setDelivery(dhl);
                    user.setName(name);
                    user.setAddress(address);
                    user.setPhoneNo(phoneNo);
                    user.setEmail(email);
                    user.setCity(City);
                    user.setState(state);
                    user.setPostcode(Postcode);
                    reference.child("Option (DHL)" + String.valueOf(maxId + 1)).setValue(user);
                }

                startActivity(new Intent(getApplicationContext(), PaymentDetail.class));
                finish();
//                reference.child("Option" + String.valueOf(maxId + 1)).setValue(user);
            }
        });
    }
}