package com.example.madassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class shoppingcart_layout extends AppCompatActivity {


    private ImageView mproductImage;
    //    public ElegantNumberButton btnnumber;
    private TextView mitemname, mitemprice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoppingcart_layout);


    }
}