package com.example.madassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Offer_45 extends AppCompatActivity {

    private TextView Ball45;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_45);

        Ball45 = (TextView) findViewById(R.id.BALL45);
        Ball45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Value = Ball45.getText().toString();
                ClipboardManager clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("Data", Value);
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(getApplicationContext(), "Copied To Clipboard!!!", Toast.LENGTH_LONG).show();
            }
        });
    }
}