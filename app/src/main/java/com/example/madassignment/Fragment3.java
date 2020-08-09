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

    private ImageView kids1;
    private ImageView kids2;
    private ImageView kids3;
    private ImageView kids4;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container ,
                             @Nullable Bundle savedInstanceState){

        View v = inflater.inflate(R.layout.fragment3_layout,container,false);

        kids1 = (ImageView) v.findViewById(R.id.kidpic1);
        kids2 = (ImageView) v.findViewById(R.id.kidpic2);
        kids3 = (ImageView) v.findViewById(R.id.kidpic3);
        kids4 = (ImageView) v.findViewById(R.id.kidpic4);

        kids1.setOnClickListener(this);
        kids2.setOnClickListener(this);
        kids3.setOnClickListener(this);
        kids4.setOnClickListener(this);
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
        }
    }
}
