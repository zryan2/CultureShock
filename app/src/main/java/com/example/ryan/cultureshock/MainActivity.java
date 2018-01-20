package com.example.ryan.cultureshock;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    Fragment selectedFragment = null;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //go to law activity
                    Law law = new Law();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    selectedFragment = law;
                    transaction.replace(R.id.contentLayout, selectedFragment);
                    transaction.commit();
                    return true;
                case R.id.navigation_dashboard:
                    //Go to culture activity
                    Culture culture = new Culture();
                    FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
                    selectedFragment = culture;
                    transaction2.replace(R.id.contentLayout, selectedFragment);
                    transaction2.commit();
                    return true;
                case R.id.navigation_notifications:
                    //go to phrases activity
                    Phrases phrases = new Phrases();
                    FragmentTransaction transaction3 = getSupportFragmentManager().beginTransaction();
                    selectedFragment = phrases;
                    transaction3.replace(R.id.contentLayout, selectedFragment);
                    transaction3.commit();
                    return true;
                //Hihi
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CountryInfo countryInfo = new CountryInfo();
        FragmentTransaction transaction4 = getSupportFragmentManager().beginTransaction();
        selectedFragment = countryInfo;
        transaction4.replace(R.id.contentLayout, selectedFragment);
        transaction4.commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


}
