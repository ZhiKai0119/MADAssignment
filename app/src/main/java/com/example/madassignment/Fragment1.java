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

public class Fragment1 extends Fragment implements View.OnClickListener {

    private ImageView Men1;
    private ImageView Men2;
    private ImageView Men3;
    private ImageView Men4;

    public Fragment1() {
        //empty
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container ,
                             @Nullable Bundle savedInstanceState){

        View v = inflater.inflate(R.layout.fragment1_layout,container,false);

        Men1 = (ImageView) v.findViewById(R.id.menpic1);
        Men1.setOnClickListener(this);
        Men2 = (ImageView) v.findViewById(R.id.menpic2);
        Men2.setOnClickListener(this);
        Men3 = (ImageView) v.findViewById(R.id.menpic3);
        Men3.setOnClickListener(this);
        Men4 = (ImageView) v.findViewById(R.id.menpic4);
        Men4.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menpic1:
                startActivity(new Intent(getActivity(),men1.class));
                break;
            case R.id.menpic2:
                startActivity(new Intent(getActivity(),men2.class));
                break;
            case R.id.menpic3:
                startActivity(new Intent(getActivity(),men3.class));
                break;
            case R.id.menpic4:
                startActivity(new Intent(getActivity(),men4.class));
                break;
        }
    }
}
