package com.example.madassignment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class kids6 extends AppCompatActivity {
    private FloatingActionButton addCartBtn;
    private TextView productPrice, productName, productDesc;
    private ImageView imageKids;
    private Spinner spinner;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private DatabaseReference mReference, mReference2;
    private StorageReference storageReference;
    public long maxId = 0;
    public long quantity = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids6);

        spinner = (Spinner) findViewById(R.id.sizeSpinnerkid6);
        String[] sizes={"XS", "S", "M", "L", "XL", "XXL"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, sizes);
        spinner.setAdapter(adapter);

        productName = (TextView) findViewById(R.id.product_namekid6);
        productPrice = (TextView) findViewById(R.id.product_pricekid6);
        productDesc = (TextView) findViewById(R.id.product_desckid6);
        imageKids = (ImageView) findViewById(R.id.productImagekid6);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        mReference = FirebaseDatabase.getInstance().getReference().child("Shopping Cart");
        mReference2 = FirebaseDatabase.getInstance().getReference().child("Wish List");
        storageReference = FirebaseStorage.getInstance().getReference().child("ProductImages/kids6.jpg");

        try {
            final File localFile = File.createTempFile("kids6", "jpg");
            storageReference.getFile(localFile)
                    .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                            Toast.makeText(kids6.this, "Picture Retrieved", Toast.LENGTH_LONG).show();
                            Bitmap bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath());
                            ((ImageView) findViewById(R.id.productImagekid6)).setImageBitmap(bitmap);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(kids6.this, "Error Occurred", Toast.LENGTH_LONG).show();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

        //add to cart
        addCartBtn=(FloatingActionButton) findViewById(R.id.add_kids6_shopping_cart);
        addCartBtn.setOnClickListener(new View.OnClickListener() {
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu4) {
        getMenuInflater().inflate(R.menu.menu4, menu4);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.addWishList:
                final HashMap<String, Object> wishListMap = new HashMap<>();
                wishListMap.put("product_id", "Kids6");
                wishListMap.put("product_Name", productName.getText().toString());
                wishListMap.put("product_Price", productPrice.getText().toString());

                mReference2.child(mAuth.getCurrentUser().getUid()).child("Kids6").setValue(wishListMap);
                Snackbar.make(findViewById(R.id.rootIdKids6), "Added To WishList", Snackbar.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void addingToCartList() {
        String saveCurrentTime, saveCurrentDate;

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd, yyyy");
        saveCurrentDate = currentDate.format(calendar.getTime());

        SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
        saveCurrentTime = currentTime.format(calendar.getTime());

        final HashMap<String,Object> cartMap=new HashMap<>();
        cartMap.put("Product_ID", "Kids");
        cartMap.put("Image", storageReference.toString());
        cartMap.put("Name",productName.getText().toString());
        cartMap.put("Price", productPrice.getText().toString());
        cartMap.put("Desc", productDesc.getText().toString());
        cartMap.put("Size", spinner.getSelectedItem().toString());
        cartMap.put("Date", saveCurrentDate);
        cartMap.put("Time", saveCurrentTime);
        cartMap.put("quantity", String.valueOf(quantity+1));

        mReference.child(mAuth.getCurrentUser().getUid()).child("Kids6").setValue(cartMap);

        Toast.makeText(kids6.this, "Product Already Added Into Shopping Cart", Toast.LENGTH_LONG).show();
    }
}