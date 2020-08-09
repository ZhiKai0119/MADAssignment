package com.example.madassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainPage extends AppCompatActivity implements View.OnClickListener {
    //Add view flipper
    private ViewFlipper viewFlipper;

    private Button learnMore;
    private ImageView learnMore2;
    FloatingActionButton shoppingCart;
    private ImageView men;
    private ImageView women;
    private ImageView kids;

    private Button btnMen1;
    private Button btnMen2;
    private Button btnWomen1;
    private Button btnWomen2;
    private Button btnKids1;
    private Button btnKids2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        //array
        int[] images ={R.drawable.photo1, R.drawable.photo2, R.drawable.photo3, R.drawable.photo4};
        viewFlipper = findViewById(R.id.idAdapterViewFlipper);

        //use for loop to loop
        for (int image: images) {
            flipperImages(image);
        }

        learnMore = (Button) findViewById(R.id.learn_more);
        learnMore.setOnClickListener(this);

        learnMore2 = (ImageView) findViewById(R.id.basketball_star);
        learnMore2.setOnClickListener(this);

        shoppingCart = (FloatingActionButton) findViewById(R.id.shopping_cart);
        shoppingCart.setOnClickListener(this);

        men = (ImageView) findViewById(R.id.men);
        men.setOnClickListener(this);

        women = (ImageView) findViewById(R.id.women);
        women.setOnClickListener(this);

        kids = (ImageView) findViewById(R.id.kids);
        kids.setOnClickListener(this);

        btnMen1 = (Button) findViewById(R.id.men_1_btn);
        btnMen1.setOnClickListener(this);

        btnMen2 = (Button) findViewById(R.id.men_2_btn);
        btnMen2.setOnClickListener(this);

        btnWomen1 = (Button) findViewById(R.id.women_1_btn);
        btnWomen1.setOnClickListener(this);

        btnWomen2 = (Button) findViewById(R.id.women_2_btn);
        btnWomen2.setOnClickListener(this);

        btnKids1 = (Button) findViewById(R.id.kids_1_btn);
        btnKids1.setOnClickListener(this);

        btnKids2 = (Button) findViewById(R.id.kids_2_btn);
        btnKids2.setOnClickListener(this);
    }




    public void flipperImages (int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(2000);
        viewFlipper.setAutoStart(true);

        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }

    //Create the menu option
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
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
                startActivity(new Intent(MainPage.this, AboutUs.class));
                return true;
            case R.id.contactUs:
                startActivity(new Intent(MainPage.this, ContactUs.class));
                return true;
            case R.id.FAQ:
                startActivity(new Intent(MainPage.this, FAQ.class));
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.learn_more:
            case R.id.basketball_star:
                startActivity(new Intent(MainPage.this, Offer_45.class));
                break;
            case R.id.shopping_cart:
                Toast.makeText(getApplicationContext(), "Button Clicked", Toast.LENGTH_LONG).show();
                break;
            case R.id.men:
            case R.id.women:
            case R.id.kids:
                startActivity(new Intent(MainPage.this, ProductList.class));
                break;
            case R.id.men_1_btn:
                //startActivity(new Intent(MainPage.this, men1.class));
                break;
            case R.id.men_2_btn:
                //startActivity(new Intent(MainPage.this, men8.class));
                break;
            case R.id.women_1_btn:
                //startActivity(new Intent(MainPage.this, women7.class));
                break;
            case R.id.women_2_btn:
                startActivity(new Intent(MainPage.this, women2.class));
                break;
            case R.id.kids_1_btn:
                startActivity(new Intent(MainPage.this, kids1.class));
                break;
            case R.id.kids_2_btn:
                startActivity(new Intent(MainPage.this, kids4.class));
                break;
            default:
                //Nothings
        }
    }
}