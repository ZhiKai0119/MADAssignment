package com.example.madassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;


public class women1 extends AppCompatActivity {

    //add to card
/*  private FloatingActionButton addtocartbutton;
  private TextView productpriceWomen1;*/
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women1);

        Spinner spinner = (Spinner) findViewById(R.id.sizeSpinnerWomen1);
        String[] sizes = {"XS", "S", "M", "L", "XL", "XXL"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, sizes);
        spinner.setAdapter(adapter);


   /*     //add to cart
        addtocartbutton=(FloatingActionButton) findViewById(R.id.add_women1_shopping_cart);


        addtocartbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               addingToCartList();
            }
        });

*/
    }

  /*  private void addingToCartList() {

        String saveCurrentTime, saveCurrentDate;


        SimpleDateFormat currentDate= new SimpleDateFormat("MMM dd, yyyy");
       saveCurrentDate=currentDate.format(calForDate.getTime());


        SimpleDateFormat currentTime= new SimpleDateFormat("HH:mm:ss a");
       saveCurrentTime=currentDate.format(calForDate.getTime());

        final DatabaseReference cartListRef= FirebaseDatabase.getInstance().getReference().child("Cart List");

        final HashMap<String,Object> cartMap=new HashMap<>();
        cartMap.put("Price",productpriceWomen1.getText().toString());

        cartListRef.child("User View").child(Prevalent.currentOnlineUser.getPhone())
            .child("Products").child(productpriceWomen1)
                .updateChildren(cartMap)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {

                        }
                    }
                });}*/

}
