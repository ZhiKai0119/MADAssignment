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

public class Fragment2 extends Fragment implements View.OnClickListener {

    private ImageView women1;
    private ImageView women2;
    private ImageView women3;
    private ImageView women4;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container ,
                             @Nullable Bundle savedInstanceState){

        View v = inflater.inflate(R.layout.fragment2_layout,container,false);

        women1 = (ImageView) v.findViewById(R.id.womenpic1);
        women2 = (ImageView) v.findViewById(R.id.womenpic2);
        women3 = (ImageView) v.findViewById(R.id.womenpic3);
        women4 = (ImageView) v.findViewById(R.id.womenpic4);

        women1.setOnClickListener(this);
        women2.setOnClickListener(this);
        women3.setOnClickListener(this);
        women4.setOnClickListener(this);

        return v;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.womenpic1:
                startActivity(new Intent(getActivity(),women1.class));
                break;
            case R.id.womenpic2:
                startActivity(new Intent(getActivity(),women2.class));
                break;
            case R.id.womenpic3:
                startActivity(new Intent(getActivity(),women3.class));
                break;
            case R.id.womenpic4:
                startActivity(new Intent(getActivity(),women4.class));
                break;
        }
    }
}