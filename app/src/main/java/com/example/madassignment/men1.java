package com.example.madassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class men1 extends AppCompatActivity {
    private FloatingActionButton addCartBtn;
    private TextView productPriceWomen, productName, productDesc;
    private ImageView imageWomen;
    private Spinner spinner;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private DatabaseReference mReference;
    private StorageReference storageReference;
    public long maxId = 0;
    public long quantity = 0;
    private int position = 0;


//    public interface SingleChoiceListener{
//        void onPositiveButtonClicked(String[] list, int position);
//        void onNegativeButtonClicked();
//    }
//    private SingleChoiceListener mListener;
//    private Spinner spinner;
//    private FloatingActionButton addCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men1);

        spinner = (Spinner) findViewById(R.id.sizeSpinnerMen1);
        String[] sizes={"XS", "S", "M", "L", "XL", "XXL"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, sizes);
        spinner.setAdapter(adapter);

        productName = (TextView) findViewById(R.id.product_nameMen1);
        productPriceWomen = (TextView) findViewById(R.id.product_priceMen1);
        productDesc = (TextView) findViewById(R.id.product_descMen1);
        imageWomen = (ImageView) findViewById(R.id.productImageMen1);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        mReference = FirebaseDatabase.getInstance().getReference().child("Shopping Cart");
        storageReference = FirebaseStorage.getInstance().getReference();

        //add to cart
        addCartBtn=(FloatingActionButton) findViewById(R.id.add_men1_shopping_cart);
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
//        spinner.setOnItemClickListener((AdapterView.OnItemClickListener) this);

//        addCart = (FloatingActionButton) findViewById(R.id.add_men1_shopping_cart);
//        addCart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(men1.this);
//                final String[] list = getResources().getStringArray(R.array.choice_items);
//                builder.setTitle("Quantity")
//                        .setSingleChoiceItems(list, position, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                position = i;
//                            }
//                        })
//                        .setPositiveButton("ADD", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                mListener.onPositiveButtonClicked(list,position);
//                            }
//                        })
//                        .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                mListener.onNegativeButtonClicked();
//                            }
//                        });
//                builder.show();
//            }
//        });
    }

    private void addingToCartList() {
        String saveCurrentTime, saveCurrentDate;

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd, yyyy");
        saveCurrentDate = currentDate.format(calendar.getTime());

        SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
        saveCurrentTime = currentTime.format(calendar.getTime());

        final HashMap<String,Object> cartMap=new HashMap<>();
        cartMap.put("Image", imageWomen.toString());
        cartMap.put("Name",productName.getText().toString());
        cartMap.put("Price", productPriceWomen.getText().toString());
        cartMap.put("Desc", productDesc.getText().toString());
        cartMap.put("Size", spinner.getSelectedItem().toString());
        cartMap.put("Date", saveCurrentDate);
        cartMap.put("Time", saveCurrentTime);
        cartMap.put("quantity", String.valueOf(quantity+1));

        mReference.child(mAuth.getCurrentUser().getDisplayName()).child("men1").setValue(cartMap);

        Toast.makeText(men1.this, "Product Already Added Into Shopping Cart", Toast.LENGTH_LONG).show();
    }

}