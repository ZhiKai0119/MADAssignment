package com.example.madassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.DatabaseMetaData;

//import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;


public class shopping_cart extends AppCompatActivity {
//    public ElegantNumberButton btn;

    private ImageView mproductImage;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Button mcheckout;
    private TextView mtotalprice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

//        btn=(ElegantNumberButton)findViewById(R.id.checkout);
//        btn.setOnClickListener(new ElegantNumberButton.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String num=btn.getNumber();
//                Log.e("Num",num);
//            }
//        });

        recyclerView =findViewById(R.id.shopcart_linear);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mcheckout=(Button)findViewById(R.id.checkout);
        mtotalprice=(TextView)findViewById(R.id.cartprice);
    }

    @Override
    protected void onStart(){
        super.onStart();
        final DatabaseReference cartListRef= FirebaseDatabase.getInstance().getReference().child("Cart List");
        //FirebaseRecyclerOption<>
    }
}