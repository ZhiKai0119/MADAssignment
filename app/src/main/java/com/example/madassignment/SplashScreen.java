package com.example.madassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    private ImageView splashImage, splashBackground;
    private TextView splashText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

//        Animation animation1 = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.fade_in);

        splashImage = (ImageView) findViewById(R.id.splash_image);
        Animation animation2 = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.rotate_clockwise);
        splashImage.startAnimation(animation2);

        splashText = (TextView) findViewById(R.id.splash_text);
        Animation animation3 = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.bounce);
        splashText.startAnimation(animation3);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, Login.class);
                startActivity(i);
                finish();
            }
        }, 4000);
    }
}