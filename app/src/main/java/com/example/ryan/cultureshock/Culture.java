package com.example.ryan.cultureshock;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;



/**
 * A simple {@link Fragment} subclass.
 */
public class Culture extends Fragment implements View.OnClickListener {

    Fragment selectedFragment = null;
//    Button buttonBehavior;
//    Button buttonRD;
//    Button buttonFood;

public Culture() {
    // Required empty public constructor
}
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment_culture, container, false);
    Button a = (Button) v.findViewById(R.id.buttonBehavior);
    Button b = (Button) v.findViewById(R.id.buttonRD);
    Button c = (Button) v.findViewById(R.id.buttonFood);

    a.setOnClickListener(this);
    b.setOnClickListener(this);
    c.setOnClickListener(this);

    return v;
}
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonBehavior:
                //go to Behavior fragment
                Behavior behavior = new Behavior();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                selectedFragment = behavior;
                transaction.replace(R.id.contentLayout,behavior);
                transaction.commit();
                break;
            case R.id.buttonRD:
                //go to Regional Differences fragment
                RegDiff regDiff = new RegDiff();
                FragmentTransaction transaction2 = getFragmentManager().beginTransaction();
                selectedFragment = regDiff;
                transaction2.replace(R.id.contentLayout,regDiff);
                transaction2.commit();
                break;
            case R.id.buttonFood:
                //go to Food fragment
                Food food = new Food();
                FragmentTransaction transaction3 = getFragmentManager().beginTransaction();
                selectedFragment = food;
                transaction3.replace(R.id.contentLayout,food);
                transaction3.commit();
                break;

        }
    }
}

