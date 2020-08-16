package com.example.madassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class women10 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women10);

        Spinner spinner = (Spinner) findViewById(R.id.sizeSpinnerWomen4);
        String[] sizes={"XS", "S", "M", "L", "XL", "XXL"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, sizes);
        spinner.setAdapter(adapter);
    }
}