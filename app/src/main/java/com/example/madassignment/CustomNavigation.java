package com.example.madassignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class CustomNavigation extends AppCompatActivity {

    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_navigation);

        mAuth = FirebaseAuth.getInstance();

        nav = (NavigationView) findViewById(R.id.navMenu);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.menu_home:
                        Toast.makeText(getApplicationContext(), "Home Page Is Open", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(CustomNavigation.this, MainPage.class));
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.user_profile:
                        Toast.makeText(getApplicationContext(), "Profile Is Open", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(CustomNavigation.this, userProfile.class));
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.product:
                        Toast.makeText(getApplicationContext(), "Product List Is Open", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(CustomNavigation.this, ProductList.class));
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.search:
                        Toast.makeText(getApplicationContext(), "Search Is Open", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(CustomNavigation.this, SearchViewFromList.class));
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.wish_list:
                        Toast.makeText(getApplicationContext(), "Wish List Is Open", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(CustomNavigation.this, wishList.class));
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.shopping_cart:
                        Toast.makeText(getApplicationContext(), "Shopping Cart Is Open", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(CustomNavigation.this, shopping_cart.class));
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.FAQ:
                        Toast.makeText(getApplicationContext(), "FAQ Is Open", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(CustomNavigation.this, FAQ.class));
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.about_us:
                        Toast.makeText(getApplicationContext(), "About Us Is Open", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(CustomNavigation.this, AboutUs.class));
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.contactUs:
                        Toast.makeText(getApplicationContext(), "Contact Us Is Open", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(CustomNavigation.this, ContactUs.class));
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.contactUsHistory:
                        Toast.makeText(getApplicationContext(), "Contact Us History Is Open", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(CustomNavigation.this, ContactUsRecords.class));
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.signOut:
                        mAuth.signOut();
                        Toast.makeText(getApplicationContext(), "Signed Out Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(CustomNavigation.this, Login.class));
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }

                return true;
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}