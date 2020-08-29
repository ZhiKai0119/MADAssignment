//package com.example.madassignment;
//
//import android.os.Bundle;
//import android.widget.ImageButton;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//public class shoppingcart_layout extends AppCompatActivity {
//
//    private int mCount = 0;
//    private TextView quantity;
//    private ImageButton btnAdd, btnRemove;
//    private ImageView itemImage;
//    private TextView itemName, itemPrice;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_shoppingcart_layout);
//
//        quantity = (TextView) findViewById(R.id.quantity);
//        itemImage = (ImageView) findViewById(R.id.image);
//        itemName = (TextView) findViewById(R.id.item_name);
//        itemPrice = (TextView) findViewById(R.id.item_price);
//
////        btnAdd = (ImageButton) findViewById(R.id.btnAdd);
////        btnAdd.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                ++mCount;
////                quantity.setText(Integer.toString(mCount));
////            }
////        });
////
////        btnRemove = (ImageButton) findViewById(R.id.btnRemove);
////        btnRemove.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                --mCount;
////                quantity.setText(Integer.toString(mCount));
////            }
////        });
//    }
//}