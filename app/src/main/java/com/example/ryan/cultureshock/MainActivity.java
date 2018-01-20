package com.example.ryan.cultureshock;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    Fragment selectedFragment = null;



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {



        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //go to country info fragment
                    CountryInfo countryInfo = new CountryInfo();
                    FragmentTransaction transaction4 = getSupportFragmentManager().beginTransaction();
                    selectedFragment = countryInfo;
                    transaction4.replace(R.id.contentLayout, selectedFragment);
                    transaction4.commit();
                    return true;
                case R.id.navigation_law:
                    //go to law fragment
                    Law law = new Law();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    selectedFragment = law;
                    transaction.replace(R.id.contentLayout, selectedFragment);
                    transaction.commit();
                    return true;
                case R.id.navigation_culture:
                    //Go to culture fragment
                    Culture culture = new Culture();
                    FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
                    selectedFragment = culture;
                    transaction2.replace(R.id.contentLayout, selectedFragment);
                    transaction2.commit();
                    return true;
                case R.id.navigation_phrases:
                    //go to phrases fragment
                    Phrases phrases = new Phrases();
                    FragmentTransaction transaction3 = getSupportFragmentManager().beginTransaction();
                    selectedFragment = phrases;
                    transaction3.replace(R.id.contentLayout, selectedFragment);
                    transaction3.commit();
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //default info after click country
        CountryInfo countryInfo = new CountryInfo();
        FragmentTransaction transaction4 = getSupportFragmentManager().beginTransaction();
        selectedFragment = countryInfo;
        transaction4.replace(R.id.contentLayout, selectedFragment);
        transaction4.commit();


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        //stop shifting englarging on navigation view bar
        BottomNavigationViewHelper.disableShiftMode(navigation);

    }


}
