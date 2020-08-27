package com.example.madassignment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madassignment.model.ProductAdapter;
import com.example.madassignment.model.ProductModel;

import java.util.ArrayList;
import java.util.List;

public class SearchViewFromList extends AppCompatActivity implements ProductAdapter.SelectedProduct {

    private Toolbar toolbar;
    private RecyclerView recyclerView;

    List<ProductModel> productModelList = new ArrayList<>();

    String[] names = {"Cargo Harem Pants", "Black Pants", "Hasel Pants", "Pants Korean Style", "Men Pockets Pants", "Crystal Men's", "Yfashion 3D", "Stussy Sweatshirts",
    "Cozy Japanese Men", "OFF White Hoodies", "Adidas Cropped Hoodies", "Nike Shield", "Nerdunit Anatomy", "Puma Evide", "Nike A.A.E", "Nerdunit Dash", "Rexagon Jacket",
    "Adidas Track", "Rexagon Spectra Pants", "Nike Tech Fleece", "Natural History Shirt", "Lego Shirt Sleeve", "Satin Bomber", "Flock-print Hoodies", "Urban Walls T-Shirts",
    "Henley Shirt", "Puff-sleeved Top", "Twill Jacket", "Classic Blazer", "Patterned Dress", "Air Jordan Mid", "Nike Ryz 365", "Nike Air Force 1 Shadow",
    "Nike Classic Cortez", "Jordan Jumpman", "Kyrie Low", "Nike React Element", "Nike Signal", "Nike Air Max 97", "Nike Air Max 98"};

    ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        this.setSupportActionBar(toolbar);
        this.getSupportActionBar().setTitle("");

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        for(String s:names){
            ProductModel productModel = new ProductModel(s);

            productModelList.add(productModel);
        }

        productAdapter = new ProductAdapter(productModelList, this);

        recyclerView.setAdapter(productAdapter);
    }

    @Override
    public void selectedProduct(ProductModel productModel) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu3) {
        getMenuInflater().inflate(R.menu.menu3, menu3);

        MenuItem menuItem = menu3.findItem(R.id.searchProduct);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                productAdapter.getFilter().filter(newText);
                return true;
            }
        });

        return super.onCreateOptionsMenu(menu3);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.searchProduct){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}