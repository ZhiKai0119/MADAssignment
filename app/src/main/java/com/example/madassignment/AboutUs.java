package com.example.madassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.google.android.gms.ads.AdListener;
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
    private AdView adView1, adView2;
    private InterstitialAd interstitialAd;

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
        adView2 = (AdView) findViewById(R.id.ad_view2);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView1.loadAd(adRequest);
        adView2.loadAd(adRequest);

//        interstitialAd = new InterstitialAd(this);
//        interstitialAd.setAdUnitId("ca-app-pub-1129430547781038/3428746645");
//        interstitialAd.loadAd(new AdRequest.Builder().build());
//
//        interstitialAd.show();

//        AdView adView = (AdView) findViewById(R.id.adView);
//
//        AdRequest adRequest = new AdRequest.Builder().setRequestAgent("android_studio:ad_template").build();
//
//        adView.loadAd(adRequest);

//        videoView = findViewById(R.id.videoView);
//        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.video;
//        Uri uri = Uri.parse(videoPath);
//        videoView.setVideoURI(uri);
//
//        MediaController mediaController = new MediaController(this);
//        videoView.setMediaController(mediaController);
//        mediaController.setAnchorView(videoView);
//        videoView.requestFocus();
//        videoView.start();
    }
}