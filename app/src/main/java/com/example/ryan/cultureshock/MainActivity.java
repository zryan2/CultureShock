package com.example.ryan.cultureshock;

import android.app.ActionBar;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    Fragment selectedFragment = null;

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {



        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            android.support.v7.app.ActionBar mActionBar = getSupportActionBar();

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //go to country info fragment
                    CountryInfo countryInfo = new CountryInfo();
                    FragmentTransaction transaction4 = getSupportFragmentManager().beginTransaction();
                    selectedFragment = countryInfo;
                    transaction4.replace(R.id.contentLayout, selectedFragment);
                    transaction4.commit();
                    mActionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#f9e143")));

                    return true;
                case R.id.navigation_law:
                    //go to law fragment
                    Law law = new Law();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    selectedFragment = law;
                    transaction.replace(R.id.contentLayout, selectedFragment);
                    transaction.commit();
                    mActionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#f44171")));

                    return true;
                case R.id.navigation_culture:
                    //Go to culture fragment
                    Culture culture = new Culture();
                    FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
                    selectedFragment = culture;
                    transaction2.replace(R.id.contentLayout, selectedFragment);
                    transaction2.commit();
                    mActionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1fb721")));

                    return true;
                case R.id.navigation_phrases:
                    //go to phrases fragment
                    Phrases phrases = new Phrases();
                    FragmentTransaction transaction3 = getSupportFragmentManager().beginTransaction();
                    selectedFragment = phrases;
                    transaction3.replace(R.id.contentLayout, selectedFragment);
                    transaction3.commit();
                    mActionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#4286f4")));

                    return true;
                case R.id.navigation_feed:
                    //go to phrases fragment
                    Comments comments = new Comments();
                    FragmentTransaction transaction5 = getSupportFragmentManager().beginTransaction();
                    selectedFragment = comments;
                    transaction5.replace(R.id.contentLayout, selectedFragment);
                    transaction5.commit();
                    mActionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#4286f4")));

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        //EXPANDABLE LIST
//        // get the listview
//        expListView = (ExpandableListView) findViewById(R.id.ELV);
//        // preparing list data
//        prepareListData();
//        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
//        // setting list adapter
//        expListView.setAdapter(listAdapter);
//
//        //default info after click country
//        CountryInfo countryInfo = new CountryInfo();
//        FragmentTransaction transaction4 = getSupportFragmentManager().beginTransaction();
//        selectedFragment = countryInfo;
//        transaction4.replace(R.id.contentLayout, selectedFragment);
//        transaction4.commit();



        //getting country name from list, change action title
        Bundle buttonText=getIntent().getExtras();
        if(buttonText==null){
            return;
        }
        String countryMessage=buttonText.getString("countryName");
        setTitle(countryMessage);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        //stop shifting englarging on navigation view bar
        BottomNavigationViewHelper.disableShiftMode(navigation);

    }

//    /*
//     * Preparing the list data
//     */
//    private void prepareListData() {
//        listDataHeader = new ArrayList<String>();
//        listDataChild = new HashMap<String, List<String>>();
//
//        // Adding child data
//        listDataHeader.add("Top 250");
//        listDataHeader.add("Now Showing");
//        listDataHeader.add("Coming Soon..");
//
//        // Adding child data
//        List<String> top250 = new ArrayList<String>();
//        top250.add("The Shawshank Redemption");
//        top250.add("The Godfather");
//        top250.add("The Godfather: Part II");
//        top250.add("Pulp Fiction");
//        top250.add("The Good, the Bad and the Ugly");
//        top250.add("The Dark Knight");
//        top250.add("12 Angry Men");
//
//        List<String> nowShowing = new ArrayList<String>();
//        nowShowing.add("The Conjuring");
//        nowShowing.add("Despicable Me 2");
//        nowShowing.add("Turbo");
//        nowShowing.add("Grown Ups 2");
//        nowShowing.add("Red 2");
//        nowShowing.add("The Wolverine");
//
//        List<String> comingSoon = new ArrayList<String>();
//        comingSoon.add("2 Guns");
//        comingSoon.add("The Smurfs 2");
//        comingSoon.add("The Spectacular Now");
//        comingSoon.add("The Canyons");
//        comingSoon.add("Europa Report");
//
//        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
//        listDataChild.put(listDataHeader.get(1), nowShowing);
//        listDataChild.put(listDataHeader.get(2), comingSoon);
//    }


}
