package com.example.madassignment;

import android.os.Bundle;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
//import android.widget.MediaController;
//import android.widget.VideoView;

//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.AdView;

public class AboutUs extends AppCompatActivity {

//    private VideoView videoView;
    private AdView adView1;
    private InterstitialAd interstitialAd;
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        MobileAds.initialize(AboutUs.this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        adView1 = (AdView) findViewById(R.id.ad_view1);

        AdRequest adRequest = new AdRequest.Builder().build();
        adView1.loadAd(adRequest);

        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        interstitialAd.loadAd(new AdRequest.Builder().build());

        interstitialAd.show();

//        videoView = (VideoView) findViewById(R.id.videoView);
//        videoView.setVideoURI(Uri.parse("https://www.youtube.com/watch?v=DR-Bj_UIFH8"));
//        videoView.setMediaController(new MediaController(this));
//        videoView.requestFocus();
//        videoView.start();
    }
}