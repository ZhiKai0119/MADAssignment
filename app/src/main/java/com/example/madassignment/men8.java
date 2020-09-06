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

public class men8 extends AppCompatActivity {
    private FloatingActionButton addCartBtn;
    private TextView productPriceMen, productName, productDesc;
    private ImageView imageMen;
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
        setContentView(R.layout.activity_men8);

        spinner = (Spinner) findViewById(R.id.sizeSpinnerMen8);
        String[] sizes={"XS", "S", "M", "L", "XL", "XXL"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, sizes);
        spinner.setAdapter(adapter);

        productName = (TextView) findViewById(R.id.product_nameMen8);
        productPriceMen = (TextView) findViewById(R.id.product_priceMen8);
        productDesc = (TextView) findViewById(R.id.product_descMen8);
        imageMen = (ImageView) findViewById(R.id.productImageMen8);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        mReference = FirebaseDatabase.getInstance().getReference().child("Shopping Cart");
        mReference2 = FirebaseDatabase.getInstance().getReference().child("Wish List");
        storageReference = FirebaseStorage.getInstance().getReference().child("ProductImages/men8.jpg");

        try {
            final File localFile = File.createTempFile("men8", "jpg");
            storageReference.getFile(localFile)
                    .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                            Toast.makeText(men8.this, "Picture Retrieved", Toast.LENGTH_LONG).show();
                            Bitmap bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath());
                            ((ImageView) findViewById(R.id.productImageMen8)).setImageBitmap(bitmap);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(men8.this, "Error Occurred", Toast.LENGTH_LONG).show();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

        //add to cart
        addCartBtn=(FloatingActionButton) findViewById(R.id.add_men8_shopping_cart);
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
                wishListMap.put("product_id", "Men8");
                wishListMap.put("product_Name", productName.getText().toString());
                wishListMap.put("product_Price", productPriceMen.getText().toString());

                mReference2.child(mAuth.getCurrentUser().getUid()).child("Men8").setValue(wishListMap);
                Snackbar.make(findViewById(R.id.rootIdMen8), "Added To WishList", Snackbar.LENGTH_SHORT).show();
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
        cartMap.put("Product_ID", "Men8");
        cartMap.put("Image", storageReference.toString());
        cartMap.put("Name",productName.getText().toString());
        cartMap.put("Price", productPriceMen.getText().toString());
        cartMap.put("Desc", productDesc.getText().toString());
        cartMap.put("Size", spinner.getSelectedItem().toString());
        cartMap.put("Date", saveCurrentDate);
        cartMap.put("Time", saveCurrentTime);
        cartMap.put("quantity", String.valueOf(quantity+1));

        mReference.child(mAuth.getCurrentUser().getUid()).child("Men8").setValue(cartMap);

        Toast.makeText(men8.this, "Product Already Added Into Shopping Cart", Toast.LENGTH_LONG).show();
    }
}