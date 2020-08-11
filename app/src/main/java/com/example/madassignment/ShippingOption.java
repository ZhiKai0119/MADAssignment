package com.example.madassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ShippingOption extends AppCompatActivity {

    private Button ContinueCheckOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping_option);

        ContinueCheckOut = (Button) findViewById(R.id.btnContinue);
        ContinueCheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ShippingOption.this, PaymentDetail.class));
            }
        });
    }

    public void onRadioButtonClicked(View view) {
    }
}