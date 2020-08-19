package com.example.madassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class shoppingcart_layout extends AppCompatActivity {

    private int mCount = 0;
    private TextView quantity;
    private ImageButton btnAdd, btnRemove;

//    private ImageView mproductImage;
//    private TextView mitemname, mitemprice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoppingcart_layout);

        quantity = (TextView) findViewById(R.id.quantity);

        btnAdd = (ImageButton) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ++mCount;
                quantity.setText(Integer.toString(mCount));
            }
        });

        btnRemove = (ImageButton) findViewById(R.id.btnRemove);
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                --mCount;
                quantity.setText(Integer.toString(mCount));
            }
        });
    }
}