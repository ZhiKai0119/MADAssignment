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

public class Fragment3 extends Fragment implements View.OnClickListener {

    private ImageView kids1, kids2, kids3, kids4, kids5, kids6, kids7, kids8, kids9, kids10;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container ,
                             @Nullable Bundle savedInstanceState){

        View v = inflater.inflate(R.layout.fragment3_layout,container,false);

        kids1 = (ImageView) v.findViewById(R.id.kidpic1);
        kids2 = (ImageView) v.findViewById(R.id.kidpic2);
        kids3 = (ImageView) v.findViewById(R.id.kidpic3);
        kids4 = (ImageView) v.findViewById(R.id.kidpic4);
        kids5 = (ImageView) v.findViewById(R.id.kidpic5);
        kids6 = (ImageView) v.findViewById(R.id.kidpic6);
        kids7 = (ImageView) v.findViewById(R.id.kidpic7);
        kids8 = (ImageView) v.findViewById(R.id.kidpic8);
        kids9 = (ImageView) v.findViewById(R.id.kidpic9);
        kids10 = (ImageView) v.findViewById(R.id.kidpic10);

        kids1.setOnClickListener(this);
        kids2.setOnClickListener(this);
        kids3.setOnClickListener(this);
        kids4.setOnClickListener(this);
        kids5.setOnClickListener(this);
        kids6.setOnClickListener(this);
        kids7.setOnClickListener(this);
        kids8.setOnClickListener(this);
        kids9.setOnClickListener(this);
        kids10.setOnClickListener(this);
        return v;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.kidpic1:
                startActivity(new Intent(getActivity(), kids1.class));
                break;
            case R.id.kidpic2:
                startActivity(new Intent(getActivity(), kids2.class));
                break;
            case R.id.kidpic3:
                startActivity(new Intent(getActivity(), kids3.class));
                break;
            case R.id.kidpic4:
                startActivity(new Intent(getActivity(), kids4.class));
                break;
            case R.id.kidpic5:
                startActivity(new Intent(getActivity(), kids5.class));
                break;
            case R.id.kidpic6:
                startActivity(new Intent(getActivity(), kids6.class));
                break;
            case R.id.kidpic7:
                startActivity(new Intent(getActivity(), kids7.class));
                break;
            case R.id.kidpic8:
                startActivity(new Intent(getActivity(), kids8.class));
                break;
            case R.id.kidpic9:
                startActivity(new Intent(getActivity(), kids9.class));
                break;
            case R.id.kidpic10:
                startActivity(new Intent(getActivity(), kids10.class));
                break;
        }
    }
}
