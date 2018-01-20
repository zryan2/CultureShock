package com.example.ryan.cultureshock;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                  //go to law activity
                    return true;
                case R.id.navigation_dashboard:
                    //Go to culture activity
                    Culture culture = new Culture();
                    android.app.FragmentManager manager = getFragmentManager();
//                    manager.beginTransaction().replace(R.id.contentLayout,
//                            culture, culture.getTag()).commit();
                    return true;
                case R.id.navigation_notifications:
                    //go to phrases activity

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

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
