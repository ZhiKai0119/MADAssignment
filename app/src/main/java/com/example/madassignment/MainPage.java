package com.example.madassignment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;

public class MainPage extends AppCompatActivity implements View.OnClickListener {

    private TextView shipping, header;
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
    private Button btnKids2, btnShoes;

    private ImageView spokesperson;
    private ImageView spokesperson2;
    private ImageView spokesperson3;
    private ImageView spokesperson4;
    private ImageView spokesperson5, spokesperson6, spokesperson7, spokesperson8;

    private static final String TAG = "MainPage";

    private FirebaseAuth mAuth;
//    private FirebaseAuth.AuthStateListener mAuthListener;
//    private FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        header = (TextView) findViewById(R.id.header);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
        header.startAnimation(animation1);

        shipping = (TextView) findViewById(R.id.free_shipping);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move_left);
        shipping.startAnimation(animation);

        //array
        int[] images ={R.drawable.photo1, R.drawable.photo2, R.drawable.photo3, R.drawable.photo4};
        viewFlipper = findViewById(R.id.idAdapterViewFlipper);

        //use for loop to loop
        for (int image: images) {
            flipperImages(image);
        }

        mAuth = FirebaseAuth.getInstance();

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

        btnShoes = (Button) findViewById(R.id.nike_adidas_btn);
        btnShoes.setOnClickListener(this);

        spokesperson = (ImageView) findViewById(R.id.spokesperson);
        spokesperson.setOnClickListener(this);
        spokesperson2 = (ImageView) findViewById(R.id.spokesperson_2);
        spokesperson2.setOnClickListener(this);
        spokesperson3 = (ImageView) findViewById(R.id.spokesperson_3);
        spokesperson3.setOnClickListener(this);
        spokesperson4 = (ImageView) findViewById(R.id.spokesperson_4);
        spokesperson4.setOnClickListener(this);
        spokesperson5 = (ImageView) findViewById(R.id.spokesperson_5);
        spokesperson5.setOnClickListener(this);
        spokesperson6 = (ImageView) findViewById(R.id.spokesperson_6);
        spokesperson6.setOnClickListener(this);
        spokesperson7 = (ImageView) findViewById(R.id.spokesperson_7);
        spokesperson7.setOnClickListener(this);
        spokesperson8 = (ImageView) findViewById(R.id.spokesperson_8);
        spokesperson8.setOnClickListener(this);
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
                startActivity(new Intent(MainPage.this, SearchViewFromList.class));
                return true;
            case R.id.profile:
                startActivity(new Intent(MainPage.this, userProfile.class));
                return true;
            case R.id.aboutUs:
                startActivity(new Intent(MainPage.this, AboutUs.class));
                return true;
            case R.id.contactUs:
                startActivity(new Intent(MainPage.this, ContactUs.class));
                return true;
            case R.id.FAQ:
                startActivity(new Intent(MainPage.this, FAQ.class));
                return true;
            case R.id.shopping_cart:
                startActivity(new Intent(MainPage.this, shopping_cart.class));
                return true;
            case R.id.signOut:
                mAuth.signOut();
                Toast.makeText(MainPage.this, "You Signed Out!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(MainPage.this, Login.class));
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.learn_more:
            case R.id.basketball_star:
                startActivity(new Intent(MainPage.this, Offer_45.class));
                break;
            case R.id.shopping_cart:
                startActivity(new Intent(MainPage.this, shopping_cart.class));
                break;
            case R.id.men:
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.setCustomAnimations(R.anim.fragment_open_enter, R.anim.fragment_close_exit, R.anim.fragment_fade_enter, R.anim.fragment_fade_exit);
                Fragment1 Fragment_1 = new Fragment1();
                transaction.addToBackStack(null);
                transaction.add(R.id.Move_product_list, Fragment_1);
                transaction.commit();
                break;
            case R.id.women:
                FragmentManager manager2 = getSupportFragmentManager();
                FragmentTransaction transaction2 = manager2.beginTransaction();
                transaction2.setCustomAnimations(R.anim.fragment_open_enter, R.anim.fragment_close_exit, R.anim.fragment_fade_enter, R.anim.fragment_fade_exit);
                Fragment2 Fragment_2 = new Fragment2();
                transaction2.addToBackStack(null);
                transaction2.add(R.id.Move_product_list, Fragment_2);
                transaction2.commit();
                break;
            case R.id.kids:
                FragmentManager manager3 = getSupportFragmentManager();
                FragmentTransaction transaction3 = manager3.beginTransaction();
                transaction3.setCustomAnimations(R.anim.fragment_open_enter, R.anim.fragment_close_exit, R.anim.fragment_fade_enter, R.anim.fragment_fade_exit);
                Fragment3 Fragment_3 = new Fragment3();
                transaction3.addToBackStack(null);
                transaction3.add(R.id.Move_product_list, Fragment_3);
                transaction3.commit();
                break;
            case R.id.men_1_btn:
                startActivity(new Intent(MainPage.this, shoe1.class));
                break;
            case R.id.men_2_btn:
                startActivity(new Intent(MainPage.this, men8.class));
                break;
            case R.id.women_1_btn:
                startActivity(new Intent(MainPage.this, women7.class));
                break;
            case R.id.women_2_btn:
                startActivity(new Intent(MainPage.this, women2.class));
                break;
            case R.id.kids_1_btn:
                startActivity(new Intent(MainPage.this, kids3.class));
                break;
            case R.id.kids_2_btn:
                startActivity(new Intent(MainPage.this, kids4.class));
                break;
            case R.id.nike_adidas_btn:
                FragmentManager manager4 = getSupportFragmentManager();
                FragmentTransaction transaction4 = manager4.beginTransaction();
                transaction4.setCustomAnimations(R.anim.fragment_open_enter, R.anim.fragment_close_exit, R.anim.fragment_fade_enter, R.anim.fragment_fade_exit);
                Fragment4 Fragment_4 = new Fragment4();
                transaction4.addToBackStack(null);
                transaction4.add(R.id.Move_product_list, Fragment_4);
                transaction4.commit();
                break;
            case R.id.spokesperson:
            case R.id.spokesperson_6:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Spokesperson Information");
                builder.setMessage("Name:Yoona\nDate of birth  :30/5/1990\nAge   :30\nGender:Female\nOccupation:actress ,singer\nCitizenship:Korea\nGroup Name: Girl generation\nFavourite fashion style: Chic\nFavourite Sport: basketball");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.create().show();
                break;
            case R.id.spokesperson_2:
            case R.id.spokesperson_3:
                AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                builder2.setTitle("Spokesperson Information");
                builder2.setMessage("Name:Taeyeon\nDate of birth  :9/3/1989\nAge   :31\nGender:Female\nOccupation:Singer\nCitizenship:korea\nGroup Name: Girl generation\nFavourite fashion style:Streetwear\nFavourite Sport: swimming");
                builder2.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder2.create().show();
                break;
            case R.id.spokesperson_4:
            case R.id.spokesperson_5:
                AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
                builder3.setTitle("Spokesperson Information");
                builder3.setMessage("Name:Suzy Bae\nDate of birth  : 10/10/1994\nAge   :25\nGender:Female\nOccupation: Acterss,singer ,dancer\nCitizenship:Korean\nGroup Name:Miss A\nFavourite fashion style:casual\nFavourite Sport:Badminton");
                builder3.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder3.create().show();
                break;
            case R.id.spokesperson_7:
                AlertDialog.Builder builder4 = new AlertDialog.Builder(this);
                builder4.setTitle("Spokesperson Information");
                builder4.setMessage("Name: IU\nBirthday :16/5/1995\nGender:female\nOccupation: kpop singer\nCitizens : Tailand\nGroup name: iu team\nFavorite fashion style: korea style\nFavorite sport : badminton");
                builder4.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder4.create().show();
                break;
            case R.id.spokesperson_8:
            AlertDialog.Builder builder5 = new AlertDialog.Builder(this);
            builder5.setTitle("Spokesperson Information");
            builder5.setMessage("Name: Na Eun\nBirthday :10/10/1993\nAge:27\nGender :female\nOccupation : singer\nCitizens : Taiwan\nGroup name : Apink\nFavorite fashion : soprt\nFavorite sport : tennis");
            builder5.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            builder5.create().show();
            break;
            default:
                //Nothings
        }
    }
}