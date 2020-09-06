package com.example.madassignment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
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

public class women1 extends AppCompatActivity {

    //add to card
    private FloatingActionButton addtocartbutton;
    private TextView productPriceWomen1, productName, productDesc;
    private ImageView imageWomen1;
    private Spinner spinner;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private DatabaseReference mReference, mReference2;
    public long maxId = 0;
    public long quantity = 0;

    private Uri filePathUri;
    private StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women1);

        spinner = (Spinner) findViewById(R.id.sizeSpinnerWomen1);
        String[] sizes = {"XS", "S", "M", "L", "XL", "XXL"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, sizes);
        spinner.setAdapter(adapter);

        productName = (TextView) findViewById(R.id.product_nameWomen1);
        productPriceWomen1 = (TextView) findViewById(R.id.product_priceWomen1);
        productDesc = (TextView) findViewById(R.id.product_descWomen1);
        imageWomen1 = (ImageView) findViewById(R.id.productImageWomen1);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        mReference = FirebaseDatabase.getInstance().getReference().child("Shopping Cart");
        mReference2 = FirebaseDatabase.getInstance().getReference().child("Wish List");
        storageReference = FirebaseStorage.getInstance().getReference().child("ProductImages/women1_0.jpg");

        try {
            final File localFile = File.createTempFile("women1_0", "jpg");
            storageReference.getFile(localFile)
                    .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                            Toast.makeText(women1.this, "Picture Retrieved", Toast.LENGTH_LONG).show();
                            Bitmap bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath());
                            ((ImageView) findViewById(R.id.productImageWomen1)).setImageBitmap(bitmap);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(women1.this, "Error Occurred", Toast.LENGTH_LONG).show();
                }
            });
            
        } catch (IOException e) {
            e.printStackTrace();
        }

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
                wishListMap.put("product_id", "Women1");
                wishListMap.put("product_Name", productName.getText().toString());
                wishListMap.put("product_Price", productPriceWomen1.getText().toString());

                mReference2.child(mAuth.getCurrentUser().getUid()).child("Women1").setValue(wishListMap);
                Snackbar.make(findViewById(R.id.rootIdWomen1), "Added To WishList", Snackbar.LENGTH_SHORT).show();
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
        cartMap.put("Product_ID", "Women1");
        cartMap.put("Image", storageReference.toString());
        cartMap.put("Name",productName.getText().toString());
        cartMap.put("Price", productPriceWomen1.getText().toString());
        cartMap.put("Desc", productDesc.getText().toString());
        cartMap.put("Size", spinner.getSelectedItem().toString());
        cartMap.put("Date", saveCurrentDate);
        cartMap.put("Time", saveCurrentTime);
        cartMap.put("quantity", String.valueOf(quantity+1));

        mReference.child(mAuth.getCurrentUser().getUid()).child("Women1").setValue(cartMap);

//        mReference.child(mAuth.getCurrentUser().getDisplayName()).child("Product" + String.valueOf(maxId+1)).setValue(cartMap);

        Toast.makeText(women1.this, "Product Already Added Into Shopping Cart", Toast.LENGTH_LONG).show();
    }
}
