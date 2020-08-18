package com.example.madassignment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;


public class women1 extends AppCompatActivity {

    //add to card
    private FloatingActionButton addtocartbutton;
    private TextView productpriceWomen1, productName, productDesc;
    private ImageView imageWomen1;
    private Spinner spinner;
    private Uri filePathUri;
    private StorageReference storageReference;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private DatabaseReference mReference;
    private int Image_Request_Code = 7;
    public long maxId = 0;
    public long quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women1);

        spinner = (Spinner) findViewById(R.id.sizeSpinnerWomen1);
        String[] sizes = {"XS", "S", "M", "L", "XL", "XXL"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, sizes);
        spinner.setAdapter(adapter);

        productName = (TextView) findViewById(R.id.product_nameWomen1);
        productpriceWomen1 = (TextView) findViewById(R.id.product_priceWomen1);
        productDesc = (TextView) findViewById(R.id.product_descWomen1);
        imageWomen1 = (ImageView) findViewById(R.id.productImageWomen1);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        mReference = FirebaseDatabase.getInstance().getReference().child("Shopping Cart");
        storageReference = FirebaseStorage.getInstance().getReference();

        //add to cart
        addtocartbutton=(FloatingActionButton) findViewById(R.id.add_women1_shopping_cart);
        addtocartbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               addingToCartList();
               quantity += 1;
            }
        });

        mReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                    maxId = (snapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void addingToCartList() {
        String saveCurrentTime, saveCurrentDate;

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd, yyyy");
        saveCurrentDate = currentDate.format(calendar.getTime());

        SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
        saveCurrentTime = currentTime.format(calendar.getTime());

//        StorageReference filepath = storageReference.child("Product_Images/");
//        filepath.putFile(filePathUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//            @Override
//            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                Toast.makeText(women1.this, "Product Already Added Into Shopping Cart", Toast.LENGTH_LONG).show();
//            }
//        });

        final HashMap<String,Object> cartMap=new HashMap<>();
        cartMap.put("Image", imageWomen1.toString());
        cartMap.put("Name",productName.getText().toString());
        cartMap.put("Price", productpriceWomen1.getText().toString());
        cartMap.put("Desc", productDesc.getText().toString());
        cartMap.put("Size", spinner.getSelectedItem().toString());
        cartMap.put("Date", saveCurrentDate);
        cartMap.put("Time", saveCurrentTime);
        cartMap.put("quantity", String.valueOf(quantity+1));

        mReference.child(mAuth.getCurrentUser().getDisplayName()).child("Women1").setValue(cartMap);

//        mReference.child(mAuth.getCurrentUser().getDisplayName()).child("Product" + String.valueOf(maxId+1)).setValue(cartMap);

        Toast.makeText(women1.this, "Product Already Added Into Shopping Cart", Toast.LENGTH_LONG).show();
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if(requestCode == Image_Request_Code && resultCode == RESULT_OK) {
//            filePathUri = data.getData();
//            imageWomen1.setImageURI(filePathUri);
//        }
//    }
}
