package com.example.madassignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment4 extends Fragment implements View.OnClickListener {

    private ImageView shoe1, shoe2, shoe3, shoe4, shoe5,shoe6, shoe7,shoe8, shoe9, shoe10;


    public Fragment4() {
        //empty
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container ,
                             @Nullable Bundle savedInstanceState){

        View v = inflater.inflate(R.layout.fragment4_layout,container,false);

        shoe1 = (ImageView) v.findViewById(R.id.shoepic1);
        shoe1.setOnClickListener(this);
        shoe2 = (ImageView) v.findViewById(R.id.shoepic2);
        shoe2.setOnClickListener(this);
        shoe3 = (ImageView) v.findViewById(R.id.shoepic3);
        shoe3.setOnClickListener(this);
        shoe4 = (ImageView) v.findViewById(R.id.shoepic4);
        shoe4.setOnClickListener(this);
        shoe5 = (ImageView) v.findViewById(R.id.shoepic5);
        shoe5.setOnClickListener(this);
        shoe6 = (ImageView) v.findViewById(R.id.shoepic6);
        shoe6.setOnClickListener(this);
        shoe7 = (ImageView) v.findViewById(R.id.shoepic7);
        shoe7.setOnClickListener(this);
        shoe8 = (ImageView) v.findViewById(R.id.shoepic8);
        shoe8.setOnClickListener(this);
        shoe9 = (ImageView) v.findViewById(R.id.shoepic9);
        shoe9.setOnClickListener(this);
        shoe10 = (ImageView) v.findViewById(R.id.shoepic10);
        shoe10.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.shoepic1:
                startActivity(new Intent(getActivity(),shoe1.class));
                break;
            case R.id.shoepic2:
                startActivity(new Intent(getActivity(),shoe2.class));
                break;
            case R.id.shoepic3:
                startActivity(new Intent(getActivity(),shoe3.class));
                break;
            case R.id.shoepic4:
                startActivity(new Intent(getActivity(),shoe4.class));
                break;
            case R.id.shoepic5:
                startActivity(new Intent(getActivity(),shoe5.class));
                break;
            case R.id.shoepic6:
                startActivity(new Intent(getActivity(),shoe6.class));
                break;
            case R.id.shoepic7:
                startActivity(new Intent(getActivity(),shoe7.class));
                break;
            case R.id.shoepic8:
                startActivity(new Intent(getActivity(),shoe8.class));
                break;
            case R.id.shoepic9:
                startActivity(new Intent(getActivity(),shoe9.class));
                break;
            case R.id.shoepic10:
                startActivity(new Intent(getActivity(),shoe10.class));
                break;
        }
    }
}
