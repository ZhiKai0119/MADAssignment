package com.example.madassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.madassignment.ui.SectionsPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class ProductList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
    }

    //Create the menu option
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2, menu);
        return true;
    }

    //when the option is selected
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search:
                displayToast(getString(R.string.search_clicked));
                return true;
            case R.id.setting:
                displayToast(getString(R.string.setting_clicked));
                return true;
            case R.id.aboutUs:
                startActivity(new Intent(ProductList.this, AboutUs.class));
                return true;
            case R.id.contactUs:
                startActivity(new Intent(ProductList.this, ContactUs.class));
                return true;
            case R.id.FAQ:
                startActivity(new Intent(ProductList.this, FAQ.class));
                return true;
            case R.id.homepage:
                startActivity(new Intent(ProductList.this, MainPage.class));
                return true;
            default:
                //Do nothing
        }
        return super.onOptionsItemSelected(item);
    }

    //Display toast to tell users
    private void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }
}